package com.ohgiraffers.example.member.service;

import com.ohgiraffers.example.board.model.entity.Board;
import com.ohgiraffers.example.board.repository.BoardRepository;
import com.ohgiraffers.example.member.model.dto.SignupDTO;
import com.ohgiraffers.example.member.model.entity.Member;
import com.ohgiraffers.example.member.model.entity.RoleType;
import com.ohgiraffers.example.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor // 기본 생성자 생성
@Slf4j
public class MemberService {

    // 멤버 레파지토리를 주입 해줘야 저장할 수 있음
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final BoardRepository boardRepository;

    public void register(SignupDTO signupDTO) {
        Member member = Member.builder()
                .memberId(signupDTO.getMemberId())
                .password(passwordEncoder.encode(signupDTO.getPassword())) // 비밀번호 암호화
                .name(signupDTO.getName())
                .role(RoleType.valueOf(signupDTO.getRole())) // USER, ADMIN
                .build();
        Member saveMember = memberRepository.save(member);

        log.info("저장된 회원 : {}", saveMember.getMemberNo());

    }

    //memberId member를 찾아오는 기능
    public Member findMemberById(String memberId) {
        Member member = memberRepository.findMemberByMemberId(memberId)
                .orElseThrow(() -> new NoSuchElementException("회원을 찾을 수 없습니다."));

        return member;
    }

    public Board findBoardById(int boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalArgumentException("암튼 찾을 수 없습니다."));

        return board;
    }
}
