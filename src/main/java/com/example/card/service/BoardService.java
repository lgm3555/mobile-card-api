package com.example.card.service;

import com.example.card.controller.BoardController;
import com.example.card.controller.error.HTTPStatusException;
import com.example.card.domain.Board;
import com.example.card.domain.response.BoardResult;
import com.example.card.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

    public Long countBoards() {
        Long count = boardRepository.count();
        return count;
    }

    public List<BoardResult> readBoards() {
        List<Board> boardList = boardRepository.findAll();
        return boardList.stream().map(board -> BoardResult.of(board)).collect(Collectors.toList());
    }

    public BoardResult readBoard(Integer seq) {
        Optional<Board> optionalBoard = boardRepository.findById(seq);
        Board board = optionalBoard.orElse(null);
        return board == null ? null : BoardResult.of(board);
    }

    public Board createBoard(Board requestBoard) {
        Board board = new Board();
        BeanUtils.copyProperties(requestBoard, board);
        return boardRepository.save(board);
    }

    public BoardResult updateBoard(Integer seq, Board requestBoard) {
        Board board = updateParamCheck(seq, requestBoard);
        return BoardResult.of(boardRepository.save(board));
    }

    public void deleteBoard(Integer seq) {
        boardRepository.deleteById(seq);
    }

    public Board updateParamCheck(Integer seq, Board requestBoard) {
        Optional<Board> board = boardRepository.findById(seq);

        if (board.isEmpty()) {
            throw new EntityNotFoundException("수정 데이터가 없습니다.");
        }

        if (!board.get().getPass().equals(requestBoard.getPass())) {
            throw new HTTPStatusException(HttpStatus.BAD_REQUEST, "E01", "패스워드가 일치하지 않습니다.");
        }

        if (requestBoard.getId() != null && !(requestBoard.getId()).isEmpty()) {
            board.get().setId(requestBoard.getId());
        }

        if (requestBoard.getPass() != null && !(requestBoard.getPass()).isEmpty()) {
            board.get().setPass(requestBoard.getPass());
        }

        if (requestBoard.getContent() != null && !(requestBoard.getContent()).isEmpty()) {
            board.get().setContent(requestBoard.getContent());
        }

        return board.get();
    }
}
