package com.ex.service;

import com.ex.domain.Member;
import com.ex.repository.MemberRepository;
import com.ex.repository.MemberRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
  MemberService memberService;
  MemberRepositoryImpl memberRepository;

  @BeforeEach
  public void beforeEach(){
    memberRepository = new MemberRepositoryImpl();
    memberService = new MemberService(memberRepository);
  }

  @AfterEach
  public void afterEach(){
    memberRepository.clearStore();
  }
  @Test
  void joinTest() {
    //given
    Member member = new Member();
    member.setName("arin");

    //when
    Long inputId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(inputId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }
  @Test
  public void 중복회원_예외(){
    //given
    Member member1 = new Member();
    member1.setName("arin");
    Member member2 = new Member();
    member2.setName("arin");

    //when
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));

    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


//    try {
//      memberService.join(member2);
//      fail();
//    } catch (Exception e) {
//      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
////      e.printStackTrace();
//    }

    //then
  }
  @Test
  void findMembersTest() {
  }

  @Test
  void findOneTest() {
  }
}