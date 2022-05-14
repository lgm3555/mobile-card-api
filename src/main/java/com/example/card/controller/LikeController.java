package com.example.card.controller;

import com.example.card.domain.Like;
import com.example.card.domain.response.LikeResult;
import com.example.card.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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

    @RequestMapping(method = RequestMethod.GET, path="/{deviceId}")
    public ResponseEntity<LikeResult> readLike(@PathVariable() String deviceId) {
        LikeResult like = likeService.readLike(deviceId);
        return ResponseEntity.ok(like);
    }

    @RequestMapping(method = RequestMethod.POST, path="")
    public ResponseEntity createLike(@RequestBody Like requestLike) {
        Like like = likeService.createLike(requestLike);
        return ResponseEntity.ok(like);
    }
}
