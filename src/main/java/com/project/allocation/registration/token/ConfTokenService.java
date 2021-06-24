package com.project.allocation.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfTokenService {
    private final ConfTokenRepo confTokenRepo;

    public void saveConfirmationToken(ConfirmationToken token){
        confTokenRepo.save(token);
    }

    public Optional<ConfirmationToken> getToken(String token) {
        return confTokenRepo.findByToken(token);
    }

    public int setConfirmedAt(String token) {
        return confTokenRepo.updateConfirmedAt(
                token, LocalDateTime.now());
    }
}
