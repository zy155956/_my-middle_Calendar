package notJUnit.testXmlJson;

import notJUnit.testXmlJson.xml.animals.Animals;
import notJUnit.testXmlJson.xml.animals.Cat;
import notJUnit.testXmlJson.xml.animals.Dog;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.StringReader;

/**
 * Created by Nike on 02.08.2017.
 */
public class TestAnimals {
    public static void main(String[] args) throws JAXBException {
        File file = new File("xmlAndJson/anyObjectTest.xml");
        Animals animals = new Animals();
        animals.setList();
        //String str = "<animals><dog/><cat/></animals>";
        //StringReader reader = new StringReader(str);

        JAXBContext context = JAXBContext.newInstance(Animals.class, Cat.class, Dog.class);
        Marshaller marsh = context.createMarshaller();
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marsh.marshal(animals, file);

        /*Unmarshaller unm = context.createUnmarshaller();
        Animals anm = (Animals)unm.unmarshal(file);
        System.out.println(anm);*/
    }
}
