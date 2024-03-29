package com.ex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
  @GetMapping("hello")
  public String hello(Model model){
    model.addAttribute("data", "greeting Hello !!!");
    return "hello";
  }

  @GetMapping("hello-mvc")
  public String helloMvc(@RequestParam("name")String name, Model model){
    model.addAttribute("name", name);
    return "hello-template";
  }
  //API방식 객체를 전달
  @GetMapping("hello-string")
  @ResponseBody
  public String helloString(@RequestParam("name")String name){
    System.out.println("helloString() : JSON 변환방식");
    return "hello "+name;// "hello spring"
  }

  @GetMapping("hello-api")
  @ResponseBody
  public Hello helloApi(@RequestParam("name")String name){
    System.out.println("helloApi() : Hello객체 전달");
    Hello hello = new Hello();
    hello.setName(name);
    return hello;
  }

  //중첩클래스
  static class Hello{
    private String name;

    public void setName(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }
  }
}
