package notJUnit.testXmlJson.xml.animals;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Nike on 02.08.2017.
 */
//XmlType привязывает name к текущему классу, и десериализуя в поля типа Object всеравно получим тип Cat
@XmlType(name = "cat")
@XmlRootElement
public class Cat {
    private String name = "kitty";
}
