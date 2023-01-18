package qa.learning;

import java.util.Objects;

public final class ContactData {
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String phone;
    private final String email;

    public ContactData(String firstName, String secondName, String address, String phone, String email) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String firstName() {
        return firstName;
    }

    public String secondName() {
        return secondName;
    }

    public String address() {
        return address;
    }

    public String phone() {
        return phone;
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ContactData) obj;
        return Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.secondName, that.secondName) &&
                Objects.equals(this.address, that.address) &&
                Objects.equals(this.phone, that.phone) &&
                Objects.equals(this.email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, address, phone, email);
    }

    @Override
    public String toString() {
        return "ContactData[" +
                "firstName=" + firstName + ", " +
                "secondName=" + secondName + ", " +
                "address=" + address + ", " +
                "phone=" + phone + ", " +
                "email=" + email + ']';
    }

}