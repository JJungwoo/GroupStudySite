package com.gss.groupstudysite.service;

import com.gss.groupstudysite.domain.Member;
import com.gss.groupstudysite.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) throws IllegalStateException {
        //try {
            validateDuplicateMember(member); // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        //} catch (IllegalStateException e) {
            //throw new IllegalStateException("이미 존재하는 회원입니다.");
        //}

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 이메일 정보로 사용자 조회
     */
    public Optional<Member> findOne(String memberEmail) {
        return memberRepository.findByEmail(memberEmail);
    }
}
