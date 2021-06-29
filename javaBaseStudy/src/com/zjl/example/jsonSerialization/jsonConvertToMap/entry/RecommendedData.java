package com.zjl.example.jsonSerialization.jsonConvertToMap.entry;

import lombok.Data;

import java.util.List;

@Data
public class RecommendedData {
    private String title;
    private List<RecommendedItem> items;
}
