package com.lazzysun.notebase.elastic.server;

import com.lazzysun.notebase.elastic.model.ProductDocument;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class BaseSearchService<T> {
    @Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Resource
    private RestHighLevelClient restHighLevelClient;

    public void save(ProductDocument... productDocuments) {
        Iterable<ProductDocument> save = elasticsearchRestTemplate.save(productDocuments);
    }
}
