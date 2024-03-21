package com.es.demo.es_sample;

import com.es.demo.es_sample.repository.es.EsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootTest
class EsSampleApplicationTests {

	@Test
	void contextLoads() {
	}

}
