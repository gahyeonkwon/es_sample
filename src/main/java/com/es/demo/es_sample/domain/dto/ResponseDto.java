package com.es.demo.es_sample.domain.dto;


import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto {

    String message;
    CharacterDto characterDto;
}
