package com.example.card.service;

import com.example.card.domain.Like;
import com.example.card.domain.response.LikeResult;
import com.example.card.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;

    public Long countLike() {
        Long count = likeRepository.count();
        return count;
    }

    public LikeResult readLike(String deviceId) {
        Optional<Like> optionalLike = likeRepository.findById(deviceId);
        Like like = optionalLike.orElse(null);
        return LikeResult.of(like);
    }

    public Like createLike(Like requestLike) {
        Like like = new Like();
        BeanUtils.copyProperties(requestLike, like);
        return likeRepository.save(like);
    }
}
