package com.example.card;

import com.example.card.domain.Board;
import com.example.card.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testRead() {
        Optional board = boardRepository.findById(1);

        System.out.println(board);
    }

    @Test
    public void testFindByIdAAndContent() {
        List<Board> board = boardRepository.findByContentLike("%축%");
        System.out.println(board);
    }
}
