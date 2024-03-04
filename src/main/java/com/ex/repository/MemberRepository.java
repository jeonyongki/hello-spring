package com.ex.repository;


import com.ex.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
  Member insert(Member member);
  Optional<Member> findById(int id);
  Optional<Member> findByName(String name);
  List<Member> findAll();
}
