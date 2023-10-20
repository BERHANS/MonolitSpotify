package com.berhan.MonolitSpotify.service;

import com.berhan.MonolitSpotify.repository.CalmaListesiRepository;
import com.berhan.MonolitSpotify.repository.entity.CalmaListesi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CalmaListesiService {

    private final CalmaListesiRepository repository;

    public void save(CalmaListesi calmaListesi){
        repository.save(calmaListesi);
    }
}
