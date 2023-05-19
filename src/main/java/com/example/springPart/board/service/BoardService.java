package com.example.springPart.board.service;

import com.example.springPart.board.controller.form.WriteBoardRequestForm;
import com.example.springPart.board.entity.Board;

public interface BoardService {
    public Board writeBoard(WriteBoardRequestForm requestForm);
    public void delete(Long boardId);

    public Board read(Long boardId);

    Board modify(Long boardId, String title, String content);
}
