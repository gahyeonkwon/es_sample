package com.es.demo.es_sample.repository.jpa;

import com.es.demo.es_sample.domain.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ApiRepository extends JpaRepository<Character, Long> {

}
