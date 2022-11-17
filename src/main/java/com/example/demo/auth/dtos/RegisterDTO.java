package com.example.demo.auth.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class RegisterDTO {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
}
