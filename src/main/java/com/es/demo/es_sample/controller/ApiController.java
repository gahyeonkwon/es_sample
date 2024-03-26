package com.es.demo.es_sample.controller;

import com.es.demo.es_sample.domain.document.CharacterDocument;
import com.es.demo.es_sample.domain.dto.CharacterDto;
import com.es.demo.es_sample.domain.dto.ResponseDto;
import com.es.demo.es_sample.repository.es.EsRepository;
import com.es.demo.es_sample.service.ApiService;
import com.es.demo.es_sample.service.ElasticSearchService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiController {

       final private ApiService apiService;

       final private ElasticSearchService elasticSearchService;
       final private String serverURI = "https://open.api.nexon.com";


       @GetMapping("/update/v1/jpa/ranking/all")
       public ResponseEntity<ResponseDto> scrap_v1_ranking_all(HttpServletRequest httpServletRequest) throws IOException {

              String url = serverURI + "/maplestory/v1/ranking/overall?date=2024-03-15";
              String type = "GET";

              for(int i = 1 ; i < 50 ; i++ ) {
                     log.info(" i => " + i);
                     apiService.scrapData(url + "&page=" + i, type, httpServletRequest);
              }


              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출").build());
       }


       @GetMapping("/update/v1/jpa/ranking/{page}")
       public ResponseEntity<ResponseDto> scrap_v1_ranking(@PathVariable("page") Number page, HttpServletRequest httpServletRequest) throws IOException {

              String url = serverURI + "/maplestory/v1/ranking/overall?date=2024-03-15";
              page = page != null ? page : 1;
              url += "&page=" + page;
              String type = "GET";
              apiService.scrapData(url, type, httpServletRequest);

              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출").build());
       }

       @GetMapping("/update/v1/es/ranking")
       public ResponseEntity<ResponseDto> update_v1_ranking() throws JsonProcessingException {
              elasticSearchService.updateRankingData();
              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출").build());
       }


       @DeleteMapping("/v1/es/index")
       public ResponseEntity<ResponseDto> delete_v1_es_index(@RequestParam("indexName") String indexName) throws JsonProcessingException {
              elasticSearchService.deleteIndex(indexName);
              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출").build());
       }


       @GetMapping("/search/v1/jpa")
       public ResponseEntity<ResponseDto> search_v1_jpa(@RequestParam("name") String name) {
              CharacterDto result = apiService.findByName(name);
              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출")
                              .characterDto(result).build());
       }

       @GetMapping("/search/v1/es")
       public ResponseEntity<ResponseDto> search_v1_es(@RequestParam("name") String name) {
              CharacterDto result = elasticSearchService.findByName(name);
              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출")
                              .characterDto(result).build());
       }




       @GetMapping("/search/v2/jpa")
       public ResponseEntity<ResponseDto> search_v2_jpa(@RequestParam("name") String name) {
              List<CharacterDto> result = apiService.findByNameLike("%" + name + "%");
              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출")
                              .characterDtoList(result).build());
       }

       @GetMapping("/search/v2/es")
       public ResponseEntity<ResponseDto> search_v2_es(@RequestParam("name") String name) {
              List<CharacterDto> result = elasticSearchService.findByNameLike("%" + name + "%");
              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출")
                              .characterDtoList(result).build());
       }


       @GetMapping("/search/v3/es")
       public ResponseEntity<ResponseDto> search_v3_es(@RequestParam("name") String name) {
              List<CharacterDto> result = elasticSearchService.findByNameLike("*" + name + "*");
              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출")
                              .characterDtoList(result).build());
       }

       @GetMapping("/search/v4/es")
       public ResponseEntity<ResponseDto> search_v4_es(@RequestParam("name") String name) {
              List<CharacterDto> result = elasticSearchService.findByNameLike(name);
              return ResponseEntity.status(HttpStatus.OK)
                      .body(ResponseDto.builder().message("정상호출")
                              .characterDtoList(result).build());
       }




}
