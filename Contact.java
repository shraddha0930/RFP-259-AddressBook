import java.util.Scanner;

public class Contact implements Comparable {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private long phoneNumber;
    private String email;

    public Contact() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Scanner scanner = new Scanner(System.in);
        Contact contact = (Contact) o;
        System.out.println("Sort by \n1. State  Name \n2. City Name \n3. zipcode");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                int compareResult = this.city.compareTo(contact.city);
                return compareResult;
            case 2:
                int compareResult1 = this.state.compareTo(contact.state);
                return compareResult1;
            case 3:
                if (this.zipcode == (contact.zipcode))
                    return contact.getZipcode();
            break;
        }
        return option;
    }
}