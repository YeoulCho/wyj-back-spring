package com.example.springPart.member.repository;

import com.example.springPart.member.entity.Role;
import com.example.springPart.member.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}
