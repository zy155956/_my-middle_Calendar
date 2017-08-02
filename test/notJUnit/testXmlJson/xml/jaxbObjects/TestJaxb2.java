package notJUnit.testXmlJson.xml.jaxbObjects;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Nike on 01.08.2017.
 */
//При сериализации создаеться поля type=cat/dog,
//при десериализации информацыя вычитываеться в обьект созданный по типу равному cat/dog
//JsonTypeInfo.Id.NAME может быть JsonTypeInfo.Id.CLASS, тогда name=Cat.class/Dog.class
/*@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property="type")
@JsonSubTypes({
        @JsonSubTypes.Type(value=Cat.class, name="cat"),
        @JsonSubTypes.Type(value=Dog.class, name="dog")
})*/
@XmlRootElement
public class TestJaxb2 {
    //@XmlElement
    public String first = "first";
    @XmlElement
    private String second = "second";
}
