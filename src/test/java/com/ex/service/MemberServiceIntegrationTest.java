package com.ex.service;

import com.ex.domain.Member;
import com.ex.repository.MemberRepository;
import com.ex.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MemberServiceIntegrationTest {
  @Autowired MemberService memberService;
  @Autowired MemberRepository memberRepository;

  @Test
  @Transactional
  public void joinTest() throws Exception{
    //given
    Member member = new Member();
    member.setName("arin");

    //when
    int inputId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(inputId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }
  @Test
  public void 중복회원_예외() throws Exception{
//Given
    Member member1 = new Member();
    member1.setName("spring");
    Member member2 = new Member();
    member2.setName("spring");
//When
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class,
        () -> memberService.join(member2));//예외가 발생해야 한다.
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