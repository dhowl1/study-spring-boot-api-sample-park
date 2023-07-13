package com.example.demo.service;

import com.example.demo.controller.dto.SignUpDto.SignUpRequestDto;
import com.example.demo.controller.dto.SignUpDto.SignUpResponseDto;
import com.example.demo.entity.Member;
import com.example.demo.entity.MemberStatus;

public interface AuthenticationService {
    Member signUp(Member member);
    SignUpResponseDto signUp(SignUpRequestDto dto, MemberStatus status);

}
