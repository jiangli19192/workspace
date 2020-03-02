package com.zjl.com.test;

import java.util.ArrayList;
import java.util.List;

public class ServiceEsModel extends BaseProduct {
    private String country;
    private String hwCompatibility;
    private String serviceCode;
    private String specialBid;
    private String hierarchy;
    private String category;
    private boolean recommended;
    private List<Facet> facets = new ArrayList<Facet>();
    
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHwCompatibility() {
		return hwCompatibility;
	}
	public void setHwCompatibility(String hwCompatibility) {
		this.hwCompatibility = hwCompatibility;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getSpecialBid() {
		return specialBid;
	}
	public void setSpecialBid(String specialBid) {
		this.specialBid = specialBid;
	}
	public String getHierarchy() {
		return hierarchy;
	}
	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isRecommended() {
		return recommended;
	}
	public void setRecommended(boolean recommended) {
		this.recommended = recommended;
	}
	public List<Facet> getFacets() {
		return facets;
	}
	public void setFacets(List<Facet> facets) {
		this.facets = facets;
	}
}