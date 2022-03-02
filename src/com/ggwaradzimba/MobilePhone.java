package com.ggwaradzimba;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contacts;

    public MobilePhone() {
        this.contacts = new ArrayList<Contact>();
    }

    public MobilePhone(String mobileNumber) {
        this.contacts = new ArrayList<Contact>();
    }
    
    public boolean addContact(Contact contact) {
        int returnedIndex = findContact(contact.getName());
        if(returnedIndex >= 0) {
            // contact already exists
            return false;
        } else {
            this.contacts.add(contact);
            //int t = contacts.size();
            return true;

        }
    }
    
    private int findContact(Contact contact) {
        return this.contacts.indexOf(contact);
    }

    private int findContact(String name) {
        for(int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            if(contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public boolean deleteContact(String name) {
        int returnedIndex = findContact(name);
        if(returnedIndex >= 0) {
            this.contacts.remove(returnedIndex);
            return true;
        }
        //contact does not exist
        return false;
    }

    public boolean deleteContact(Contact contact) {
        int returnedIndex = findContact(contact.getName());
        if(returnedIndex >= 0) {
            this.contacts.remove(returnedIndex);
            return true;
        }
        //contact does not exist
        return false;
    }

    public boolean modifyContact(Contact oldContact, Contact newContact) {
        int returnedIndex = findContact(oldContact.getName());
        if(returnedIndex >= 0) {
            this.contacts.set(returnedIndex, newContact);
            return true;
        }
        // contact to be modified does not exist
        return false;
    }

    public boolean modifyContact(String oldName, Contact newContact) {
        int returnedIndex = findContact(oldName);
        if(returnedIndex >= 0) {
            this.contacts.set(returnedIndex, newContact);
            return true;
        }
        // contact to be modified does not exist
        return false;
    }

    public Contact searchContact(String name) {
        int returnedIndex = findContact(name);
        if(returnedIndex >= 0) {
            return this.contacts.get(returnedIndex);
        }
        // contact to be modified does not exist
        return null;
    }

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public void displayContact() {
        System.out.println();
        System.out.println("Contacts in Phone");
        System.out.println("-------------------");
        for(int i = 0; i < this.contacts.size(); i++) {
            System.out.println(i+1 + ". \t" + this.contacts.get(i).getName() +
                    " \t" + this.contacts.get(i).getPhoneNumber());
        }
    }

    public void displayContact(Contact contact) {
        System.out.println("Contact Details");
        System.out.println("-------------------");
        System.out.println(contact.getName() +
                " " + contact.getPhoneNumber());
    }
}
