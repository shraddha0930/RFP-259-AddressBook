package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookMain {

    public static final int ADD = 1;
    public static final int EDIT = 2;
    public static final int DISPLAY = 3;
    public static final int DELETE = 4;
    private static final int SEARCH = 5;
    private static final int SORT = 6;
    private static final int EXIT = 7;

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        //ArrayList<AddressBook> book = new ArrayList<>();
        HashMap<String, AddressBook> dictionary = new HashMap<>();
        Scanner input = new Scanner(System.in);
        int option = 0;
        while (option != 7) {
            System.out.println("Options are : ");
            System.out.print("1.Add\t");
            System.out.print("2.Edit\t");
            System.out.print("3.Display\t");
            System.out.print("4.Delete\t");
            System.out.print("5.Search\t");
            System.out.print("6.Sort\t");
            System.out.print("7.Exit\n");
            System.out.print("Enter an option from above :- ");
            option = input.nextInt();
            //AddressBook addressBook = new AddressBook();


            switch (option) {

                case ADD:
                    System.out.println("Enter the number of Address book you want to create : ");
                    int numberOfAddressbook = input.nextInt();
                    AddressBook addressBook1 = new AddressBook();
                    for (int i = 0; i < numberOfAddressbook; i++) {
                        System.out.println("Enter a address book name");
                        String bookName = input.next();
                        if (dictionary.containsKey(bookName)) {
                            addressBook1 = dictionary.get(bookName);
                        } else {
                            dictionary.put(bookName, addressBook1);
                            addressBook1.getContact();

                        }
                        System.out.println(dictionary);
                    }


//                    book.add(addressBook);
//                    System.out.println(book);
                    break;
                case EDIT:
                    System.out.println("Enter a  address book name");
//                    System.out.println("Enter a name");
                    String name = input.next();
                    AddressBook addressBook = dictionary.get(name);
//                    if (name.equals(AddressBook.person.getFirstName())) {
                    addressBook.editPersonDetails();
//                    System.out.println(book);
                    System.out.println(dictionary);
                    // } else System.out.println("Contact not found");
                    break;
                case DISPLAY:
                    System.out.println("Enter a  address book name");
//                    for (AddressBook contact : book)
//                        System.out.println(contact);
                    String name4 = input.next();
                    if (dictionary.containsKey(name4)) {
                        System.out.println("Displaying Contact : ");
                        for (Map.Entry m : dictionary.entrySet()) {
                            //iterating hashmap
                            System.out.println(m.getKey() + " " + m.getValue());
                        }
                    } else
                        System.out.println("Address Book does not exist");

                    break;
                case DELETE:
                    System.out.println("Enter a address book name");
                    String name1 = input.next();
                    AddressBook addressBook2 = dictionary.get(name1);

//                    for (int i = 0; i <= book.size(); i++) {
//                        if (name1.equals(AddressBook.person.getFirstName())) {
//                            book.remove(i);
//                        }
//                        System.out.println(book);
//                    }
                    addressBook2.deleteContact();
                    break;
                case SEARCH:
                    System.out.println("Details search by \n1. State  Name \n2. City Name");
                    int choice = input.nextInt();
                    System.out.println("Enter a address book name");
                    String bookName2 = input.next();
                    AddressBook addressBook3 = dictionary.get(bookName2);
                    switch (choice) {
                        case 1:
                            if (dictionary.containsKey(bookName2)) {
                                addressBook3.searchState();

                            } else {
                                System.out.println("Address Book does not exist");
                            }
                            break;
                        case 2:
                            if (dictionary.containsKey(bookName2)) {
                                addressBook3.searchCity();
                            } else {
                                System.out.println("Address Book does not exist");
                            }
                            break;
                    }
                    break;
                case SORT:
                    System.out.println("Enter a address book name");
                    String name3 = input.next();
                    AddressBook addressBook4 = dictionary.get(name3);
                    // addressBook4.sortByNames();
                    if (dictionary.containsKey(name3)) {
                        addressBook4.sort();
                    } else {
                        System.out.println("Address Book does not exist");
                    }
                    break;
                case EXIT:
                    System.out.println("Exiting from book");
                    break;
            }
        }

        // writeCSV

        String csvPath = "E:\\AddressBookTest\\src\\main\\java\\org\\example\\addressbook.csv";

        FileWriter fileWriter = null;


        try {
            fileWriter = new FileWriter(csvPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CSVWriter writer = new CSVWriter(fileWriter);

        String[] header = {"FirstName","LastName","Email","Address","City","State","Zipcode","PhoneNumber"};
        writer.writeNext(header);

        List<String[]> csvLines = new ArrayList<String[]>();
        dictionary.keySet().stream().forEach(bookName -> dictionary.get(bookName).getPersons()
                .stream().forEach(person -> csvLines.add(person.getContactStrings())));


        writer.writeAll(csvLines);

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Reading CSV

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(csvPath);
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        CSVReader reader = new CSVReaderBuilder(fileReader).build();

        List<String[]> linesOfData = null;

        try {
            linesOfData = reader.readAll();
        } catch (IOException | CsvException e) {

            e.printStackTrace();
        }

        System.out.println("\nReading data from csv file:");
        linesOfData.stream().forEach(csvs -> {
            for (String value : csvs)
                System.out.print(value + "\t");
            System.out.println();
        });

        try {
            reader.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

}