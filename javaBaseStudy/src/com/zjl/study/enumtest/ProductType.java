package com.zjl.study.enumtest;


public enum ProductType {
    CTO("CTO"),
    LFO("LFO"),
    SERVICE("SERVICE"),
    OPTION("OPTION");

    private String name;

    ProductType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
	
	public static void main(String[] args) {
		System.out.println(ProductType.OPTION.getName());
		System.out.println("OPTION".equals(ProductType.OPTION.getName()));
	}

}
