package com.project.allocation.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "api/register")
@AllArgsConstructor
public class RegistrationController {


    private final RegistrationService registrationService;

    @PostMapping
    public String register (@ModelAttribute RegistrationRequest request, Model model){
        model.addAttribute("request",request);
        System.out.println("-------");
        System.out.println(request);
                //registrationService.register(request);
        return "login";
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @GetMapping()
    public String showRegister(Model model){
        model.addAttribute("request", new RegistrationRequest());
        return "register";
    }
}
