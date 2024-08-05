package com.ohgiraffers.example.member.repository;

import com.ohgiraffers.example.member.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
// 멤버를 상속받고 멤버에 있는 ID를 인티저로 가져오겠다.

    Optional<Member> findMemberByMemberId(String memberId);
}
