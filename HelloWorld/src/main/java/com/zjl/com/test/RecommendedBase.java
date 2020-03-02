package com.zjl.com.test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

class RecommendedFactory {
	public static final String RECOMMENDED_SERVICE_TIP = "";
	static Map<String, Optional<ServicePreselectEsModel>> recommendedMap = new LinkedHashMap<String, Optional<ServicePreselectEsModel>>();

	public static void register(String recommendedType, Optional<ServicePreselectEsModel> esModeOptional) {
		recommendedMap.put(recommendedType, esModeOptional);
	}

	public static void initRecommendedMap(List<ServicePreselectEsModel> newEsServicePreselects, String lfoCode, String ctoCode, String mt, String language) {
		new Recommended0().getRecommendedOptional(newEsServicePreselects, lfoCode, language);
		new Recommended1().getRecommendedOptional(newEsServicePreselects, ctoCode, language);
		new Recommended2().getRecommendedOptional(newEsServicePreselects, mt, language);
	}
	
	public static void main(String[] args) {
		List<ServicePreselectEsModel> newEsServicePreselects = Lists.newArrayList(new ServicePreselectEsModel());
		RecommendedFactory.initRecommendedMap(newEsServicePreselects, "lfoCode", "ctoCode", "7X06", "en");
		System.out.println(recommendedMap.size());
		
		getRecommended(newEsServicePreselects);
	}

	private static ServicePreselectEsModel getRecommended(List<ServicePreselectEsModel> newEsServicePreselects) {
		Map<String, ServiceEsModel> esServices = Maps.newHashMap();
		
		
		for(Entry<String, Optional<ServicePreselectEsModel>> entry : recommendedMap.entrySet()) {
            System.out.println("key:" + entry.getKey() + "   value:" + entry.getValue());
            Optional<ServicePreselectEsModel> esModel = entry.getValue();
            if (esModel.isPresent()) {
				return setHierarchyToRecommendedService(esModel.get(), esServices);
            }
        }
		
		return setHierarchyToRecommendedService(newEsServicePreselects.get(0), esServices);
	}

	private static ServicePreselectEsModel setHierarchyToRecommendedService(ServicePreselectEsModel servicePreselectEsModel,
			Map<String, ServiceEsModel> esServices) {
		return null;
	}

}

public interface RecommendedBase {
	Optional<ServicePreselectEsModel> getRecommendedOptional(List<ServicePreselectEsModel> newEsServicePreselects,
			String code, String language);

	boolean isEmpty(Optional<ServicePreselectEsModel> esModeOptional);
}

class Recommended0 implements RecommendedBase {

	@Override
	public Optional<ServicePreselectEsModel> getRecommendedOptional(
			List<ServicePreselectEsModel> newEsServicePreselects, String code, String language) {
		Optional<ServicePreselectEsModel> recommended0 = newEsServicePreselects.stream()
				.filter(esModel -> code.equalsIgnoreCase(esModel.getHardwareCode()))
				.filter(esModel -> RecommendedFactory.RECOMMENDED_SERVICE_TIP
						.equalsIgnoreCase(esModel.getCategoryLevel2(language)))
				.findFirst();

		RecommendedFactory.register("recommended0", recommended0);
		return recommended0;
	}

	public boolean isEmpty(Optional<ServicePreselectEsModel> esModeOptional) {
		return !esModeOptional.isPresent();
	}
}

class Recommended1 implements RecommendedBase {
	@Override
	public Optional<ServicePreselectEsModel> getRecommendedOptional(
			List<ServicePreselectEsModel> newEsServicePreselects, String code, String language) {
		Optional<ServicePreselectEsModel> recommended1 = newEsServicePreselects.stream()
				.filter(esModel -> code.equalsIgnoreCase(esModel.getHardwareCode()))
				.filter(esModel -> RecommendedFactory.RECOMMENDED_SERVICE_TIP
						.equalsIgnoreCase(esModel.getCategoryLevel2(language)))
				.findFirst();

		RecommendedFactory.register("recommended1", recommended1);
		return recommended1;
	}

	@Override
	public boolean isEmpty(Optional<ServicePreselectEsModel> esModeOptional) {
		return !esModeOptional.isPresent();
	}
}

class Recommended2 implements RecommendedBase {
	@Override
	public Optional<ServicePreselectEsModel> getRecommendedOptional(
			List<ServicePreselectEsModel> newEsServicePreselects, String code, String language) {
		Optional<ServicePreselectEsModel> recommended2 = newEsServicePreselects.stream()
				.filter(esModel -> code.equalsIgnoreCase(esModel.getHardwareCode()))
				.filter(esModel -> RecommendedFactory.RECOMMENDED_SERVICE_TIP
						.equalsIgnoreCase(esModel.getCategoryLevel2(language)))
				.findFirst();

		RecommendedFactory.register("recommended2", recommended2);
		return recommended2;
	}

	@Override
	public boolean isEmpty(Optional<ServicePreselectEsModel> esModeOptional) {
		return !esModeOptional.isPresent();
	}
}