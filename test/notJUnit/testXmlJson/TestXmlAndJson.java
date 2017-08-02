package notJUnit.testXmlJson;

import com.fasterxml.jackson.databind.ObjectMapper;
import notJUnit.testXmlJson.json.TestJackson;
import notJUnit.testXmlJson.xml.jaxbObjects.TestJaxb;
import notJUnit.testXmlJson.xml.jaxbObjects.TestJaxb2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;

/**
 * Created by Nike on 01.08.2017.
 */
public class TestXmlAndJson {
    public static void main(String[] args)throws JAXBException, IOException {
        TestJaxb jaxb = new TestJaxb();
        jaxb.setListJaxb();
        File fileXml = new File("xmlAndJson/JaxbTest.xml");

        marshalXML(jaxb, fileXml);
        TestJaxb unmJaxb = (TestJaxb)unmarshalXML(fileXml);
        System.out.println(unmJaxb);
        //////////////////////////
        /*TestJackson jackson = new TestJackson();
        jackson.setListJaxon();
        File fileJson = new File("xmlAndJson/JacksonTest.json");

        marshalJson(jackson, fileJson);
        TestJackson unmJackson = (TestJackson)unmarshalJson(fileJson);
        System.out.println(unmJackson);*/

        ///////////////////////////
        /*ArrayList<TestJackson2> listJson = new ArrayList<>();
        File file = new File("xmlAndJson/List.json");
        for (int i = 0; i < 3; i++) {
            listJson.add(new TestJackson2());
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, listJson);*/
    }

    private static void marshalXML(TestJaxb jaxb, File fileXml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(jaxb.getClass(), TestJaxb2.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(jaxb, fileXml);
    }

    private static Object unmarshalXML(File fileXml) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(TestJaxb.class, TestJaxb2.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(fileXml);
    }

    private static void marshalJson(TestJackson jackson, File fileJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(fileJson, jackson);
    }

    private static Object unmarshalJson(File fileJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fileJson, TestJackson.class);
    }
}
