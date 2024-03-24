package com.es.demo.es_sample.domain.document;

import com.es.demo.es_sample.domain.dto.CharacterDto;
import com.es.demo.es_sample.domain.entity.Character;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Builder
@Document(indexName = "characters")
public class CharacterDocument {

    @Id
    private Long id;

    @Field(name = "world_name", type = FieldType.Text)
    private String worldName;

    @Field(name = "character_name", type = FieldType.Text)
    private String characterName;

    @Field(name = "character_level", type = FieldType.Integer)
    private Integer characterLevel;


    //============================================================== //
    public static CharacterDocument dtoToDocument(CharacterDto characterDto) {
        return builder()
                .id(characterDto.getId())
                .worldName(characterDto.getWorld_name())
                .characterName(characterDto.getCharacter_name())
                .characterLevel(characterDto.getCharacter_level()).build();
    }

    public static CharacterDocument entityToDocument(Character character) {
        return builder()
                .id(character.getId())
                .worldName(character.getWorldName())
                .characterName(character.getCharacterName())
                .characterLevel(character.getCharacterLevel()).build();
    }

}