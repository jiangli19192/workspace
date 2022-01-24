package com.zjl.java8.study.funcitonalInterface.example3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author
 */
@Data
@AllArgsConstructor
public class Feature {
    private String featureCode;
    private String optionCode;
    private String type;
    private String characterName;

    public Feature(String featureCode, String optionCode, String type) {
        this.featureCode = featureCode;
        this.optionCode = optionCode;
        this.type = type;
    }
}
