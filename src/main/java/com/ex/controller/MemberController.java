package com.ex.controller;

import com.ex.domain.Member;
import com.ex.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
  private final MemberService memberService;

  @Autowired//생성자 주입 DI
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("members/new")
  public String createForm(){
    return "members/createMemberForm";
  }
  @PostMapping("members/new")
  public String create(MemberForm form){
    Member member = new Member();
    member.setName(form.getName());
    memberService.join(member);
    System.out.println("name : " + member.getName());
    return "redirect:/";
  }
  @GetMapping("members")
  public String memberList(Model model){
    List<Member> members = memberService.findMembers();
    model.addAttribute("members", members);
    return "members/memberList";
  }
}
