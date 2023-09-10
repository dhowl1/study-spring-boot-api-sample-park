package com.example.demo.controller;

import com.example.demo.controller.dto.SignUpDto.SignUpRequestDto;
import com.example.demo.controller.dto.SignUpDto.SignUpResponseDto;
import com.example.demo.entity.MemberStatus;
import com.example.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public final class AuthenticationController {
    

    private final AuthenticationService authenticationService; 
    @PostMapping("/sign-up")
    public SignUpResponseDto signUp(@RequestBody @Valid SignUpRequestDto body) {
        return authenticationService.signUp(body, MemberStatus.ACTIVE);
    }

}
