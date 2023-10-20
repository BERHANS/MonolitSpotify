package com.berhan.MonolitSpotify.service;


import com.berhan.MonolitSpotify.dto.request.SaveUserProfileRequestDto;
import com.berhan.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.berhan.MonolitSpotify.repository.UserProfileRepository;
import com.berhan.MonolitSpotify.repository.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Dikkat!!
 * servis sınıflarının belirtilmesi ve bunların birer Bean oluşturulması için spring bu sınıfların
 * üzerinde @Service anotasyonu olup olmadığına bakar. Eğer boş geçilirse hata fırlatır ve uygulamanız ayağa
 * kalkmaz.
 */
@Service
@RequiredArgsConstructor//3.yöntem anotasyonu
public class UserProfileService {
    /**
     * Dikkaat!!!
     * Spring Bean olarak işaretlediği (@Repository, @Service, @Configuration,@Component v.s)
     * tüm sınıflardan nesne yaratabilmek için 3 farklı yöntem izler
     * 1- Değişkenin üzerinde @Autowired ekleyerek
     * 2- Değişkenin constructor a parametre olarak geçilmesi ile yapılır.(constructor injection)
     * 3- 2.yöntem in 3. taraf uygulamalar ile sağlanması. yazımı daha kolaydır kod sayfasının daha temiz görünmesin
     * sağlar
     */

//    @Autowired //newleme işlemini bununla yapar
//    private UserProfileRepository repositoryYöntem1;

//    private final UserProfileRepository repositoryYontem2;
//
//    public UserProfileService (UserProfileRepository repositoryYontem2){
//        this.repositoryYontem2=repositoryYontem2;
//    }

    private final UserProfileRepository repository;//bu 3. yöntem olarak karşımıza çıkar anotasyonunu eklediğimiz
    //için sadece bunu yazmamız yeterlidir

    public void save(UserProfile userProfile){
        /**
         * ÖNEMLİ!!!
         * save işlemi iki şekilde çalışır;
         * 1- Eğer kendisine verilen nesne id bilgisini içermiyor ise yani null ise kaydetme işlemi yapar.
         * 2- Eğer nesne içindeki id bir değer içeriyor ise bu seferde güncelleme işlemi yapar.
         */
        repository.save(userProfile);
    }

    public void save(SaveUserProfileRequestDto dto){
        if(!dto.getPassword().equals(dto.getRePassword())){
            throw new RuntimeException("şifreler uyuşmuyor");
        }
        repository.save(UserProfile.builder()
                .userName(dto.getUserName())
                .build());
    }

    public List<UserProfile> findAll(){
        return repository.findAll();
    }

    public List<UserProfile> findAllByCreateAtGreaterThan(Long kayitZamani){
        return repository.findAllByCreateAtGreaterThan(kayitZamani);
    }

    public List<FindAllUserProfileResponseDto> findAllUserProfile() {//service katmanında response dönülmez
//        List<FindAllUserProfileResponseDto> result = new ArrayList<>();
//        repository.findAllFromUserProfile().forEach(u->{
//            result.add(
//                    FindAllUserProfileResponseDto.builder()
//                            .id(u.getId())
//                            .userName(u.getUserName())
//                            .resimUrl(u.getResimUrl())
//                            .build()
//            );
//        });
        return repository.findAllFromUserProfile();
    }
}

