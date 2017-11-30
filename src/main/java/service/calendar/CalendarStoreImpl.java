package service.calendar;

import service.JAXBimpl.PersistJAXBimpl;
import service.events.Event;
import service.events.EventWrapper;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.*;

public class CalendarStoreImpl implements CalendarStore {
    private Map<UUID, Event> events = new HashMap<>();
    private PersistJAXBimpl jaxb = new PersistJAXBimpl();

    @Override
    public void publish(Event ev) {
        if (ev != null) events.put(ev.getId(), ev);
        //persistEvent(ev);
    }

    @Override
    public Event remove(UUID uid) {
        Event ev = null;
        if (uid != null){
            ev = events.get(uid);
            events.remove(uid);
        }
        return ev;
    }

    @Override
    public Event getEvent(UUID uid) {
        Event ev = null;
        if (uid != null){
            ev = events.get(uid);
        }
        return ev;
    }

    @Override
    public Map<UUID, Event> getMapEvents() {
        return events;
    }

    private void persistEvent(Event ev){
        File file = new File("xmlFiles/"+ev.getId()+".xml");
        try {
            jaxb.marshul(new EventWrapper(ev), new Class[]{EventWrapper.class}, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Map<String, List<UUID>> getMapUniqueName(){
        Map<String, List<UUID>> map = new HashMap<>();
        Set<String> names = new HashSet<>();

        if (events == null || events.size() == 0){
            System.err.println("Events doesn't founds!");
            return map;
        }

        for (Map.Entry<UUID, Event> entry : events.entrySet()) {
            names.add(entry.getValue().getName());
        }
        for (String name : names) {
            List<UUID> list = new ArrayList<>();
            for (Map.Entry<UUID, Event> entry : events.entrySet()) {
                if (entry.getValue().getName().equals(name))
                    list.add(entry.getKey());
            }
            map.put(name, list);
        }
        return map;
    }

    public List<Event> searchByName(String title){
        List<Event> list = new ArrayList<>();
        for (Map.Entry<UUID, Event> pair : events.entrySet()) {
            if (pair.getValue().getName().equals(title))
                list.add(pair.getValue());
        }
        return list;
    }

    public void setJaxb(PersistJAXBimpl jaxb){
        this.jaxb = jaxb;
    }
}
