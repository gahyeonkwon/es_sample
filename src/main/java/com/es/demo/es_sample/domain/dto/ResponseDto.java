package com.es.demo.es_sample.domain.dto;


import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto {

    String message;
    CharacterDto characterDto;
    List<CharacterDto> characterDtoList;
}
