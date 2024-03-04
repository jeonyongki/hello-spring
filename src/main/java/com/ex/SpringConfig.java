package com.ex;

import com.ex.repository.JpaMemberRepository;
import com.ex.repository.MemberRepository;
import com.ex.repository.MemberRepositoryJdbcTemplate;
import com.ex.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//  private EntityManager em;
//  @Autowired
//  public SpringConfig(EntityManager em) {
//    this.em = em;
//  }
  private DataSource dataSource;
  @Autowired
  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository(){
//    return new JpaMemberRepository(em);
    return new MemberRepositoryJdbcTemplate(dataSource);
  }
}
