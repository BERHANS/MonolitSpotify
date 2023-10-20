package com.berhan.MonolitSpotify.repository;

import com.berhan.MonolitSpotify.dto.response.FindAllUserProfileResponseDto;
import com.berhan.MonolitSpotify.repository.entity.UserProfile;
import com.berhan.MonolitSpotify.repository.view.VwUserProfile;
import com.berhan.MonolitSpotify.utility.enums.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * DİKKATTT
 * Spring 3.x ile birlikte Repository sınıfların üzerinde ekleme @Repository anotasyonu kaldırılmıştır.
 *
 */
@Repository//eklenmese de sıkıntı çıkarmaz
public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

    /**
    * userName -> UserName -> kullanıcıAdı -> Kullanıcı
     * Dikkat!!!
     * Spring Data Jpa içinde belli kelimeleri analiz ederek doğru sıralamada kullanıldığında sorgulamayı
     * kelimelerle yapabiliyor
     * Kelimeleri kullanarak sorgu yazma Syntax'i
     * 1-> [find] yazılır
     * 2-> [By] yazılır "belli koşullarda araya başka keywordler gelebilir."
     * 3-> [Entity - Değişken Adı] burada dikkat değişken adları büyük harf ile başlamalı.
     * 4-> () parantez içine istediğiniz türdeki değişken ya da değişkenleri tanımlıyoruz.
     *
    */

    UserProfile findByResimUrl(String resimUrl);

    //select*from tbl_userprofile where state=?
    List<UserProfile> findAllByState(State state);

    /**
     * son [X günde] kayıt olanların listesi
     * GreaterThan -> bundan büyük -> createAt >XXX
     * LessThan -> bundan küçük -> createAt < XXX
     * GreaterThanEquals -> createAt >= XXX
     * LessThanEquals ->  createAt <= XXX
     */
    List<UserProfile> findAllByCreateAtGreaterThan(Long kayitZamani);
    /**
     * select* from tbl_userprofile where username like '%muh%'
     * Dikkattt1!!1
     * burada username ile parametre gönderirken gelen değere spring % ya da _ gibi
     * operatörleri eklemez. Bu nedenle sorgu yaparken şu şekilde kullanın
     * -> findAllByUserNameLike(%muh%);
     */
    List<UserProfile> findAllByUserNameLike(String username);

    /**
     * select * from tbl_userprofile where username = muh%
     */

    List<UserProfile> findAllByUserNameStartingWith(String userName);

    /**
     * select * from tbl_userprofile where createAt > XXX and username like 'muh%'
     * And
     * Or
     * yazabiliriz
     */

    List<UserProfile> findAllByCreateAtGreaterThanAndUserNameLike(Long lastDate, String userName);

    /**
     * Optional bir entity nin bize dönmesine yönelik bir methodda dönüş türünü optional seçmemiz daha doğrudur
     *
     */

    Optional<UserProfile> findOptionalByUserName(String userName);

    /**
     * Sıralama çok önemli olabiliyor
     * select * from tbluserprofile order by createAt
     * ASC -> A.........Z
     * DESC -> Z........A
     */
    List<UserProfile> findAllByOrderByCreateAt();

    List<UserProfile> findAllByOrderByCreateAtDesc(); //küçükten büyüğe sıralama böyle yapılır.

    /**
     * Belli kayıtların öncelenerek çekilmesi ya da kayıtlarda kısıtlamaya gidilmesi
     * listelenirken performans sağlar ve çok daha anlamlıdır.
     */

    List<UserProfile> findTop3By();
    List<UserProfile> findTop10ByOrderByCreateAtDesc();
    UserProfile findTopByOrderByCreateAtDesc();//eğer optional dönecek olursak optionali Top'dan sonra yazmamız gerekir
    //method adına optional yazarsak dönüş türünü optional belirlememiz lazım dönüş tipine oprional yazarsak method
    //ismine optional yazmaya gerek yok ama yazmamız doğru olur

    /**
     * Belli aralıklarda kısıtlamaya gidebiliriz. Bunun için and ile birleştirme yapabiliriz.
     * ancak Spring data bunun için bize bir kolaylık sağlıyor
     * üyelik tarihi 1 ile 2 yıl arasında olanları getir.
     */

    List<UserProfile> findAllByCreateAtBetween(Long start, Long end);
    List<UserProfile> findAllByUserNameLikeAndCreateAtBetween(String username, Long start, Long end);

    /**
     * -> isActive = true/false
     *
     * List<UserProfile> findAllByIsActive(boolean isActive);
     * List<UserProfile> findAllByIsActiveTrue();
     * List<UserProfile> findAllByIsActiveFalse();
     */

    /**
     * Bir alanı sorgularken eşitlik için ek bir kodlama yapmaya gerek yoktur. ancak, bazen girilen değer ile
     * tutulmuş olan değer büyük küçük harf sorununa takılabilir bunun için bu işlemi ignore etmek gerekebilir.
     */
    Optional<UserProfile> findOptionalByUserNameIgnoreCase(String username);

    /**
     * Bazı kolonlar belki daha sonra doldurulmak üzere boş bırakılabilirler bu nedenle
     * kontrol etmek ve kullanıcıya bunları doldurması yönünde telkinde bulunabiliriz.
     * Null, IsNull, NotNull
     */
    List<UserProfile> findAllByResimUrlIsNull();

    /**
     * Spring Data Jpa kolaylık açısından kendi kelimelerini desteklese de daha karmaşık sorgular ve
     * yapılar için özel sorgu yazabilmenize de olanak tanımaktadır;
     * Bu işlemler için 3 farklı yöntem vardır;
     * 1- JPQL
     * 2- HQL
     * 3- NativeSQL
     *
     */
    @Query("select u from UserProfile u where u.resimUrl IS NULL and u.userName= ?1 and u.createAt> ?2")//bizim girdiğimiz parametre
    UserProfile egerKullanicininResmiYokIseVeAdiMuhammetIseBul(String userName, Long createAt);//sorguya dahil edilecektir (= ?1) ile

    @Query("select new com.berhan.MonolitSpotify.dto.response.FindAllUserProfileResponseDto(u.id,u.userName,u.resimUrl) from UserProfile u")
    List<FindAllUserProfileResponseDto> findAllFromUserProfile();//bu methodun anotasyonu db den kısıtlanmış alanları çeker


}
