package com.example.card.service;

import com.example.card.domain.Board;
import com.example.card.domain.response.BoardResult;
import com.example.card.domain.reuqest.EditBoardParam;
import com.example.card.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

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
        return BoardResult.of(board);
    }

    public Board createBoard(Board requestBoard) {
        Board board = new Board();
        BeanUtils.copyProperties(requestBoard, board);
        return boardRepository.save(board);
    }

    public Board updateBoard(Integer seq, EditBoardParam requestBoard) {
        Optional<Board> optionalBoard = boardRepository.findById(seq);

        if (optionalBoard.isEmpty()) {
            throw new EntityNotFoundException("Member not present in the database");
        }

        Board board = optionalBoard.get();
        board.setId(requestBoard.getId());
        board.setPass(requestBoard.getPass());
        board.setContent(requestBoard.getContent());

        return boardRepository.save(board);
    }

    public void deleteBoard(Integer seq) {
        boardRepository.deleteById(seq);
    }
}
