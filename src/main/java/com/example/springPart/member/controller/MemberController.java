package com.example.springPart.member.controller;


import com.example.springPart.member.controller.form.MemberRequestForm;
import com.example.springPart.member.entity.Member;
import com.example.springPart.member.controller.form.MemberLoginRequestForm;
import com.example.springPart.member.controller.form.MemberLoginResponseForm;
import com.example.springPart.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    final private MemberService memberService;

    @PostMapping("/login")
    public MemberLoginResponseForm isLogin(@RequestBody MemberLoginRequestForm loginRequestForm){
        MemberLoginResponseForm memberLoginResponseForm =
                memberService.login(loginRequestForm);
        return memberLoginResponseForm;
    }
    @DeleteMapping("/member")
    public void deleteMember(@RequestBody MemberLoginRequestForm loginRequestForm){
        memberService.delete(loginRequestForm);
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody MemberRequestForm memberRequestForm) {
        System.out.println(memberRequestForm);
        memberService.register(memberRequestForm);

    }

}
