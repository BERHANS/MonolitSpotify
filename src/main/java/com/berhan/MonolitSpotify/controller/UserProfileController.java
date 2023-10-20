package com.berhan.MonolitSpotify.controller;

import com.berhan.MonolitSpotify.constants.RestApi;
import com.berhan.MonolitSpotify.dto.request.SaveUserProfileRequestDto;
import com.berhan.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.berhan.MonolitSpotify.repository.entity.UserProfile;
import com.berhan.MonolitSpotify.service.UserProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import static com.berhan.MonolitSpotify.constants.RestApi.*;//Rest apiyi elle import edersek mappin yaparken
@RestController                                             // RESTAPİ.BİLMEMNE dememize gerek kalmaz direkt BİLMEMNE
@RequestMapping(USER)                                       // diyebiliriz
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;//final değişkenler tanımlanmalı değer verilmeli

//    @PostMapping(SAVE)
//    public ResponseEntity<UserProfile> save(String userName, String name, String email, String phone){
//        UserProfile userProfile = UserProfile.builder()
//                .userName(userName)
//                .build();
//        userProfileService.save(userProfile);
//        return ResponseEntity.ok(userProfile);
//    } BU METHODUN YAZILMASI DOĞRU OLMAZ

//    @GetMapping(FINDALL)
//    public ResponseEntity<List<UserProfile>> findAll(){
//        return ResponseEntity.ok(userProfileService.findAll());
//    } BU METHODLA KULLANICIYA TÜM BİLGİLERİNİ GÖNDERMİŞ OLURUZ DOĞRU OLMAZ

    @PostMapping(SAVE)
    public ResponseEntity<Void> saveUserProfile(@RequestBody  @Valid SaveUserProfileRequestDto dto){//valid anotasyonu ekleyerek dto da yapılan kısıtlamalar çalışır
        userProfileService.save(dto);
        return ResponseEntity.ok().build();
        //RequestBody anotasyonu formun kullanıcıya hangi bölgede gittiğine göre değişir header de gitse header anotasyonu eklerdik
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<FindAllUserProfileResponseDto>> findAllUserProfile(){
        return ResponseEntity.ok(userProfileService.findAllUserProfile());
    }

}
