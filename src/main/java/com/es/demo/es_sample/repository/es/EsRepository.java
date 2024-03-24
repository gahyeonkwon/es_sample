package com.es.demo.es_sample.repository.es;

import com.es.demo.es_sample.domain.document.CharacterDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface EsRepository extends ElasticsearchRepository<CharacterDocument, Long> {

    Optional<CharacterDocument> findById(Long id);
    Optional<CharacterDocument> findByCharacterName(String name);
}


