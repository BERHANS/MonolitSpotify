package com.berhan.MonolitSpotify.service;

import com.berhan.MonolitSpotify.repository.MuzikSanatciRepository;
import com.berhan.MonolitSpotify.repository.entity.MuzikSanatci;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikSanatciService {

    private final MuzikSanatciRepository repository;

    public void save(MuzikSanatci entity){
        repository.save(entity);
    }
}
