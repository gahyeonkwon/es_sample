package com.es.demo.es_sample.domain.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class RankingDto {

    static final private ObjectMapper mapper = new ObjectMapper();
    private List<CharacterDto> ranking;

    //============================================================== //

    public static RankingDto parseToDto(String data) throws JsonProcessingException  {
        return  mapper.readValue(data, RankingDto.class);
    }

}
