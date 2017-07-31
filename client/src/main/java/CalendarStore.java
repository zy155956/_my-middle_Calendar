

import service.events.Event;

import java.util.Map;
import java.util.UUID;

public interface CalendarStore {
    void publish(Event ev);
    Event remove(UUID uid);
    Event getEvent(UUID uid);
    Map<UUID, Event> getMapEvents();
}
