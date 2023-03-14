import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    public static final int ADD = 1;
    public static final int EDIT = 2;
    public static final int DISPLAY = 3;
    public static final int DELETE = 4;
    public static final int EXIT = 5;


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        //    ArrayList<AddressBook> book = new ArrayList<>();
        HashMap<String, AddressBook> dictionary = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int option = 0;
        while (option != 5) {
            System.out.println("Options are : ");
            System.out.print("1.Add\t");
            System.out.print("2.Edit\t");
            System.out.print("3.Display\t");
            System.out.print("4.Delete\t");
            System.out.print("5.Exit\n");
            System.out.print("Enter an option from above :- ");
            option = input.nextInt();
            AddressBook addressBook = new AddressBook();


            switch (option) {

                case ADD:
                    AddressBook addressBook1 = new AddressBook();
                    System.out.println("Enter the number of contact you want ot add : ");
                    int numberOfContacts = input.nextInt();
                    for (int i = 0; i < numberOfContacts; i++) {
                        System.out.println("Enter a name");
                        String name = input.next();
                        if (dictionary.containsKey(name)) {
                            System.out.println(" Address book exist.");
                        } else {
                            dictionary.put(name,addressBook1);
                            addressBook1.getContact();
                            System.out.println(dictionary);
                        }
                    }
//                    book.add(addressBook);
//                    System.out.println(book);
                    break;
                case EDIT:

//                    System.out.println("Enter a name");
//                    String name = input.next();
//                    if (name.equals(AddressBook.person.getFirstName())) {
                    addressBook.editPersonDetails();
//                    System.out.println(book);
                    System.out.println(dictionary);
                    // } else System.out.println("Contact not found");
                    break;
                case DISPLAY:
                    System.out.println("Displaying Contact : ");
//                    for (AddressBook contact : book)
//                        System.out.println(contact);
                    for(Map.Entry m : dictionary.entrySet()){
                        //iterating hashmap
                        System.out.println(m.getKey()+" " +m.getValue());
                    }
                    break;
                case DELETE:
//                    System.out.println("Enter a name");
//                    String name1 = input.next();
//                    for (int i = 0; i <= book.size(); i++) {
//                        if (name1.equals(AddressBook.person.getFirstName())) {
//                            book.remove(i);
//                        }
//                        System.out.println(book);
//                    }
                    addressBook.deleteContact();
                    break;
                case EXIT:
                    System.out.println("Exiting from book");
                    break;

            }
        }


    }
}