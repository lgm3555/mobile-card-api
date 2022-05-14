package com.example.card.controller;

import com.example.card.domain.Like;
import com.example.card.domain.response.LikeResult;
import com.example.card.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/like")
@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(BoardController.class);

    @RequestMapping(method = RequestMethod.GET, path="/cnt")
    public ResponseEntity countLike() {
        return ResponseEntity.ok(likeService.countLike());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<LikeResult> readLike(@RequestBody Like requestLike) {
        LOGGER.info(requestLike.getDeviceid());
        LikeResult like = likeService.readLike(requestLike);
        return ResponseEntity.ok(like);
    }
}
