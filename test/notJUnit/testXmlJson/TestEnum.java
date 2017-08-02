package notJUnit.testXmlJson;

import notJUnit.testXmlJson.xml.enumss.PetsInt;
import notJUnit.testXmlJson.xml.enumss.PetsString;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Nike on 02.08.2017.
 */
public class TestEnum {
    public static void main(String[] args) throws JAXBException {
        File file = new File("xmlAndJson/enumTest.xml");
        JAXBContext context = JAXBContext.newInstance(PetsInt.class, PetsString.class);
        Marshaller marsh = context.createMarshaller();
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marsh.marshal(PetsString.CAT, file);

        Unmarshaller unm = context.createUnmarshaller();
        //PetsInt anm = (PetsInt)unm.unmarshal(file);
        PetsString anm = (PetsString)unm.unmarshal(file);
        System.out.println(anm);
    }
}
