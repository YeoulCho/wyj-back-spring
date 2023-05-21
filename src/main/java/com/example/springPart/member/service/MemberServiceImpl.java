package com.example.springPart.member.service;

import com.example.springPart.member.entity.Member;
import com.example.springPart.member.entity.MemberRole;
import com.example.springPart.member.entity.Role;
import com.example.springPart.member.controller.form.MemberLoginRequestForm;
import com.example.springPart.member.controller.form.MemberLoginResponseForm;
import com.example.springPart.member.controller.form.MemberRequestForm;
import com.example.springPart.member.repository.MemberRepository;
import com.example.springPart.member.repository.MemberRoleRepository;
import com.example.springPart.member.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    final private MemberRepository memberRepository;
    final private MemberRoleRepository memberRoleRepository;
    final private RoleRepository roleRepository;

    @Override
    public MemberLoginResponseForm login(MemberLoginRequestForm requestForm) {
        Optional<Member> correctedMember =
                memberRepository.findByEmail(requestForm.getEmail());
        if (correctedMember.isEmpty()) {
            log.info("로그인 실패");
            return new MemberLoginResponseForm(null);
        }
        Member member = correctedMember.get();
        if (member.getPassword().equals(requestForm.getPassword())) {
            log.info("로그인 성공");
            return new MemberLoginResponseForm(UUID.randomUUID());
        }
        return new MemberLoginResponseForm(null);
    }

    @Override
    public Boolean register(MemberRequestForm requestForm) {
        //가입한 회원이면?
        final Optional<Member> maybeMember = memberRepository.findByEmail(requestForm.getEmail());
        if(maybeMember.isPresent()) {
            log.debug("이미 등록된 회원이라 가입할 수 없습니다.");
            return false;
        }
        final Member member = requestForm.toMember();
        memberRepository.save(member);
        final Role role = roleRepository.findByRoleType(requestForm.getRoleType()).get();
        final MemberRole memberRole = new MemberRole(member, role, requestForm.getBusinessNumber());
        memberRoleRepository.save(memberRole);
        return true;
    }

    @Override
    public void delete(MemberLoginRequestForm requestForm) {
        Optional<Member> isMember= memberRepository.findByEmail(requestForm.getEmail());
        if(isMember.isEmpty()){
            log.debug("이미 삭제된 회원입니다");
        }
        Member member = isMember.get();
        memberRepository.delete(member);
    }
}
