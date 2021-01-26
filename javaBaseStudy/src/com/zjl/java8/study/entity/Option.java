package com.zjl.java8.study.entity;

public class Option {
	private boolean showPrice = true;

	public boolean isShowPrice() {
		return showPrice;
	}

	public void setShowPrice(boolean showPrice) {
		this.showPrice = showPrice;
	}

	@Override
	public String toString() {
		return "Option [showPrice=" + showPrice + "]";
	}
}
