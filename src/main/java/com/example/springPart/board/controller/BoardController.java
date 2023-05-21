package com.example.springPart.board.controller;

import com.example.springPart.board.controller.form.WriteBoardRequestForm;
import com.example.springPart.board.entity.Board;
import com.example.springPart.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    final private BoardService boardService;
    @PostMapping("/write-board")
    public void writeBoard(@RequestBody WriteBoardRequestForm requestForm) {
        log.info("writeBoard()"+ requestForm);
        boardService.writeBoard(requestForm);
        //Long boardId = boardService.writeBoard(requestForm).getBoardId();
        //return boardId;
    }

    @GetMapping("/list-board")
    @Transactional
    public List<Board> listBoard(){
        log.info("listBoard()");

        List<Board> boardList = boardService.list();
        log.info("boardList()");

        return boardList;
    }
}
