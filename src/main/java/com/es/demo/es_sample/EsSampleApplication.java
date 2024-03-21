package com.es.demo.es_sample;

import com.es.demo.es_sample.repository.es.EsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EsSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsSampleApplication.class, args);
	}

}
