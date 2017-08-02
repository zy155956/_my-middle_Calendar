package notJUnit.testXmlJson.xml.enumss;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Nike on 02.08.2017.
 */
@XmlType
@XmlEnum(String.class)
@XmlRootElement
public enum PetsString {
    @XmlEnumValue("kitty")
    CAT,
    @XmlEnumValue("doggy")
    DOG
}
