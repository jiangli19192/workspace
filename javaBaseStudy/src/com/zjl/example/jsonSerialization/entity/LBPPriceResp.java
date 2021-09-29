package com.zjl.example.jsonSerialization.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class LBPPriceResp implements Serializable {
    private static final String BUSINESSUNIT_DEFAULT = "DCG";
    private String country;
    private String businessUnit = BUSINESSUNIT_DEFAULT;
    private List<Product> products;

    public Map<String, Double> getAllCtoMarginMap() {
        return this.getProducts().stream().filter(product -> product.isCto()).collect(Collectors.toMap(Product::getCode, Product::getMargin));
    }

    @Data
    public static final class Product implements Serializable {

        public static final String PRODUCT_TYPE_CTO = "CTO";
        public static final String PRODUCT_TYPE_LFO = "LFO";
        public static final String PRODUCT_TYPE_SERVICE = "SERVICE";
        public static final String PRODUCT_TYPE_OPTION = "OPTION";
        private String code;
        private String productType;
        private double discount;
        private Double margin;
        /**
         * binding fixed price
         */
        private double price;
        private List<Feature> features;

        public boolean isCto() {
            return this.getProductType().equals(PRODUCT_TYPE_CTO);
        }

        public boolean isService() {
            return this.getProductType().equals(PRODUCT_TYPE_SERVICE);
        }

        public boolean isOption() {
            return this.getProductType().equals(PRODUCT_TYPE_OPTION);
        }

        public static Product buildBy(String code, String productType, double discount, Double margin, double price, List<Feature> features) {
            Product product = new Product();
            product.setCode(code);
            product.setProductType(productType);
            product.setDiscount(discount);
            product.setMargin(margin);
            product.setPrice(price);
            product.setFeatures(features);
            return product;
        }
    }

    @Data
    public static final class Feature implements Serializable {
        private String code;
        /**
         * binding fixed price
         */
        private Double price;
    }
}
