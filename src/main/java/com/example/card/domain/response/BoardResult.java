package com.example.card.domain.response;

import com.example.card.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Date;

@Value
@AllArgsConstructor
public class BoardResult {

    private int seq;
    private String id;
    private String pass;
    private String content;
    private LocalDateTime regdate;

    public static BoardResult of(Board board) {
        return new BoardResult(board.getSeq(), board.getId(), board.getPass(), board.getContent(), board.getRegdate());
    }
}
