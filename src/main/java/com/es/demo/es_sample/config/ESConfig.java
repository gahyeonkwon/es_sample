package com.es.demo.es_sample.config;


import com.es.demo.es_sample.repository.es.EsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
public class ESConfig extends ElasticsearchConfiguration {

    @Value("${spring.elasticsearch.host}")
    String host;

    @Value("${spring.elasticsearch.port}")
    String port;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(host + ":" +port)
                .withConnectTimeout(300000)
                .build();
    }
}