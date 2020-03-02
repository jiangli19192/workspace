package com.zjl.com.test;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class ServicePreselectEsModel {
    private String hardwareCode;
    private String productType; // LFO | CTO | MT
    private String serviceCode;
    private Integer sequence;
    private List<BaseDescription> categoryLevel2s = Lists.newArrayList();
    private List<BaseDescription> descriptions = Lists.newArrayList();
    private List<Facet> facets = new ArrayList<>();
    private String hierarchy;
    
    
	public String getHardwareCode() {
		return hardwareCode;
	}
	public void setHardwareCode(String hardwareCode) {
		this.hardwareCode = hardwareCode;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public List<BaseDescription> getCategoryLevel2s() {
		return categoryLevel2s;
	}
	public void setCategoryLevel2s(List<BaseDescription> categoryLevel2s) {
		this.categoryLevel2s = categoryLevel2s;
	}
	public List<BaseDescription> getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(List<BaseDescription> descriptions) {
		this.descriptions = descriptions;
	}
	public List<Facet> getFacets() {
		return facets;
	}
	public void setFacets(List<Facet> facets) {
		this.facets = facets;
	}
	public String getHierarchy() {
		return hierarchy;
	}
	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy;
	}
	public String getCategoryLevel2(String language) {
		// TODO Auto-generated method stub
		return null;
	}
}