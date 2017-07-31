package service.events;


import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface Event {
    public UUID getId();

    public String getName();

    public String getDesctiption();

    public LocalDateTime getStartEvent();

    public LocalDateTime getFinishEvent();

    public List<PersoneWrapper> getPersons();
}
