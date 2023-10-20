package com.berhan.MonolitSpotify.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveUserProfileRequestDto {
    @NotBlank(message = "boş geçemezsin kanka")//kullanıcı adını boş geçemez methodu
    @Size(min = 3,max = 54,message = "kullanıcı adın bu uzunlukta olmalı")
    String userName;
    @Email(message = "kanka geçerli email gir")
    String email;
    @Size(min = 8,max = 128)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.,?@#$%^&+=*!])(?=\\S+$).{8,}$")// regexp = kullanarak parametre girebiliriz internetten bulabiliriz bunu
    String password;
    String rePassword;

}
