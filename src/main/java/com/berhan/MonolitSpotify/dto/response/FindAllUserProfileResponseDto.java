package com.berhan.MonolitSpotify.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FindAllUserProfileResponseDto {

    Long id;
    String userName;
    String resimUrl;
}
