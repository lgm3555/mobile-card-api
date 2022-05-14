package com.example.card.controller;

import com.example.card.domain.Board;
import com.example.card.domain.response.BoardResult;
import com.example.card.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/board")
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

    @RequestMapping(method = RequestMethod.GET, path="/cnt")
    public ResponseEntity countBoards() {
        return ResponseEntity.ok(boardService.countBoards());
    }

    @RequestMapping(method = RequestMethod.GET, path= {""})
    public ResponseEntity<List<BoardResult>> readBoards() {
        List<BoardResult> boardList = boardService.readBoards();
        return ResponseEntity.ok(boardList);
    }

    @RequestMapping(method = RequestMethod.GET, path= {"/{seq}"})
    public ResponseEntity<BoardResult> readBoard(@PathVariable(required = false) Integer seq) {
        return ResponseEntity.ok(boardService.readBoard(seq));
    }

    @RequestMapping(method = RequestMethod.POST, path="")
    public ResponseEntity createBoard(@RequestBody Board requestBoard) {
        LOGGER.error(requestBoard.toString());
        Board board = boardService.createBoard(requestBoard);
        return ResponseEntity.ok(board);
    }

    @RequestMapping(method = RequestMethod.PUT, path="/{seq}")
    public ResponseEntity<BoardResult> updateBoard(@PathVariable("seq") Integer seq, @RequestBody Board requestBoard) {
        BoardResult board = boardService.updateBoard(seq, requestBoard);
        return ResponseEntity.ok(board);
    }

    @RequestMapping(method = RequestMethod.DELETE, path="/{seq}")
    public void deleteBoard(@PathVariable("seq") Integer seq) {
        boardService.deleteBoard(seq);
    }
}
