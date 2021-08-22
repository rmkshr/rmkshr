package com.spring.appengine.dataconfig;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;

public class DataAccessConfiguration {

    public RestHighLevelClient prepareCient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        return client;
    }

    public SearchRequest prepareSearchRequest() {
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("marvel_vs_dc");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchSourceBuilder.size(500);
        searchRequest.source(searchSourceBuilder);
        return searchRequest;
    }
}
