package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;
    @Autowired  //MemberSerivce와 연결해주기 위해서 사용하는 Autowired!!! 이 방법이 Dependency Injection! DI!!
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
