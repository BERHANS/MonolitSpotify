package com.berhan.MonolitSpotify.repository.entity;

import com.berhan.MonolitSpotify.utility.enums.State;
import com.berhan.MonolitSpotify.utility.enums.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_userprofile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String userName;
    String resimUrl;
    int followerCount;
    int followingCount;
    Long createAt;
    Long updateAt;
    @Enumerated(EnumType.STRING)
    UserType userType;
    @Enumerated(EnumType.STRING)
    State state;
}
