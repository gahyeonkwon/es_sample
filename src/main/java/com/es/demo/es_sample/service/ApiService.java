package com.es.demo.es_sample.service;


import com.es.demo.es_sample.domain.dto.CharacterDto;
import com.es.demo.es_sample.domain.entity.Character;
import com.es.demo.es_sample.repository.jpa.ApiRepository;
import com.es.demo.es_sample.domain.dto.RankingDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ApiService {

    final private String API_KEY = "test_bdecc3a29c9925e2934164912a51efd56c6aee2ae85417dcb5b86c34dcda2b60dbcc7fe2a7c43bb49aec49a6b38264b2";

   final private ApiRepository apiRepository;

    public void scrapData(String url, String type, HttpServletRequest request) throws IOException {

        insertCharacterData(connectUrl(url, type, request));

    }


    public String connectUrl(String url, String type, HttpServletRequest request) throws  IOException {
        String responseData = "";

        URL connectionTarget = new URL(url);
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        BufferedReader br;
        HttpURLConnection con = (HttpURLConnection) connectionTarget.openConnection();
        con.setRequestMethod(type);
        //서버에 연결되는 Timeout 시간 설정 - 최소 1초 ~ 20초 명시 됨에 따라 20000 설정
        con.setConnectTimeout(20000);
        //InputStream 읽어 오는 Timeout 시간 설정 - 최소 1초 ~ 20초 명시 됨에 따라 20000 설정
        con.setReadTimeout(20000);
        // post data 가 있을 경우 true
        con.setDoOutput(true);
        //request setting
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept", "application/json");


        //nexon API key setting
        con.setRequestProperty("x-nxopen-api-key", API_KEY);

        if(con.getResponseCode() == HttpStatus.OK.value()) {
            log.info(" connect success ! url = {} " + url);
            br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            responseData = sb.toString();
            log.info("responseData {} => " + responseData);

            br.close();
        }

        return responseData;
    }

    public void insertCharacterData(String data) throws JsonProcessingException {
        apiRepository.saveAll( RankingDto.parseToDto(data).getRanking()
                .stream().map(Character::dtoToEntity).collect(Collectors.toList()));

    }

    public List<CharacterDto> findAll() {
        return apiRepository.findAll().stream().map(CharacterDto::entityToDto)
                .collect(Collectors.toList());
    }

    public CharacterDto findByCharacterName(String name) {
       return  CharacterDto.optionalEntityToDto(apiRepository.findByCharacterName(name));
    }
}
