package com.es.demo.es_sample.service;

import com.es.demo.es_sample.domain.document.CharacterDocument;
import com.es.demo.es_sample.domain.dto.CharacterDto;
import com.es.demo.es_sample.domain.dto.RankingDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ElasticSearchService {
    private final ElasticsearchOperations elasticsearchOperations;

    public void saveOne(CharacterDto characterDto) {
        elasticsearchOperations.save(CharacterDocument.dtoToDocument(characterDto));
    }

    public void saveAll(String data) throws JsonProcessingException {

        ArrayList<CharacterDocument> result = new ArrayList<>();
        RankingDto.parseToDto(data).getRanking().stream().forEach(
                o -> result.add(CharacterDocument.dtoToDocument(o))
        );

        elasticsearchOperations.save(result);
    }

}
