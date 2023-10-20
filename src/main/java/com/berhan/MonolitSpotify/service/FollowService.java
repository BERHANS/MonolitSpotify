package com.berhan.MonolitSpotify.service;

import com.berhan.MonolitSpotify.repository.FollowRepository;
import com.berhan.MonolitSpotify.repository.entity.Follow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FollowService {

    private final FollowRepository repository;

    public void save(Follow follow){
        repository.save(follow);
    }
}
