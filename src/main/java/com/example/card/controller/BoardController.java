package com.example.card.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class BoardController {

    @GetMapping("/test")
    public HashMap test() {
        HashMap map = new HashMap();
        map.put("message", "안녕하세요");

        return map;
    }
}
