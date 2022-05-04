package com.example.card.controller;

import com.example.card.domain.Board;
import com.example.card.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

    @RequestMapping(method = RequestMethod.GET, path="/board/cnt")
    public ResponseEntity countBoards() {
        return ResponseEntity.ok(boardService.countBoards());
    }

    @RequestMapping(method = RequestMethod.GET, path= {"/board", "/board/{seq}"})
    public ResponseEntity readBoards(@PathVariable(required = false) Integer seq) {
        if (seq == null) {
            List<Board> boardList = boardService.readBoards();
            return ResponseEntity.ok(boardList);
        }

        return ResponseEntity.ok(boardService.readBoard(seq));
    }

    @RequestMapping(method = RequestMethod.POST, path="/board")
    public ResponseEntity createBoard(@RequestBody(required = true) Board requestBoard) {
        Board board = boardService.createBoard(requestBoard);
        return ResponseEntity.ok(board);
    }

    @RequestMapping(method = RequestMethod.PUT, path="/board")
    public ResponseEntity updateBoard(@RequestBody(required = true) Board requestBoard) {
        Board board = boardService.updateBoard(requestBoard.getSeq(), requestBoard);
        return ResponseEntity.ok(board);
    }

    @RequestMapping(method = RequestMethod.DELETE, path="/board")
    public boolean deleteBoard(@RequestBody Board requestBoard) {

        Board board = boardService.readBoard(requestBoard.getSeq());

        if (board.getPass().equals(requestBoard.getPass())) {
            boardService.deleteBoard(requestBoard.getSeq());

            if (boardService.readBoard(requestBoard.getSeq()) == null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
