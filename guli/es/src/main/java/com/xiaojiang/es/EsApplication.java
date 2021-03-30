package com.xiaojiang.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class EsApplication {

	@Bean
	public RestHighLevelClient esClient(){
		return new RestHighLevelClient(
				RestClient.builder(new HttpHost("52.80.90.49", 9200, "http")));
	}

	public static void main(String[] args) {
		SpringApplication.run(EsApplication.class, args);
	}

}
