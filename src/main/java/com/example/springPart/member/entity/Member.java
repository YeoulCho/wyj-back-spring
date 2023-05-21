package com.example.springPart.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String email;
    @Getter
    private String password;
    @OneToOne(mappedBy = "member", fetch = FetchType.LAZY)
    private MemberRole memberRole;

    public Member(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Member(String email, String password, MemberRole memberRole) {
        this.email = email;
        this.password = password;
        this.memberRole = memberRole;
    }

}
