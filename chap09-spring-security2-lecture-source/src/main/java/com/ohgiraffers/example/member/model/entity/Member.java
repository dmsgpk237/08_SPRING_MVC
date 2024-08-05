package com.ohgiraffers.example.member.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberNo;
    private String memberId;
    private String password;
    private String name;

    @Enumerated(EnumType.STRING) // 스트링 타입으로, 오디널로 인덱스로 받아올 수도 있는데 잘 안 쓴다.
    private RoleType role;
}
