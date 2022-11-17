package com.example.demo.auth;

import com.example.demo.auth.dtos.RegisterDTO;
import com.example.demo.auth.utils.EmailValidator;
import com.example.demo.mailing.EmailSender;
import com.example.demo.mailing.templates.EmailTemplates;
import com.example.demo.user.UserEntity;
import com.example.demo.user.UserRole;
import com.example.demo.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserService userService;
    private final EmailValidator emailValidator;
    private final EmailSender emailSender;
    private final EmailTemplates emailTemplates;

    public String register(RegisterDTO registerDto) {
        boolean isValidEmail = emailValidator.test(registerDto.getEmail());
        if (!isValidEmail) throw new IllegalStateException("Email is not valid");

        String token = userService.singUp(
                new UserEntity(
                        registerDto.getFirstName(),
                        registerDto.getLastName(),
                        registerDto.getEmail(),
                        registerDto.getPassword(),
                        UserRole.USER
                )
        );

        String link = "http://localhost:8080/api/v1/registration/confirm?token=" + token;

        emailSender.send(
                registerDto.getEmail(),
                emailTemplates.buildEmail(registerDto.getFirstName(), link));

        return token;
    }
}
