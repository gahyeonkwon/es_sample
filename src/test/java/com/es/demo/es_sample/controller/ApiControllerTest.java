package com.es.demo.es_sample.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class ApiControllerTest {

    @Autowired
    MockMvc mock;


    final String API_KEY = "test_bdecc3a29c9925e2934164912a51efd56c6aee2ae85417dcb5b86c34dcda2b60dbcc7fe2a7c43bb49aec49a6b38264b2";

    @Test
    @DisplayName("scrap_api호출테스트")
    public void test_1() throws Exception {

        //given
        String url = "https://open.api.nexon.com/maplestory/v1/ranking/union";

        //when, then
        mock.perform(
                get(url)
                        .header("x-nxopen-api-key", API_KEY)
                        .param("date", "2024-03-15"))
                .andDo(print());
    }


    @Test
    @DisplayName("controller 호출 테스트 ")
    public void test_2() throws Exception {

        //given
        String url = "/scrap/v1/ranking";

        //when, then
        mock.perform(get(url))
                .andDo(print());
    }

}