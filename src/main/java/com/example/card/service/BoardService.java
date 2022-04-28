package com.example.card.service;

import com.example.card.model.Board;
import com.example.card.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> readBoards() {
        List<Board> boardList = boardRepository.findAll();
        System.out.println(Arrays.toString(boardList.toArray()));
        return boardList;
    }

    public Board readBoard(Integer seq) {
        Optional<Board> optionalBoard = boardRepository.findById(seq);
        return optionalBoard.get();
    }

    public Board createBoard(Board requestBoard) {
        Board board = new Board();
        BeanUtils.copyProperties(requestBoard, board);
        return boardRepository.save(board);
    }

    public Board updateBoard(Integer seq, Board requestBoard) {
        Optional<Board> optionalBoard = boardRepository.findById(seq);
        if (!optionalBoard.isPresent()) {
            throw new EntityNotFoundException("Member not present in the database");
        }

        Board board = optionalBoard.get();
        board.setName(requestBoard.getName());
        board.setPass(requestBoard.getPass());
        board.setContent(requestBoard.getContent());

        return boardRepository.save(board);
    }

    public void deleteBoard(Integer seq) {
        boardRepository.deleteById(seq);
    }
}
