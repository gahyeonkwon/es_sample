package com.es.demo.es_sample.repository.es;

import com.es.demo.es_sample.domain.document.CharacterDocument;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EsRepositoryTest {

    @Autowired
    EsRepository esRepository;
    @Test
    public void test() {

        Optional<CharacterDocument> val = esRepository.findByCharacterNameLike("한");
        Optional<CharacterDocument> val2 = esRepository.findByCharacterNameLike("%한%");
        Optional<CharacterDocument> val3 = esRepository.findByCharacterNameLike("*한*");


        System.out.println(val);
        System.out.println(val2);
        System.out.println(val3);

    }

}