import java.util.Scanner;

public class Contact {
    private String firstName ;
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

    public void getPersonDetails(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First Name : ");
        firstName = input.next();
        System.out.print("Enter Lat Name : ");
        lastName = input.next();
        System.out.print("Enter Address : ");
        address = input.next();
        System.out.print("Enter City : ");
        city = input.next();
        System.out.print("Enter State : ");
        state = input.next();
        System.out.print("Enter Zipcode : ");
        zipcode = input.nextInt();
        System.out.print("Enter Phone number : ");
        phoneNumber = input.nextLong();
        System.out.print("Enter Email ID : ");
        email = input.next();
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
}