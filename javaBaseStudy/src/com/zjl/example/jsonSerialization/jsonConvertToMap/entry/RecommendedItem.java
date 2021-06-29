package com.zjl.example.jsonSerialization.jsonConvertToMap.entry;

import lombok.Data;

@Data
public class RecommendedItem {
    private String productNumber;
    private String type;
    private String title;
    private String message;
    private String productGuide;
    private String image;
    private double price;
    private String hardwareType;
    private boolean mandatory;
}
