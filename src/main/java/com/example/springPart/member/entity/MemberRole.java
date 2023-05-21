package com.example.springPart.member.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class MemberRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(fetch = FetchType.LAZY )
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    private Integer businessNumber;

    public MemberRole(Member member, Role role, Integer businessNumber) {
        this.role = role;
        this.businessNumber = businessNumber;
        this.member = member;
    }
}
