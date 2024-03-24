package com.es.demo.es_sample.domain.dto;

import com.es.demo.es_sample.domain.document.CharacterDocument;
import com.es.demo.es_sample.domain.entity.Character;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.NoSuchElementException;
import java.util.Optional;
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
                .world_name(character.getWorldName())
                .ranking(character.getRanking())
                .character_name(character.getCharacterName())
                .character_level(character.getCharacterLevel())
                .character_exp(character.getCharacterExp())
                .class_name(character.getClassName())
                .sub_class_name(character.getSubClassName())
                .character_popularity(character.getCharacterPopularity())
                .character_guildname(character.getCharacterGuildname())
                .build();
    }


    public static CharacterDto optionalEntityToDto(Optional<Character> character1) {

        Character character = Character.builder().build();

        if(character1.isPresent()) {
            character = character1.get();

            return builder()
                    .id(character.getId())
                    .date(character.getDate())
                    .world_name(character.getWorldName())
                    .ranking(character.getRanking())
                    .character_name(character.getCharacterName())
                    .character_level(character.getCharacterLevel())
                    .character_exp(character.getCharacterExp())
                    .class_name(character.getClassName())
                    .sub_class_name(character.getSubClassName())
                    .character_popularity(character.getCharacterPopularity())
                    .character_guildname(character.getCharacterGuildname())
                    .build();

        } else {
            throw new NoSuchElementException("데이터가 없습니다");
        }

    }

    public static CharacterDto optionalDocToDto(Optional<CharacterDocument> character1) {

        CharacterDocument character =  CharacterDocument.builder().build();

        if(character1.isPresent()) {
            character = character1.get();
            return builder()
                    .id(character.getId())
                    .character_name(character.getCharacterName())
                    .world_name(character.getWorldName())
                    .character_level(character.getCharacterLevel())
                    .build();

        } else {
            throw new NoSuchElementException("데이터가 없습니다");
        }

    }

}
