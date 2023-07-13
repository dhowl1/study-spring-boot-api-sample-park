package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String username;

    public String password;

    public String nickname;

    public String email;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    public MemberStatus status = MemberStatus.PENDING;
}