
package com.lenovo.lesc.validation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CFXML" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *         &lt;element name="SiteType" type="{http://www.lenovo.com/lesc/validation}SiteType"/&gt;
 *         &lt;element name="UserRole" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cfxml",
    "siteType",
    "userRole"
})
@XmlRootElement(name = "ValidationRequest")
public class ValidationRequest {

    @XmlElement(name = "CFXML", required = true)
    protected byte[] cfxml;
    @XmlElement(name = "SiteType", required = true, defaultValue = "OTHERS")
    @XmlSchemaType(name = "string")
    protected SiteType siteType;
    @XmlElement(name = "UserRole")
    protected String userRole;

    /**
     * 获取cfxml属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCFXML() {
        return cfxml;
    }

    /**
     * 设置cfxml属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCFXML(byte[] value) {
        this.cfxml = value;
    }

    /**
     * 获取siteType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SiteType }
     *     
     */
    public SiteType getSiteType() {
        return siteType;
    }

    /**
     * 设置siteType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SiteType }
     *     
     */
    public void setSiteType(SiteType value) {
        this.siteType = value;
    }

    /**
     * 获取userRole属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置userRole属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserRole(String value) {
        this.userRole = value;
    }

}
