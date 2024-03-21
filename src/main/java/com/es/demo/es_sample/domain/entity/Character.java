package com.es.demo.es_sample.domain.entity;

import com.es.demo.es_sample.domain.dto.CharacterDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;



@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Character {
    @Id
    @GeneratedValue
    private Long id;

    private String date;
    private String world_name;
    private String ranking;
    private String character_name;
    private Integer character_level;
    private Long character_exp;
    private String class_name;
    private String sub_class_name;
    private Integer character_popularity;
    private String character_guildname;


    //============================================================== //
    public static Character dtoToEntity(CharacterDto characterDto) {
        return builder()
                .date(characterDto.getDate())
                .world_name(characterDto.getWorld_name())
                .ranking(characterDto.getRanking())
                .character_name(characterDto.getCharacter_name())
                .character_level(characterDto.getCharacter_level())
                .character_exp(characterDto.getCharacter_exp())
                .class_name(characterDto.getClass_name())
                .sub_class_name(characterDto.getClass_name())
                .character_popularity(characterDto.getCharacter_popularity())
                .character_guildname(characterDto.getCharacter_guildname())
                .build();
    }


}
