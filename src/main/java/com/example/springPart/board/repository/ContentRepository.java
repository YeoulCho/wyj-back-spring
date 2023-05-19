package com.example.springPart.board.repository;

import com.example.springPart.board.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
