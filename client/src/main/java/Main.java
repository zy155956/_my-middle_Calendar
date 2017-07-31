import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.events.EventImpl;
import service.events.PersoneImpl;
import service.events.PersoneWrapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Nike on 09.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring/dispatcher.xml");
        CalendarStore calendar = (CalendarStore) context.getBean("calendarService");

        PersoneImpl persone = new PersoneImpl.Builder()
                .setEmail("remoteEmail1")
                .setFirstName("remotFirstName1")
                .setLastName("remotLastName1")
                .setPhone("remotPhone1")
                .build();
        PersoneWrapper pWrapper = new PersoneWrapper(persone);
        List<PersoneWrapper> listP = new ArrayList<>();
        listP.add(pWrapper);
        ///////////////////////////////////////////////////////////////
        EventImpl event = new EventImpl.Builder()
                .setStartEvent(LocalDateTime.now())
                .setId(UUID.randomUUID())
                .setName("remoteName1")
                .setDesctiption("remoteDescription1")
                .setPersons(listP)
                .setFinishEvent(LocalDateTime.now())
                .build();
        ///////////////////////////////////////////////////////////////
        calendar.publish(event);
    }
}
