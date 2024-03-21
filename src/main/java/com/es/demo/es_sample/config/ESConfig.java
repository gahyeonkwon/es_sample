package com.es.demo.es_sample.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;


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
                .build();
    }
}