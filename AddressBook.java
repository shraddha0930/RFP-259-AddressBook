import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();
    static Contact person = new Contact();
    Scanner input = new Scanner(System.in);


    public void getContact() {
        System.out.println("Enter details : ");
        person.getPersonDetails();
        contacts.add(person);
    }

    public void editPersonDetails() {
        System.out.println("Enter the option to edit");
        String name = input.next();
        for (Contact person : contacts) {
            if (person.getFirstName().equals(name)) {
                System.out.println("Enter the option to edit");
                System.out.println("1.Firstname\t 2.Lastname\t 3.Address\t 4.City\t 5.State\t 6.Zipcode\t 7.Phone number\t 8.Email\t 9.Exit");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Changing First name : ");
                        person.setFirstName(input.next());
                        break;
                    case 2:
                        System.out.println("Changing last name : ");
                        person.setLastName(input.next());
                        break;
                    case 3:
                        System.out.println("Changing address : ");
                        person.setAddress(input.next());
                        break;
                    case 4:
                        System.out.println("Changing city : ");
                        person.setCity(input.next());
                        break;
                    case 5:
                        System.out.println("Changing state : ");
                        person.setState(input.next());
                        break;
                    case 6:
                        System.out.println("Changing zipcode : ");
                        person.setZipcode(input.nextInt());
                        break;
                    case 7:
                        System.out.println("Changing phone number: ");
                        person.setPhoneNumber(input.nextInt());
                        break;
                    case 8:
                        System.out.println("Changing email : ");
                        person.setEmail(input.next());
                        break;
                    case 9:
                        System.out.println("Exiting from edit operation");
                        break;
                }
            }
        }
    }

    public void deleteContact() {
        System.out.println(contacts);
        System.out.println("Enter name to delete : ");
        String name = input.next();
        for (Contact person : contacts) {
            if (person.getFirstName().equals(name)) {
                contacts.remove(person);
            }
        }
    }

    public void displayContact(){
        for (Contact contact:contacts) {
            System.out.println(contact);
        }
    }
    @Override
    public String toString() {
        return "AddressBook{" +
                "person=" + person +
                '}';
    }
}