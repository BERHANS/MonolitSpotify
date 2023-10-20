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
@Table(name = "tbl_calmaListesi_muzik")
public class CalmaListesiMuzik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    Long calmaListesiId;
    Long muzikId;
    @Enumerated(EnumType.STRING)
    State state;
}
