package com.ll.medium.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ll.medium.domain.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
