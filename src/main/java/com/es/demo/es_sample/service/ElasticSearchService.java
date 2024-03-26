package com.es.demo.es_sample.service;

import com.es.demo.es_sample.domain.document.CharacterDocument;
import com.es.demo.es_sample.domain.dto.CharacterDto;
import com.es.demo.es_sample.domain.dto.RankingDto;
import com.es.demo.es_sample.domain.entity.Character;
import com.es.demo.es_sample.repository.es.EsRepository;
import com.es.demo.es_sample.repository.jpa.ApiRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ElasticSearchService {

    private final ElasticsearchOperations elasticsearchOperations;
    private final EsRepository esRepository;
    private  final ApiRepository apiRepository;



    //======================== elasticsaerchOpertaion 을 사용하는 예제 ==========================

    public void saveOne(CharacterDto characterDto) {
        elasticsearchOperations.save(CharacterDocument.dtoToDocument(characterDto));
    }

    public void saveAll(String data) throws JsonProcessingException {
        elasticsearchOperations.save(RankingDto.parseToDto(data).getRanking().stream()
                .map(CharacterDocument::dtoToDocument).collect(Collectors.toList()));
    }


    //======================== spring data es 사용하는 예제  =========================================


    public void updateRankingData() throws JsonProcessingException {

        List<Character> data = apiRepository.findAll();
        saveAllByRepo(data);
    }

    public CharacterDocument saveOneByRepo(CharacterDto characterDto) {
        return esRepository.save(CharacterDocument.dtoToDocument(characterDto));
    }


    public Iterable<CharacterDocument> saveAllByRepo(String data) throws JsonProcessingException {

        return esRepository.saveAll(RankingDto.parseToDto(data).getRanking().stream().map(
                CharacterDocument::dtoToDocument).collect(Collectors.toList()));

    }

    public Iterable<CharacterDocument> saveAllByRepo(List<Character> data) throws JsonProcessingException {
        log.info(" data.size() =>" + data.size());
        return esRepository.saveAll(data.stream().map(CharacterDocument::entityToDocument).collect(Collectors.toList()));
    }


    public CharacterDto findByName(String name) {
        Optional<CharacterDocument> byCharacterName = esRepository.findByCharacterName(name);
        return CharacterDto.optionalDocToDto(byCharacterName);
    }

    public List<CharacterDto> findByNameLike(String name) {
        return  esRepository.findByCharacterNameLike(name).stream().map(CharacterDto::docToDto).collect(Collectors.toList());
    }

    public void deleteIndex(String indexName) {
        if(elasticsearchOperations.indexOps(IndexCoordinates.of(indexName)).exists()) {
            elasticsearchOperations.indexOps(IndexCoordinates.of(indexName)).delete();

        }
    }



}
