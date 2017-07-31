package service.events;

import java.io.Serializable;

/**
 * Created by Nike on 09.07.2017.
 */
public class PersoneImpl implements Persone, Serializable {
    private static final long serialVersionUID = 65L;

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    private PersoneImpl(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.phone = builder.phone;
    }

    public static class Builder{
        private String firstName;
        private String lastName;
        private String email;
        private String phone;

        public Builder() {
        }

        public Builder(Persone persone) {
            this.firstName = persone.getFirstName();
            this.lastName = persone.getLastName();
            this.email = persone.getEmail();
            this.phone = persone.getPhone();
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public PersoneImpl build(){
            return new PersoneImpl(this);
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersoneImpl)) return false;

        PersoneImpl persone = (PersoneImpl) o;

        if (getFirstName() != null ? !getFirstName().equals(persone.getFirstName()) : persone.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(persone.getLastName()) : persone.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(persone.getEmail()) : persone.getEmail() != null) return false;
        return getPhone() != null ? getPhone().equals(persone.getPhone()) : persone.getPhone() == null;
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
        return "PersoneImpl{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
