package com.example.card.controller;

import com.example.card.model.Board;
import com.example.card.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @RequestMapping(method = RequestMethod.GET, path= "/board")
    public ResponseEntity readBoards(@RequestParam(required = false) Integer requestData) {
        if (requestData == null) {
            System.out.println("tt");
            List<Board> boardList = boardService.readBoards();
            return ResponseEntity.ok(boardList);
        }

        return ResponseEntity.ok(boardService.readBoard(requestData));
    }

}
