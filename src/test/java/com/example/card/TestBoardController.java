package com.example.card;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class TestBoardController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUpdateBoard() throws Exception {
        Map<String, String> map = new HashMap() {{
            put("seq", "4");
            put("id", "blackdog");
            put("pass", "1234");
            put("content", "축하드립니다.!");
        }};

        mockMvc.perform(put("/board")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(String.format("{\"seq\":\"4\",\"id\":\"blackdog\",\"pass\":\"1234\",\"content\":\"축하드립니다.!\"}")))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
