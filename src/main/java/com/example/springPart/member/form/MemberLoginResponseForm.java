package com.example.springPart.member.form;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@Getter
@RequiredArgsConstructor
public class MemberLoginResponseForm {
    final private UUID userToken;
}
