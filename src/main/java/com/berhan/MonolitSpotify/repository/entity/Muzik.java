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
@Table(name = "tbl_muzik")
public class Muzik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String muzikUrl;
    String name;
    String kapakResmi;
    /**
     *TODO: Müzik Türü tablosundan doğrulandıktan sonra girişine onay var
     */
    String tur;
    int sure;
    String aciklama;
    @Enumerated(EnumType.STRING)
    State state;

}
