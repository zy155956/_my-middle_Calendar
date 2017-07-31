package service.events;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement
public class PersoneWrapper implements Persone {
    private static final long serialVersionUID = 67L;

    //@XmlElement
    private String firstName;
    //@XmlElement
    private String lastName;
    //@XmlElement
    private String email;
    //@XmlElement
    private String phone;

    public PersoneWrapper() {
    }

    public PersoneWrapper(Persone persone) {
        this.firstName = persone.getFirstName();
        this.lastName = persone.getLastName();
        this.email = persone.getEmail();
        this.phone = persone.getPhone();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    //@XmlElement(name = "name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //@XmlElement(name = "secondName")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //@XmlElement(name = "e-mail")
    public void setEmail(String email) {
        this.email = email;
    }

    //@XmlElement(name = "phoneNumber")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersoneWrapper)) return false;

        PersoneWrapper that = (PersoneWrapper) o;

        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(that.getEmail()) : that.getEmail() != null) return false;
        return getPhone() != null ? getPhone().equals(that.getPhone()) : that.getPhone() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersoneWrapper{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
