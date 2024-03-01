package com.ex.service;

import com.ex.domain.Member;
import com.ex.repository.MemberRepository;
import com.ex.repository.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
public class MemberService {

  private final MemberRepository memberRepository;
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /*
* 회원 가입
* */
  public Long join(Member member){
    validateDuplicateMember(member);//중복회원검증
    memberRepository.insert(member);
    return member.getId();
  }
  //중복회원검증 외부메서드
  private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
        .ifPresent(m -> {
          throw new IllegalStateException("이미 존재하는 회원입니다.");
    });
  }
  /*
  * 전체회원조회
  * */
  public List<Member> findMembers(){
    return memberRepository.findAll();
  }
  public Optional<Member> findOne(Long memberId){
    return memberRepository.findById(memberId);
  };
}
