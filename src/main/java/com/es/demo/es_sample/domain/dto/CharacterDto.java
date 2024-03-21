package com.es.demo.es_sample.domain.dto;

import com.es.demo.es_sample.domain.entity.Character;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.concurrent.atomic.LongAccumulator;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterDto {

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

    @Builder
    public CharacterDto(Long id, String date, String world_name, String ranking, String character_name, Integer character_level, Long character_exp, String class_name, String sub_class_name, Integer character_popularity, String character_guildname) {
        this.id = id;
        this.date = date;
        this.world_name = world_name;
        this.ranking = ranking;
        this.character_name = character_name;
        this.character_level = character_level;
        this.character_exp = character_exp;
        this.class_name = class_name;
        this.sub_class_name = sub_class_name;
        this.character_popularity = character_popularity;
        this.character_guildname = character_guildname;
    }


    //============================================================== //
    public static CharacterDto entityToDto(Character character) {
        return builder()
                .id(character.getId())
                .date(character.getDate())
                .world_name(character.getWorld_name())
                .ranking(character.getRanking())
                .character_name(character.getCharacter_name())
                .character_level(character.getCharacter_level())
                .character_exp(character.getCharacter_exp())
                .class_name(character.getClass_name())
                .sub_class_name(character.getClass_name())
                .character_popularity(character.getCharacter_popularity())
                .character_guildname(character.getCharacter_guildname())
                .build();
    }
}
