package com.gss.groupstudysite.service;

import com.gss.groupstudysite.domain.Member;
import com.gss.groupstudysite.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {
    /**
     * 테스트 코드 작성시 테스트 하기 위한 클래스에서 command+shift+t를 누르면 빠르게 추가가 가능하다.
     */

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setNickname("hello");
        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getNickname(), findMember.getNickname());
    }

    @Test
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setEmail("spring@gmail.com");

        Member member2 = new Member();
        member2.setEmail("spring@gmail.com");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}
