package com.berhan.MonolitSpotify.repository.entity;

import com.berhan.MonolitSpotify.utility.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_muzik_turu")
public class MuzikTuru {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String tur;
    @Enumerated(EnumType.STRING)
    State state;
}
