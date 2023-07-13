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
    // Get, Post, Put, Delete, Patch -- method get/post/.... <from action "" method ""> XHR(AJAX)..(API)

    private final AuthenticationService authenticationService; //<- bean 주입, 선언은 인터페이스, 주입되는 건 클레스의 빈
    @PostMapping("/sign-up")
    public SignUpResponseDto signUp(@RequestBody @Valid SignUpRequestDto body) {
        return authenticationService.signUp(body, MemberStatus.ACTIVE);
    }

}
