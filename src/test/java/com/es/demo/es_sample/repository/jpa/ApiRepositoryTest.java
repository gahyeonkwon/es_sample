package com.es.demo.es_sample.repository.jpa;

import com.es.demo.es_sample.domain.document.CharacterDocument;
import com.es.demo.es_sample.domain.entity.Character;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApiRepositoryTest {

    @Autowired
    ApiRepository apiRepository;

    @Test
    public void test() {

        List<Character> val = apiRepository.findByCharacterNameLike("한");
        List<Character> val2 = apiRepository.findByCharacterNameLike("%한%");

        System.out.println(val);
        System.out.println(val2);
        System.out.println(val3);

    }


}