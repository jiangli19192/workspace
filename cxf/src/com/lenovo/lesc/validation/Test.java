package com.lenovo.lesc.validation;

public class Test {
	public static void main(String[] args) {
		
		ObjectFactory obj = new ObjectFactory();
		
		ValidationRequest validationRequest = obj.createValidationRequest();
		validationRequest.setSiteType(SiteType.CRM);
		byte[] value = new byte[]{'1','3'};
		validationRequest.setCFXML(value);
		validationRequest.setUserRole("0");
		
		
		ValidationService service = new ValidationService();
		Validation validation = service.getValidationSoap11();
		ValidationResponse response = validation.validation(validationRequest);
		
		System.out.println(response.isResult());
		
		
	}

}
