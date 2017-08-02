package notJUnit.testXmlJson.xml.jaxbObjects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nike on 01.08.2017.
 */
@XmlRootElement
public class TestJaxb {
    @XmlElement
    private List<String> listString;
    @XmlElementWrapper(name = "listWrapper")
    @XmlElement
    private List<TestJaxb2> listJaxb;

    {
        listString = new ArrayList<>();
        listJaxb = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listString.add("numb="+i);
        }
    }

    public void setListJaxb() {
        for (int i = 0; i < 5; i++) {
            listJaxb.add(new TestJaxb2());
        }
    }

    @XmlElement
    private String str1 = "str1";
    @XmlElement
    private int numb1 = 11;
    @XmlElement
    private boolean bool = true;
    @XmlElement
    private TestJaxb2 jaxb = new TestJaxb2();

    @Override
    public String toString() {
        return "TestJaxb{" +
                "listString=" + listString +
                ", str1='" + str1 + '\'' +
                ", numb1=" + numb1 +
                ", bool=" + bool +
                ", jaxb=" + jaxb +
                '}';
    }
}
