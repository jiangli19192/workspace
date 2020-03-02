package com.lenovo.lesc.validation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2017-05-17T17:06:13.075+08:00
 * Generated source version: 3.1.6
 * 
 */
@WebService(targetNamespace = "http://www.lenovo.com/lesc/validation", name = "Validation")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface Validation {

    @WebMethod(operationName = "Validation")
    @WebResult(name = "ValidationResponse", targetNamespace = "http://www.lenovo.com/lesc/validation", partName = "ValidationResponse")
    public ValidationResponse validation(
        @WebParam(partName = "ValidationRequest", name = "ValidationRequest", targetNamespace = "http://www.lenovo.com/lesc/validation")
        ValidationRequest validationRequest
    );
}
