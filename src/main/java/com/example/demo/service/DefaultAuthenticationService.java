package com.example.demo.service;

import com.example.demo.controller.dto.SignUpDto.SignUpRequestDto;
import com.example.demo.controller.dto.SignUpDto.SignUpResponseDto;
import com.example.demo.entity.Member;
import com.example.demo.entity.MemberStatus;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service 
@RequiredArgsConstructor 
public final class DefaultAuthenticationService implements AuthenticationService {

    private final MemberRepository memberRepository; 

    @Override
    public Member signUp(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public SignUpResponseDto signUp(SignUpRequestDto dto, MemberStatus status) { 
        Member member = Member.builder() 
                .username(dto.username())
                .password(dto.password())
                .nickname(dto.nickname())
                .email(dto.email())
                .status(status)
                .build();

        boolean result = signUp(member) != null; //17

        return SignUpResponseDto.builder()
                .success(result)
                .build();
    }
}
