package service.events;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.UUID;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class EventWrapper {
    @XmlElement
    private UUID id;
    @XmlElement
    private String name;
    @XmlElement
    private String desctiption;
    @XmlElement
    private String startEvent;
    @XmlElement
    private String finishEvent;
    @XmlElement
    private List<PersoneWrapper> persons;

    public EventWrapper() {
    }

    public EventWrapper(Event ev) {
        this.id = ev.getId();
        this.name = ev.getName();
        this.desctiption = ev.getDesctiption();
        this.startEvent = ev.getStartEvent().toString();
        this.finishEvent = ev.getFinishEvent().toString();
        this.persons = ev.getPersons();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesctiption() {
        return desctiption;
    }

    public String getStartEvent() {
        return startEvent;
    }

    public String getFinishEvent() {
        return finishEvent;
    }

    public List<PersoneWrapper> getPersons() {
        return persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventWrapper)) return false;

        EventWrapper that = (EventWrapper) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getDesctiption() != null ? !getDesctiption().equals(that.getDesctiption()) : that.getDesctiption() != null)
            return false;
        if (getStartEvent() != null ? !getStartEvent().equals(that.getStartEvent()) : that.getStartEvent() != null)
            return false;
        if (getFinishEvent() != null ? !getFinishEvent().equals(that.getFinishEvent()) : that.getFinishEvent() != null)
            return false;
        return getPersons() != null ? getPersons().equals(that.getPersons()) : that.getPersons() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getDesctiption() != null ? getDesctiption().hashCode() : 0);
        result = 31 * result + (getStartEvent() != null ? getStartEvent().hashCode() : 0);
        result = 31 * result + (getFinishEvent() != null ? getFinishEvent().hashCode() : 0);
        result = 31 * result + (getPersons() != null ? getPersons().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventWrapper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desctiption='" + desctiption + '\'' +
                ", startEvent='" + startEvent + '\'' +
                ", finishEvent='" + finishEvent + '\'' +
                ", persons=" + persons +
                '}';
    }
}
