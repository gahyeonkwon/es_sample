package com.es.demo.es_sample.domain.entity;

import com.es.demo.es_sample.domain.dto.CharacterDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CollectionId;


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

    @Column(name = "world_name")
    private String worldName;
    private String ranking;

    @Column(name= "character_name")
    private String characterName;
    @Column(name= "character_level")
    private Integer characterLevel;
    @Column(name="character_exp")
    private Long characterExp;
    @Column(name="class_name")
    private String className;
    @Column(name="sub_class_name")
    private String subClassName;
    @Column(name="character_popularity")
    private Integer characterPopularity;
    @Column(name="character_guildname")
    private String characterGuildname;


    //============================================================== //
    public static Character dtoToEntity(CharacterDto characterDto) {
        return builder()
                .date(characterDto.getDate())
                .worldName(characterDto.getWorld_name())
                .ranking(characterDto.getRanking())
                .characterName(characterDto.getCharacter_name())
                .characterLevel(characterDto.getCharacter_level())
                .characterExp(characterDto.getCharacter_exp())
                .className(characterDto.getClass_name())
                .subClassName(characterDto.getClass_name())
                .characterPopularity(characterDto.getCharacter_popularity())
                .characterGuildname(characterDto.getCharacter_guildname())
                .build();
    }


}
