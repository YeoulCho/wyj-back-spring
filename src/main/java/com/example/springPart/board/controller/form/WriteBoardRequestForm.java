package com.example.springPart.board.controller.form;

import com.example.springPart.board.entity.Board;
import com.example.springPart.board.entity.Content;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WriteBoardRequestForm {
    final Long memberId;
    @Getter
    final String title;
    @Getter
    final String content;

    public Board toBoard() {
        Content content = new Content(this.content);
        return new Board(memberId, title, content);
    }
}
