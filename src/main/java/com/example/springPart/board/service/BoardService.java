package com.example.springPart.board.service;

import com.example.springPart.board.controller.form.ContentResponseForm;
import com.example.springPart.board.controller.form.WriteBoardRequestForm;
import com.example.springPart.board.entity.Board;

import java.util.List;

public interface BoardService {
    public Board writeBoard(WriteBoardRequestForm requestForm);
    public void delete(Long boardId);

    public ContentResponseForm read(Long boardId) throws InterruptedException;

    Board modify(Long boardId, String title, String content);

    List<Board> list();
}
