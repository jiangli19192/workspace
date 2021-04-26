package com.zjl.example.jsonSerialization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Json文件序列化 实例
 * 原文链接：https://blog.csdn.net/weixin_44833680/article/details/102738468
 */
public class JsonFileSerialization {

    public static void main(String[] args) {
        String path = "D:\\hubz-lfo-response.json";
        String outputFilePath = "D:\\";
        formatAndOutputJsonFile(path, outputFilePath);
    }

    private static void formatAndOutputJsonFile(String path, String outputFilePath) {
        String outputFileName = "formattedJson";

        // 读取文件内容
        String sourceJson = new FileReader().readJsonFile(path);

        // 格式化读取到的json字符串
        String afterFormatJson = jsonFormat(sourceJson);

        // 输出格式化后json字符串到文件中
        boolean isCreateSuccess = new CreateFileUtil().createJsonFile(afterFormatJson, outputFilePath, outputFileName);
        System.out.println("格式化后的JSON文件输出:" + (isCreateSuccess ? "成功" : "失败"));
    }

    /**
     * 格式化Json字符串
     *
     * @param JsonString : 格式化前的json字符串
     * @return String : 格式化后的json字符串
     */
    private static String jsonFormat(String JsonString) {
        JSONObject object = JSONObject.parseObject(JsonString);
        JsonString = JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        return JsonString;
    }
}
