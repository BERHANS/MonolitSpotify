package com.berhan.MonolitSpotify.service;

import com.berhan.MonolitSpotify.repository.MuzikTuruRepository;
import com.berhan.MonolitSpotify.repository.entity.MuzikTuru;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikTuruService {

    private final MuzikTuruRepository repository;

    public void save(MuzikTuru entity){
        repository.save(entity);
    }
}
