package com.example.card.repository;

import com.example.card.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    List<Board> findByContentLike(@Param("content") String content);
}
// seelct * from board where id = 4 and content like
