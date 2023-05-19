package com.example.springPart.member;


import com.example.springPart.member.form.MemberLoginRequestForm;
import com.example.springPart.member.form.MemberLoginResponseForm;
import com.example.springPart.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
public class Member {
    @Autowired
    private MemberService memberService;
    @Test
    @DisplayName("로그인하기")
    void 로그인하기(){
        final String email="test@test.com";
        final String password="123";
        MemberLoginRequestForm requestForm = new MemberLoginRequestForm(email,password);
        MemberLoginResponseForm responseForm = memberService.login(requestForm);

        //assertEquals(email,requestForm.getEmail());
        assertTrue(responseForm.getUserToken() !=null);


    }
}
