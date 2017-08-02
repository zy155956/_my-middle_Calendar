package notJUnit.testXmlJson.xml.enumss;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Nike on 02.08.2017.
 */
@XmlType
@XmlEnum(Integer.class)
@XmlRootElement
public enum PetsInt {
    @XmlEnumValue("1")
    CAT,
    @XmlEnumValue("3")
    DOG
}
