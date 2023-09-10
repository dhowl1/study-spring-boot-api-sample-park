package com.example.demo.controller.dto;

import lombok.Builder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public record SignUpDto() {
    public record SignUpRequestDto(
            @NotBlank 
            @Pattern(regexp = "^[a-z]+[a-z0-9]{5,30}$")
            String username,
            @NotBlank
            @Pattern(regexp = "^(?=.*[a-zA-Z])((?=.*\\d)(?=.*\\W)).{8,100}$")
            String password,
            @NotBlank
            @Pattern(regexp = "^[a-zA-Z가-힣0-9]{3,8}$")
            String nickname,
            @NotBlank
            @Email
            String email
    ){}
    @Builder
    public record SignUpResponseDto(
            Boolean success
    ){}
}
