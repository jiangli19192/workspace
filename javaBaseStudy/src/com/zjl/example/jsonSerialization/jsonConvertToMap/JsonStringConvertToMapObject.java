package com.zjl.example.jsonSerialization.jsonConvertToMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zjl.example.jsonSerialization.jsonConvertToMap.entry.RecommendedData;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static java.lang.ClassLoader.getSystemClassLoader;

public class JsonStringConvertToMapObject {
    public static void main(String[] args) {
        try {
            Map<String, List<RecommendedData>> configId2RecommendedDatasMap = getConfigId2RecommendedDatasMap();

            System.out.println("configId2RecommendedDatasMap = " + configId2RecommendedDatasMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<RecommendedData>> getConfigId2RecommendedDatasMap() throws IOException {
        String file = getSystemClassLoader().getResource("com/zjl/example/jsonSerialization/jsonConvertToMap/Lfo_Mock_Recommendation_Data.json").getFile();

        String jsonStr = IOUtils.toString(new FileInputStream(file), "UTF-8");

        Map<String, List<RecommendedData>> configId2RecommendedDatasMap = JSON.parseObject(jsonStr, new TypeReference<Map<String, List<RecommendedData>>>() {
        });

        return configId2RecommendedDatasMap;
    }
}
