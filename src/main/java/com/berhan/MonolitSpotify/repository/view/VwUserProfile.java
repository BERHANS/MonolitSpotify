package com.berhan.MonolitSpotify.repository.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VwUserProfile {
    Long id;
    String userName;
    String resimUrl;


}
