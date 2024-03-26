package com.es.demo.es_sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




//@EnableJpaRepositories(basePackages = "com.es.demo.es_sample.repository.jpa")
//@EnableElasticsearchRepositories(basePackages = "com.es.demo.es_sample.repository.es")
@SpringBootApplication
public class EsSampleApplication {


	public static void main(String[] args) {
		SpringApplication.run(EsSampleApplication.class, args);
	}

}
