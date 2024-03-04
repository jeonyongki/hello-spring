package com.ex.repository;

import com.ex.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*
* interface 가 인터페이스를 확장할떄 extends <타입지정>, 다중상속
* */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Integer>, MemberRepository {
  @Override
  Optional<Member> findByName(String name);
}

