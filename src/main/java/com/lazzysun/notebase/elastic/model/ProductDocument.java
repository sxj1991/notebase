package com.lazzysun.notebase.elastic.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.CompletionField;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Data
@Document(indexName = "knowledge_base")
@Accessors(chain = true)
// 解决IK分词不能使用问题
//@Mapping(mappingPath = "productIndex.json")
public class ProductDocument implements Serializable {

    @Id
    private String id;
    @Field(analyzer = "ik_smart", searchAnalyzer = "ik_max_word", type = FieldType.Text,fielddata = true)
    private String productName;
    @Field(analyzer = "ik_smart", searchAnalyzer = "ik_max_word", type = FieldType.Text)
    private String productDesc;
    @Field(type = FieldType.Keyword)
    private String createUser;
    @Field(type = FieldType.Keyword)
    private String style;
    @Field(type = FieldType.Keyword)
    private String path;
    @Field(type = FieldType.Keyword)
    private Boolean permission;
    @Field(type = FieldType.Keyword)
    private List<String> keywords;
    @Field(type = FieldType.Keyword)
    private String type;

    @CompletionField(analyzer = "ik_smart", searchAnalyzer = "ik_max_word")
    private String completion;

    @Transient
    private Map<String,String> highLit;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


}
