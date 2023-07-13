package com.example.demo.service;

import com.example.demo.controller.dto.SignUpDto.SignUpRequestDto;
import com.example.demo.controller.dto.SignUpDto.SignUpResponseDto;
import com.example.demo.entity.Member;
import com.example.demo.entity.MemberStatus;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service  //빈으로 등록해주는 것 중 하나의 annotation
@RequiredArgsConstructor // 맴버 중에 final, not null 인 것들에 대한 생성자
public final class DefaultAuthenticationService implements AuthenticationService {

    private final MemberRepository memberRepository; // null 이 정상,, 하지만 스프링은 bean 을 넣어줌

    @Override
    public Member signUp(Member member) { //확장성
        return memberRepository.save(member);
    }

    @Override
    public SignUpResponseDto signUp(SignUpRequestDto dto, MemberStatus status) { // 편의성
        Member member = Member.builder() //DTO -> member 로 변환
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
