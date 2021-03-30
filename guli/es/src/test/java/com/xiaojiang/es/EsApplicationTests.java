package com.xiaojiang.es;

import java.io.IOException;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class EsApplicationTests {


	@Autowired
	RestHighLevelClient esClient;

	@Test
	public void getIndexData() throws IOException {
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices("bank");
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		searchSourceBuilder.query(QueryBuilders.matchAllQuery());
		searchRequest.source(searchSourceBuilder);

		SearchResponse searchResponse = esClient.search(searchRequest,RequestOptions.DEFAULT);
		SearchHits searchHits = searchResponse.getHits();
		System.out.println(searchHits);
	}

}
