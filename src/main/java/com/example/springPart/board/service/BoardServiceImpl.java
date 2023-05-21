package com.example.springPart.board.service;

import com.example.springPart.board.controller.form.WriteBoardRequestForm;
import com.example.springPart.board.entity.Board;
import com.example.springPart.board.repository.BoardRepository;
import com.example.springPart.board.repository.ContentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    final private BoardRepository boardRepository;
    final private ContentRepository contentRepository;

    @Override
    @Transactional
    public List<Board> list() {
            List<Board> boardList =
                    boardRepository.findAll(Sort.by(Sort.Direction.DESC, "boardId"));
            log.info(String.valueOf(boardList.get(0).getContent().getContent()));

        return boardList;
    }

    @Override
    public Board writeBoard(WriteBoardRequestForm requestForm) {
        Board board = requestForm.toBoard();

        contentRepository.save(board.getContent());
        return boardRepository.save(board);
    }

    @Override
    public void delete(Long boardId) {
        Optional<Board> maybeBoard = boardRepository.findById(boardId);
        if(maybeBoard.isEmpty()) {
            log.debug("존재하지 않는 게시물 입니다.");
            return;
        }
        Board board = maybeBoard.get();
        boardRepository.delete(board);
    }

    @Override
    public Board read(Long boardId) {
        Optional<Board> maybeBoard = boardRepository.findById(boardId);
        if(maybeBoard.isEmpty()) {
            log.debug("존재하지 않는 게시물 입니다.");
            return null;
        }
        return maybeBoard.get();
    }

    @Override
    @Transactional
    public Board modify(Long boardId, String title, String content) {
        Optional<Board> maybeBoard = boardRepository.findById(boardId);
        if(maybeBoard.isEmpty()) {
            log.debug("존재하지 않는 게시물 입니다.");
            return null;
        }
        Board board = maybeBoard.get();
        board.setTitle(title);
        log.info(String.valueOf(board));
        board.getContent().setContent(content);
        contentRepository.save(board.getContent());
        Board modifinedBoard = boardRepository.save(board);
        log.info(String.valueOf(modifinedBoard));
        return modifinedBoard;
        //return null;
    }
}
