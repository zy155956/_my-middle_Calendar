import service.JAXBimpl.PersistJAXBimpl;
import service.events.EventImpl;
import service.events.EventWrapper;
import service.events.PersoneImpl;
import service.events.PersoneWrapper;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Created by Nike on 09.07.2017.
 * Тестируем service. Запускаем service, получаем данные от Client, и преобразуем их в xmk, json файлы
 */
public class Main {
    public static void main(String[] args)throws IOException {
        PersistJAXBimpl jaxb = new PersistJAXBimpl();
        File file = new File("xmlFiles/testFile1.xml");
        File file2 = new File("xmlFiles/testFile2.xml");

        ///////////////////////////////////////////////////////////////////////////
        PersoneImpl persone = new PersoneImpl.Builder()
                .setEmail("testEmail1")
                .setFirstName("testFirstName1")
                .setLastName("testLastName1")
                .setPhone("testPhone1")
                .build();
        PersoneWrapper pWrapper = new PersoneWrapper(persone);
        List<PersoneWrapper> listP = new ArrayList<>();
        listP.add(pWrapper);
        ///////////////////////////////////////////////////////////////////////////
        EventImpl event = new EventImpl.Builder().setStartEvent(LocalDateTime.now())
                .setId(UUID.randomUUID()).setName("testName1")
                .setDesctiption("testDescription1")
                .setPersons(listP)
                .setFinishEvent(LocalDateTime.now()).build();
        EventWrapper evWrapper = new EventWrapper(event);
        Class[] classes1 = new Class[]{PersoneWrapper.class};
        Class[] classes2 = new Class[]{PersoneWrapper.class, EventWrapper.class};
        ////////////////////////////////////////////////////////////////////////////


        testJAXB(jaxb, file, pWrapper, classes1);
        testJAXB(jaxb, file2, evWrapper, classes2);

        PersistJAXBimpl.shutDown();

    }

    private static void testJAXB(PersistJAXBimpl jaxb, File file, Object event, Class[] classes2) {
        try {
            jaxb.marshul(event, classes2, file);
            Object unmEvent = null;
            if (event instanceof EventWrapper){
                unmEvent = (EventWrapper) jaxb.unmarshul(file);
            }
            if (event instanceof PersoneWrapper){
                unmEvent = (PersoneWrapper) jaxb.unmarshul(file);
            }


            if (unmEvent != null){
                System.out.println(unmEvent);
            }else System.out.println("unmPersone = null!");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
