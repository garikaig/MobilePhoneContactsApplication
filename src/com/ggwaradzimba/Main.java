package com.ggwaradzimba;

// Simple program to create, update, delete, search and display phone contacts

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {
        mobilePhoneStart();
        mainMenu();
    }

    private static void mobilePhoneStart() {
        //placeholder for proper code in future
        System.out.println("Mobile phone booting.... please wait...");
    }

    private static void mobilePhoneShutdown() {
        // placeholder for proper code in future
        System.out.println("Mobile phone shutting down...");
    }
    private static void mainMenu() {

        boolean menuQuit = false;

        while(!menuQuit){
            printMenuOptions();
            System.out.print("Please enter choice to perform: ");
            int menuChoice = scanner.nextInt();
            switch(menuChoice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    modifyContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    findContact();
                    break;
                case 5:
                    mobilePhone.displayContact();
                    break;
                case 6:
                    mainMenu();
                    break;
                case 7:
                    menuQuit = true;
                    mobilePhoneShutdown();
                    break;
                default:
                    break;
            }
        }
    }

    private static void printMenuOptions() {
        System.out.println();
        System.out.println("\t 1 - Add Contact");
        System.out.println("\t 2 - Modify Contact");
        System.out.println("\t 3 - Remove Contact");
        System.out.println("\t 4 - Search Contact");
        System.out.println("\t 5 - Display Contacts");
        System.out.println("\t 6 - Display Main Menu");
        System.out.println("\t 7 - Quit");
    }

    private static void addContact() {
        System.out.print("Enter name of contact: ");
        scanner.nextLine();
        String contactName = scanner.nextLine();
        System.out.print("Enter phone number: ");
        //scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        //Contact contact = Contact.createContact(contactName,phoneNumber);
        Contact contact = new Contact(contactName,phoneNumber);
        boolean contactAdded = mobilePhone.addContact(contact);
        if(contactAdded) {
            System.out.println("Contact successfully added");
        } else {
            System.out.println("Contact could not be added");
        }
    }

    private static void modifyContact() {
        mobilePhone.displayContact();
        System.out.println();
        System.out.print("Please select contact to modify: ");
        int selectedContact = scanner.nextInt();
        Contact oldContact = mobilePhone.getContacts().get(selectedContact - 1);
        System.out.print("Enter new name for contact: ");
        scanner.nextLine();
        String newName = scanner.nextLine();
        System.out.print("Enter new phone for contact: ");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = new Contact(newName,newPhoneNumber);
        boolean contactModified = mobilePhone.modifyContact(oldContact,newContact);
        if(contactModified) {
            System.out.println("Contact successfully modified");
        } else {
            System.out.println("Contact was not modified");
        }
    }

    private static void removeContact() {
        mobilePhone.displayContact();
        System.out.println();
        System.out.print("Please select contact to remove: ");
        int selectedContact = scanner.nextInt();
        Contact contactToDelete = mobilePhone.getContacts().get(selectedContact - 1);
        boolean contactDeleted = mobilePhone.deleteContact(contactToDelete);
        if(contactDeleted) {
            System.out.println("Contact successfully deleted");
        } else {
            System.out.println("Deletion of contact not successful");
        }
    }

    private static void findContact() {
        scanner.nextLine();
        System.out.print("Enter name of contact to search: ");
        String searchedName = scanner.nextLine();
        Contact foundContact = mobilePhone.searchContact(searchedName);
        if(foundContact != null) {
            mobilePhone.displayContact(foundContact);
        } else {
            System.out.println("Contact searched does not exist");
        }
    }
}
