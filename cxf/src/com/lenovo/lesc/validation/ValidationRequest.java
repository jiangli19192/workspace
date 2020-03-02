
package com.lenovo.lesc.validation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
     * ��ȡcfxml���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCFXML() {
        return cfxml;
    }

    /**
     * ����cfxml���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCFXML(byte[] value) {
        this.cfxml = value;
    }

    /**
     * ��ȡsiteType���Ե�ֵ��
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
     * ����siteType���Ե�ֵ��
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
     * ��ȡuserRole���Ե�ֵ��
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
     * ����userRole���Ե�ֵ��
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
