package com.example.springPart;

import com.example.springPart.board.controller.form.WriteBoardRequestForm;
import com.example.springPart.board.entity.Board;
import com.example.springPart.board.repository.BoardRepository;
import com.example.springPart.board.service.BoardService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class boardTest {
    @Autowired

    BoardService boardService;

    @Test
    @DisplayName("게시글을 작성 합니다.")
    void 게시글_작성() {
        final Long AUTHORID = 1L;
        final String TITLE = "오리가 추우면?";
        final String CONTENT = "언덕";

        WriteBoardRequestForm writeBoardRequestForm = new WriteBoardRequestForm(AUTHORID, TITLE, CONTENT);
        Board writedBoard =  boardService.writeBoard(writeBoardRequestForm);
        System.out.println(writedBoard);

        assertEquals(AUTHORID, writedBoard.getAuthor());
        System.out.println(writedBoard.getAuthor());
        assertEquals(TITLE, writedBoard.getTitle());
        System.out.println(writedBoard.getTitle());
        assertEquals(CONTENT, writedBoard.getContent().getContent());
    }

//    @Test
//    @DisplayName("게시글을 삭제 합니다.")
//    void 게시글_삭제() {
//        final Long BOARD_ID = 5L;
//        boardService.delete(BOARD_ID);
//    }

    @Test
    @Transactional
    @DisplayName("게시글을 조회 합니다.")
    void 게시글_조회() {
        final Long BOARD_ID = 1L;
        Board readBoard = boardService.read(BOARD_ID);
        System.out.println("Author : "+ readBoard.getAuthor());
        System.out.println("Title : "+ readBoard.getTitle());
        System.out.println("Content : "+ readBoard.getContent().getContent());

        assertEquals(BOARD_ID, readBoard.getId());
    }

    @Test
    @DisplayName("게시글을 수정 합니다.")
    void 게시글_수정() {
        final Long BOARD_ID = 1L;
        final String TITLE1 = "오리가 장구를치면2?";
        final String CONTENT = "덩기덕쿵덕2";

        Board modifyedBoard = boardService.modify(BOARD_ID, TITLE1, CONTENT);
        assertEquals(TITLE1,modifyedBoard.getTitle());
//        assertEquals(BOARD_ID, modifyBoard.getId());
//        System.out.println(modifyBoard.getId());
//        assertEquals(TITLE, modifyBoard.getTitle());
//        System.out.println(modifyBoard.getTitle());
//        assertEquals(CONTENT, modifyBoard.getContent().getContent());
//        System.out.println(modifyBoard.getContent().getContent());
    }
}
