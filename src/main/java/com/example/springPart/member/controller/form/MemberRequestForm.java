package com.example.springPart.member.controller.form;

import com.example.springPart.member.entity.Member;
import com.example.springPart.member.entity.MemberRole;
import com.example.springPart.member.entity.Role;
import com.example.springPart.member.entity.RoleType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class MemberRequestForm {

    final private String email;
    final private String password;
    final private RoleType roleType;
    final private Integer businessNumber;

    public Member toMember() {
        return new Member(email, password);
    }

    public MemberRole toMemberRole(Member member){
        return new MemberRole(member, new Role(roleType), businessNumber);
    }
}
