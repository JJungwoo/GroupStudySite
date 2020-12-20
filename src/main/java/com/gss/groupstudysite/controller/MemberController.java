package com.gss.groupstudysite.controller;

import com.gss.groupstudysite.domain.Member;
import com.gss.groupstudysite.dto.MemberDto;
import com.gss.groupstudysite.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @RequestMapping(value = "/members/new", method = RequestMethod.POST)
    public String create(@RequestBody MemberDto memberDto) {

        Member member = new Member();
        member.setNickname(memberDto.getNickname());
        member.setEmail(memberDto.getEmail());
        member.setSubscription(memberDto.getSubscription());

        System.out.println("create func debug:"+memberDto.toString());

        try {
            memberService.join(member);
            System.out.println("success");
            return "redirect:/";
        } catch (IllegalStateException e){
            return e.getMessage();
        }
    }

    @GetMapping(value = "/members")
    public String selectAll(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        for(Member memberList: members) {
            System.out.println(memberList.toString());
        }
        return "members/memberList";
    }

}
