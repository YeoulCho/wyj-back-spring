package com.example.springPart.board.repository;

import com.example.springPart.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
//    Optional<Board> findById(Long id);
}
