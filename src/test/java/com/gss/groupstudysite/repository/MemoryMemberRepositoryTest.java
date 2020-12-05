package com.gss.groupstudysite.repository;

import com.gss.groupstudysite.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    /*
     @AfterEach 한번에 여러 테스트를 실행하면 메모리나 DB에 직전 테스트 결과가 남아 있을 수 있다.
     그렇기 때문에 각 테스트가 끝나고 @AfterEach를 사용한 함수가 실행되어 메모리나 DB를 초기 상태로 돌려줄 수 있다.
     !! 테스트는 각각 독립적으로 실행되어야 하고 테스트 순서에 의존 관계가 있으면 좋은 테스트가 아니다.
     */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        // given
        Member member = new Member();
        member.setEmail("spring@gmail.com");

        // when
        repository.save(member);

        // then
        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByEmail() {
        // given
        Member member1 = new Member();
        member1.setEmail("spring1@gmail.com");
        repository.save(member1);

        Member member2 = new Member();
        member2.setEmail("spring2@gmail.com");
        repository.save(member2);

        // when
        Member result = repository.findByEmail("spring1@gmail.com").get();

        // then
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        // given
        Member member1 = new Member();
        member1.setEmail("spring1@gmail.com");
        repository.save(member1);

        Member member2 = new Member();
        member2.setEmail("spring2@gmail.com");
        repository.save(member2);

        // when
        List<Member> result = repository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
    }
}
