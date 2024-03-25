package com.hello.servlet.domain.member;

import com.hello.servlet.basic.domain.member.Member;
import com.hello.servlet.basic.domain.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("hello", 20);

        // when
        Member savedMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(member.getId());
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        // given
        Member member1 = new Member("member1", 21);
        Member member2 = new Member("member2", 22);
        Member savedMember1 = memberRepository.save(member1);
        Member savedMember2 = memberRepository.save(member2);

        // when
        List<Member> members = memberRepository.findAll();

        // then
        Member findMember1 = memberRepository.findById(member1.getId());
        Member findMember2 = memberRepository.findById(member2.getId());
        assertThat(members.size()).isEqualTo(2);
        assertThat(findMember1).isNotEqualTo(findMember2);

    }

}
