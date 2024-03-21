package com.es.demo.es_sample.controller;

import com.es.demo.es_sample.service.ApiService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@RestController
@RequiredArgsConstructor
public class ApiController {

       final private ApiService apiService;
       final private String serverURI = "https://open.api.nexon.com";

       @GetMapping("/scrap/v1/ranking")
       public ResponseEntity scrap_v1_ranking(HttpServletRequest httpServletRequest) throws IOException {

              String url = serverURI + "/maplestory/v1/ranking/overall?date=2024-03-15";
              String type = "GET";

              apiService.scrapData(url, type, httpServletRequest);
              return ResponseEntity.ofNullable(ResponseEntity.badRequest());

       }



}
