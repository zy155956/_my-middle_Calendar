package notJUnit.testXmlJson.xml.animals;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nike on 02.08.2017.
 */
//XmlType привязывает name к текущему классу, и десериализуя в поля типа Object всеравно получим тип Animals
@XmlType(name = "animals")
@XmlRootElement
public class Animals {
    //@XmlAny
    public List<Object> list = new ArrayList<>();

    public void setList() {
        list.add(new Cat());
        list.add(new Dog());
    }

    @Override
    public String toString() {
        return "Animals{" +
                "list=" + list +
                '}';
    }
}
