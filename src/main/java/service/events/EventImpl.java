package service.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class EventImpl implements Event, Serializable {
    private static final long serialVersionUID = 55L;

    @XmlElement
    private final UUID id;
    @XmlElement
    private final String name;
    private final String desctiption;
    private final LocalDateTime startEvent;
    private final LocalDateTime finishEvent;
    private final List<PersoneWrapper> persons;

    private EventImpl(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.desctiption = builder.desctiption;
        this.startEvent = builder.startEvent;
        this.finishEvent = builder.finishEvent;
        this.persons = builder.persons;
    }

    public static class Builder {
        private UUID id;
        private String name;
        private String desctiption;
        private LocalDateTime startEvent;
        private LocalDateTime finishEvent;
        private List<PersoneWrapper> persons;

        public Builder() {
        }

        public Builder(EventImpl event) {
            this.id = event.id;
            this.name = event.name;
            this.desctiption = event.desctiption;
            this.startEvent = event.startEvent;
            this.finishEvent = event.finishEvent;
            this.persons = event.persons;
        }

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDesctiption(String desctiption) {
            this.desctiption = desctiption;
            return this;
        }

        public Builder setStartEvent(LocalDateTime startEvent) {
            this.startEvent = startEvent;
            return this;
        }

        public Builder setFinishEvent(LocalDateTime finishEvent) {
            this.finishEvent = finishEvent;
            return this;
        }

        public Builder setPersons(List<PersoneWrapper> persons) {
            this.persons = persons;
            return this;
        }

        public EventImpl build(){
            return new EventImpl(this);
        }
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDesctiption() {
        return desctiption;
    }

    @Override
    public LocalDateTime getStartEvent() {
        return startEvent;
    }

    @Override
    public LocalDateTime getFinishEvent() {
        return finishEvent;
    }

    @Override
    public List<PersoneWrapper> getPersons() {
        return persons;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj.getClass() != this.getClass() || obj == null) return false;
        EventImpl event = (EventImpl)obj;

        if(getId()!=null? !getId().equals(event.getId()):event.getId()!=null)return false;
        if(getName()!=null? !getName().equals(event.getName()):event.getName()!=null) return false;
        if(getDesctiption()!=null? !getDesctiption().equals(event.getDesctiption()):event.getDesctiption()!=null) return false;
        if(getStartEvent()!=null? !getStartEvent().equals(event.getStartEvent()):event.getStartEvent()!=null) return false;
        if(getFinishEvent()!=null? !getFinishEvent().equals(event.getFinishEvent()):event.getFinishEvent()!=null) return false;
        if(getPersons()!=null? !getPersons().equals(event.getPersons()):event.getPersons()!=null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (getId() != null ? getId().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDesctiption() != null ? getDesctiption().hashCode() : 0);
        result = 31 * result + (getStartEvent() != null ? getStartEvent().hashCode() : 0);
        result = 31 * result + (getFinishEvent() != null ? getFinishEvent().hashCode() : 0);
        result = 31 * result + (getPersons() != null ? getPersons().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desctiption='" + desctiption + '\'' +
                ", startEvent=" + startEvent +
                ", finishEvent=" + finishEvent +
                ", persons=" + persons +
                '}';
    }
}
