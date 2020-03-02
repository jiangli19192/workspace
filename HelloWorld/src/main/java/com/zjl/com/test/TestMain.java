/*package com.zjl.com.test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class TestMain {
	private ServicePreselectEsModel getRecommendService(List<ServicePreselectEsModel> preSelect, Map<String, ServiceEsModel> esServices, String language) {
	     
	    // 首先根据equalsIgnoreCase(RECOMMENDED_SERVICE_TIP)分组，标记为RECOMMENDED_SERVICE_TIP的候选记录优先级高于未标记记录
	    Map<Boolean, List<ServicePreselectEsModel>> group = preSelect.stream()
	        .filter(esModel -> esServices.get(esModel.getServiceCode()) != null)
	        .collect(Collectors.groupingBy(o -> o.getCategoryLevel2(language).equalsIgnoreCase(RECOMMENDED_SERVICE_TIP)));
	 
	    // 分别根据上述两个分组结果，按产品ProductTypeSeq排序
	    List<ServicePreselectEsModel> subGroupa = Lists.newArrayList();
	    if (group.containsKey(Boolean.TRUE)) {
	        subGroupa = group.get(Boolean.TRUE).stream()
	            .sorted(Comparator.comparing(ServicePreselectEsModel::getProductTypeSeq))      // 将优先级划分的职责归于ServicePreselectEsModel类本身，即“属于谁的活儿谁干”
	            .collect(toList());
	    }
	 
	    List<ServicePreselectEsModel> subGroupb = Lists.newArrayList();
	    if (group.containsKey(Boolean.TRUE)) {
	        subGroupb = group.get(Boolean.FALSE).stream()
	            .sorted(Comparator.comparing(ServicePreselectEsModel::getProductTypeSeq))
	            .collect(toList());
	    }
	 
	    // 排序后的结果合并为有序集合，集合的第0条记录即为最匹配条件记录
	    List<ServicePreselectEsModel> result = Lists.newArrayList(subGroupa);
	    result.addAll(subGroupb);
	 
	    if (CollectionUtils.isNotEmpty(result)) {
	        return setHierarchyToRecommendedService(result.get(0), esServices);
	    }
	 
	    return setHierarchyToRecommendedService(preSelect.get(0), esServices);
	}
}
*/