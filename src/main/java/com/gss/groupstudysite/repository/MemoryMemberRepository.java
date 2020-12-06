package com.gss.groupstudysite.repository;

import com.gss.groupstudysite.domain.Member;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        System.out.println(member.getId()+" "+member.getEmail());
        store.put(member.getId(), member);
        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
                .filter(member -> member.getEmail().equals(email))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
