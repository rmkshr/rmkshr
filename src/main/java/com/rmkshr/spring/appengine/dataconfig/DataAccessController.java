package com.rmkshr.spring.appengine.dataconfig;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.ToXContent;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.util.ObjectUtils;

import java.io.IOException;

@RequiredArgsConstructor
public class DataAccessController {

    DataAccessConfiguration dataAccessConfiguration;

    public String fetchAllData() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        try {
            SearchResponse searchResponse = dataAccessConfiguration.prepareCient().search(dataAccessConfiguration.prepareSearchRequest(), RequestOptions.DEFAULT);
            if (searchResponse.getHits().getTotalHits().value > 0) {
                builder.startObject();
                searchResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);
                builder.endObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return !ObjectUtils.isEmpty(builder) ? builder.toString() : "";
    }

}
