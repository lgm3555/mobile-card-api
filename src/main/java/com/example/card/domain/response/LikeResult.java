package com.example.card.domain.response;

import com.example.card.domain.Like;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class LikeResult {

    private String deviceid;

    public static LikeResult of(Like like) {
        return new LikeResult(like.getDeviceid());
    }
}
