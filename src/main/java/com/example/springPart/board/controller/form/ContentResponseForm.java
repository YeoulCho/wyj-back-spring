package com.example.springPart.board.controller.form;

import com.example.springPart.board.entity.Board;
import com.example.springPart.board.entity.Content;
import lombok.Getter;
import lombok.Setter;

public class ContentResponseForm {
    @Setter
    @Getter
    String content;
    @Setter
    @Getter
    Board board;
}
