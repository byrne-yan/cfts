package com.byrne.cfts.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.AbstractMap;
import java.util.List;

@Document
public class Index {
    private String code;
    private String name;
    List<AbstractMap.SimpleEntry<String,Integer>> composition;  //成分商品<代码，权重>
}
