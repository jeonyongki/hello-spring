package com.ex.repository;

import com.ex.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemberRepositoryTest {
  MemberRepositoryImpl memberRepository = new MemberRepositoryImpl();

  @AfterEach
  public void afterEach(){
    memberRepository.clearStore();
  }
  @Test
  public void insertTest(){
    Member member = new Member();
    member.setName("arin");
    memberRepository.insert(member);
    Member result = memberRepository.findById(member.getId()).get();

//    Assertions.assertEquals(member, result);//객체비교
    assertThat(member).isEqualTo(result);
  }
  @Test
  public void findByNameTest(){
    Member member1 = new Member();
    member1.setName("spring1");
    memberRepository.insert(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    memberRepository.insert(member2);

    Member result = memberRepository.findByName("spring1").get();

    assertThat(result).isEqualTo(member1);
  }

  @Test
  public void findAllTest(){
    Member member1 = new Member();
    member1.setName("spring1");
    memberRepository.insert(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    memberRepository.insert(member2);

    List<Member> result = memberRepository.findAll();
    assertThat(result.size()).isEqualTo(2);
  }
}
