package qa.learning.model;

import java.util.Objects;

public final class ContactData {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phoneMobile;
    private final String email;

    public ContactData(int id, String firstName, String lastName, String address, String phoneMobile, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneMobile = phoneMobile;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (!Objects.equals(firstName, that.firstName)) return false;
        return Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    public ContactData(String firstName, String lastName, String address, String phoneMobile, String email) {
        this.id = Integer.MAX_VALUE;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneMobile = phoneMobile;
        this.email = email;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String address() {
        return address;
    }

    public String phoneMobile() {
        return phoneMobile;
    }

    public String email() {
        return email;
    }

}