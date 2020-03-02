
package com.zjl.study.springcxf.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zjl.study.springcxf.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayHi_QNAME = new QName("com:zjl:study:springcxf:webservice", "sayHi");
    private final static QName _SayHiResponse_QNAME = new QName("com:zjl:study:springcxf:webservice", "sayHiResponse");
    private final static QName _SayHiToUser_QNAME = new QName("com:zjl:study:springcxf:webservice", "sayHiToUser");
    private final static QName _SayHiToUserList_QNAME = new QName("com:zjl:study:springcxf:webservice", "sayHiToUserList");
    private final static QName _SayHiToUserListResponse_QNAME = new QName("com:zjl:study:springcxf:webservice", "sayHiToUserListResponse");
    private final static QName _SayHiToUserResponse_QNAME = new QName("com:zjl:study:springcxf:webservice", "sayHiToUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zjl.study.springcxf.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHi }
     * 
     */
    public SayHi createSayHi() {
        return new SayHi();
    }

    /**
     * Create an instance of {@link SayHiResponse }
     * 
     */
    public SayHiResponse createSayHiResponse() {
        return new SayHiResponse();
    }

    /**
     * Create an instance of {@link SayHiToUser }
     * 
     */
    public SayHiToUser createSayHiToUser() {
        return new SayHiToUser();
    }

    /**
     * Create an instance of {@link SayHiToUserList }
     * 
     */
    public SayHiToUserList createSayHiToUserList() {
        return new SayHiToUserList();
    }

    /**
     * Create an instance of {@link SayHiToUserListResponse }
     * 
     */
    public SayHiToUserListResponse createSayHiToUserListResponse() {
        return new SayHiToUserListResponse();
    }

    /**
     * Create an instance of {@link SayHiToUserResponse }
     * 
     */
    public SayHiToUserResponse createSayHiToUserResponse() {
        return new SayHiToUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHi }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com:zjl:study:springcxf:webservice", name = "sayHi")
    public JAXBElement<SayHi> createSayHi(SayHi value) {
        return new JAXBElement<SayHi>(_SayHi_QNAME, SayHi.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com:zjl:study:springcxf:webservice", name = "sayHiResponse")
    public JAXBElement<SayHiResponse> createSayHiResponse(SayHiResponse value) {
        return new JAXBElement<SayHiResponse>(_SayHiResponse_QNAME, SayHiResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiToUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com:zjl:study:springcxf:webservice", name = "sayHiToUser")
    public JAXBElement<SayHiToUser> createSayHiToUser(SayHiToUser value) {
        return new JAXBElement<SayHiToUser>(_SayHiToUser_QNAME, SayHiToUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiToUserList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com:zjl:study:springcxf:webservice", name = "sayHiToUserList")
    public JAXBElement<SayHiToUserList> createSayHiToUserList(SayHiToUserList value) {
        return new JAXBElement<SayHiToUserList>(_SayHiToUserList_QNAME, SayHiToUserList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiToUserListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com:zjl:study:springcxf:webservice", name = "sayHiToUserListResponse")
    public JAXBElement<SayHiToUserListResponse> createSayHiToUserListResponse(SayHiToUserListResponse value) {
        return new JAXBElement<SayHiToUserListResponse>(_SayHiToUserListResponse_QNAME, SayHiToUserListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHiToUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "com:zjl:study:springcxf:webservice", name = "sayHiToUserResponse")
    public JAXBElement<SayHiToUserResponse> createSayHiToUserResponse(SayHiToUserResponse value) {
        return new JAXBElement<SayHiToUserResponse>(_SayHiToUserResponse_QNAME, SayHiToUserResponse.class, null, value);
    }

}
