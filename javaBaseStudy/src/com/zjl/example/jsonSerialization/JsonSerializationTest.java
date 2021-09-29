package com.zjl.example.jsonSerialization;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.zjl.example.jsonSerialization.entity.LBPPriceResp;

import static com.zjl.example.jsonSerialization.entity.LBPPriceResp.Product.PRODUCT_TYPE_CTO;
import static com.zjl.example.jsonSerialization.entity.LBPPriceResp.Product.PRODUCT_TYPE_SERVICE;

/**
 * 序列化问题分析:
 *
 * 出现NullPointerException的原因，是由于LBPPriceResp对象内的getAllCtoMarginMap()方法中，
 * 使用了Collectors.toMap(Product::getCode, Product::getMargin)方法生成Map对象时，由于margin的数据都是null,
 * 违反了map.merge方法中Objects.requireNonNull(value);
 * 解决方法1：将方法名getAllCtoMarginMap()改为非get开头的方法名，如：obtainAllCtoMarginMap()，这样fastjson就识别不出来这些方法了
 * 解决方法2：修改为旧的填充Map的实现方式，这样就会绕开map.merge的方法。
 *     public Map<String, Double> getAllCtoMarginMap() {
 *         if (CollectionUtils.isEmpty(this.products)) {
 *             return Maps.newHashMap();
 *         }
 *
 *         Map<String, Double> ctoMarginMap = Maps.newHashMap();
 *         for (Product product : this.products) {
 *             if (!product.isCto()) {
 *                 continue;
 *             }
 *
 *             ctoMarginMap.put(product.getCode(), product.getMargin());
 *         }
 *
 *         return ctoMarginMap;
 *     }
 */
public class JsonSerializationTest {
    public static void main(String[] args) {
        String json = "{\"allCtoDiscountMap\":{\"5641PX3\":1.0,\"7Y89CTO1WW\":1.0},\"allCtoMarginMap\":{},\"allFeatureFixedPriceMap\":{},\"allOptionDiscountMap\":{},\"allOptionMarginMap\":{},\"allServiceDiscountMap\":{\"5AS7A83161\":1.0,\"5PS7A86030\":1.0,\"5PS7A86031\":1.0,\"5WS7A79266\":1.0,\"5PS7A17958\":1.0,\"5PS7A79278\":1.0,\"5PS7A17959\":1.0,\"5PS7A17912\":1.0,\"5PS7A17934\":1.0,\"5PS7A79290\":1.0,\"5PS7A85980\":1.0,\"5PS7A85960\":1.0,\"5WS7A85938\":1.0,\"5WS7A17908\":1.0,\"5WS7A85932\":1.0,\"5PS7A79305\":1.0,\"5PS7A17941\":1.0,\"5PS7A17920\":1.0,\"5PS7A17940\":1.0,\"5PS7A79323\":1.0,\"5PS7A85997\":1.0,\"5PS7A85978\":1.0,\"5PS7A85958\":1.0,\"5WS7A17916\":1.0,\"5PS7A86000\":1.0,\"5PS7A86001\":1.0,\"5WS7A85940\":1.0,\"5AS7A83160\":1.0,\"5PS7A85972\":1.0,\"5PS7A86027\":1.0,\"5PS7A17929\":1.0,\"5PS7A85952\":1.0},\"allServiceMarginMap\":{},\"businessUnit\":\"DCG\",\"codeDiscountMap\":{\"5AS7A83161\":1.0,\"5PS7A86030\":1.0,\"5PS7A86031\":1.0,\"5641PX3\":1.0,\"5WS7A79266\":1.0,\"5PS7A17958\":1.0,\"5PS7A79278\":1.0,\"5PS7A17959\":1.0,\"5PS7A17912\":1.0,\"5PS7A17934\":1.0,\"5PS7A79290\":1.0,\"5PS7A85980\":1.0,\"5PS7A85960\":1.0,\"5WS7A85938\":1.0,\"5WS7A17908\":1.0,\"5WS7A85932\":1.0,\"5PS7A79305\":1.0,\"5PS7A17941\":1.0,\"5PS7A17920\":1.0,\"5PS7A17940\":1.0,\"5PS7A79323\":1.0,\"5PS7A85997\":1.0,\"5PS7A85978\":1.0,\"5PS7A85958\":1.0,\"5WS7A17916\":1.0,\"5PS7A86000\":1.0,\"5PS7A86001\":1.0,\"7Y89CTO1WW\":1.0,\"5WS7A85940\":1.0,\"5AS7A83160\":1.0,\"5PS7A85972\":1.0,\"5PS7A86027\":1.0,\"5PS7A17929\":1.0,\"5PS7A85952\":1.0},\"country\":\"GB\",\"products\":[{\"code\":\"7Y89CTO1WW\",\"cto\":true,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"CTO\",\"service\":false},{\"code\":\"5641PX3\",\"cto\":true,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"CTO\",\"service\":false},{\"code\":\"5AS7A83161\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A86030\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A86031\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5WS7A79266\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A17958\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A17959\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A79278\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A17934\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A17912\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A79290\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A85980\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A85960\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5WS7A85938\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5WS7A17908\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5WS7A85932\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A17941\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A79305\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A17920\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A17940\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A79323\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A85997\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A85978\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A85958\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A86000\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5WS7A17916\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A86001\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5WS7A85940\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5AS7A83160\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A86027\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A85972\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A17929\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true},{\"code\":\"5PS7A85952\",\"cto\":false,\"discount\":1.0,\"option\":false,\"price\":0.0,\"productType\":\"SERVICE\",\"service\":true}]}";
        LBPPriceResp lbpPriceResp1 = JSON.parseObject(json, LBPPriceResp.class);
        System.out.println("由String类型的json数据转换后的对象转换成的jsonString>>>>>>" + JSON.toJSONString(lbpPriceResp1));

        LBPPriceResp lbpPriceResp = new LBPPriceResp();
        lbpPriceResp.setCountry("GB");

        LBPPriceResp.Product product = LBPPriceResp.Product.buildBy("7Y89CTO1WW", PRODUCT_TYPE_CTO, 1.0D, null, 0.0D, null);
        LBPPriceResp.Product product1 = LBPPriceResp.Product.buildBy("5641PX3", PRODUCT_TYPE_CTO, 1.0D, null, 0.0D, null);
        LBPPriceResp.Product product2 = LBPPriceResp.Product.buildBy("5AS7A83161", PRODUCT_TYPE_SERVICE, 1.0D, null, 0.0D, null);

        lbpPriceResp.setProducts(Lists.newArrayList(product, product1, product2));

        System.out.println("个人初始化的对象转换成的jsonString>>>>>>" + JSON.toJSONString(lbpPriceResp));
    }
}
