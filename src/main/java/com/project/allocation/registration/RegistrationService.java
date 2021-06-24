package com.project.allocation.registration;

import com.project.allocation.appuser.AppUser;
import com.project.allocation.appuser.AppUserRole;
import com.project.allocation.appuser.AppUserService;
import com.project.allocation.registration.token.ConfTokenService;
import com.project.allocation.registration.token.ConfirmationToken;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {

    private AppUserService appUserService;
    private ConfTokenService confTokenService;
    private EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
       boolean isValidEmail =  emailValidator.test(request.getEmail());
       if (!isValidEmail){
           throw new IllegalStateException("Email not valid");
       }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstname(),
                        request.getLastname(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());
        return "confirmed";
    }
}
