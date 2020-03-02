
package com.lenovo.lesc.validation;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>SiteType的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * <p>
 * <pre>
 * &lt;simpleType name="SiteType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="LMS"/&gt;
 *     &lt;enumeration value="ELOIS"/&gt;
 *     &lt;enumeration value="CRM"/&gt;
 *     &lt;enumeration value="CVRM"/&gt;
 *     &lt;enumeration value="LBP"/&gt;
 *     &lt;enumeration value="PUBLIC"/&gt;
 *     &lt;enumeration value="ECOM"/&gt;
 *     &lt;enumeration value="OTHERS"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SiteType")
@XmlEnum
public enum SiteType {

    LMS,
    ELOIS,
    CRM,
    CVRM,
    LBP,
    PUBLIC,
    ECOM,
    OTHERS;

    public String value() {
        return name();
    }

    public static SiteType fromValue(String v) {
        return valueOf(v);
    }

}
