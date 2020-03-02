/*package com.zjl.com.test;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SourceCode {
	private ServicePreselectEsModel getRecommended(
			List<ServicePreselectEsModel> esServicePreselects,
			Map<String, ServiceEsModel> esServices, String language,
			String lfoCode, String ctoCode, String mt) {
		if (Collections.isEmpty(esServicePreselects)) {
			return null;
		}
		Optional<ServicePreselectEsModel> recommended0 = esServicePreselects
				.stream()
				.filter(esModel -> lfoCode.equalsIgnoreCase(esModel
						.getHardwareCode()))
				.filter(esModel -> esServices.get(esModel.getServiceCode()) != null)
				.filter(esModel -> RECOMMENDED_SERVICE_TIP
						.equalsIgnoreCase(esModel.getCategoryLevel2(language)))
				.findFirst();
		if (recommended0.isPresent()) {
			return setHierarchyToRecommendedService(recommended0.get(),
					esServices);
		}
		Optional<ServicePreselectEsModel> recommended1 = esServicePreselects
				.stream()
				.filter(esModel -> ctoCode.equalsIgnoreCase(esModel
						.getHardwareCode()))
				.filter(esModel -> esServices.get(esModel.getServiceCode()) != null)
				.filter(esModel -> RECOMMENDED_SERVICE_TIP
						.equalsIgnoreCase(esModel.getCategoryLevel2(language)))
				.findFirst();
		if (recommended1.isPresent()) {
			return setHierarchyToRecommendedService(recommended1.get(),
					esServices);
		}
		Optional<ServicePreselectEsModel> recommended2 = esServicePreselects
				.stream()
				.filter(esModel -> mt.equalsIgnoreCase(esModel
						.getHardwareCode()))
				.filter(esModel -> esServices.get(esModel.getServiceCode()) != null)
				.filter(esModel -> RECOMMENDED_SERVICE_TIP
						.equalsIgnoreCase(esModel.getCategoryLevel2(language)))
				.findFirst();
		if (recommended2.isPresent()) {
			return setHierarchyToRecommendedService(recommended2.get(),
					esServices);
		}
		Optional<ServicePreselectEsModel> recommended3 = esServicePreselects
				.stream()
				.filter(esModel -> lfoCode.equalsIgnoreCase(esModel
						.getHardwareCode()))
				.filter(esModel -> esServices.get(esModel.getServiceCode()) != null)
				.findFirst();
		if (recommended3.isPresent()) {
			return setHierarchyToRecommendedService(recommended3.get(),
					esServices);
		}
		Optional<ServicePreselectEsModel> recommended4 = esServicePreselects
				.stream()
				.filter(esModel -> ctoCode.equalsIgnoreCase(esModel
						.getHardwareCode()))
				.filter(esModel -> esServices.get(esModel.getServiceCode()) != null)
				.findFirst();
		if (recommended4.isPresent()) {
			return setHierarchyToRecommendedService(recommended4.get(),
					esServices);
		}
		Optional<ServicePreselectEsModel> recommended5 = esServicePreselects
				.stream()
				.filter(esModel -> mt.equalsIgnoreCase(esModel
						.getHardwareCode()))
				.filter(esModel -> esServices.get(esModel.getServiceCode()) != null)
				.findFirst();
		if (recommended5.isPresent()) {
			return setHierarchyToRecommendedService(recommended5.get(),
					esServices);
		}
		return setHierarchyToRecommendedService(esServicePreselects.get(0),
				esServices);
	}
}
*/