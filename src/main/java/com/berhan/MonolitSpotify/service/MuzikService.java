package com.berhan.MonolitSpotify.service;

import com.berhan.MonolitSpotify.repository.MuzikRepository;
import com.berhan.MonolitSpotify.repository.entity.Muzik;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MuzikService {

    private final MuzikRepository repository;

    public void save(Muzik entity){
        repository.save(entity);
    }
}
