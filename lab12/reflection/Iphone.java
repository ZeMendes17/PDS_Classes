package lab12.reflection;

import java.util.List;
import java.util.ArrayList;

public class Iphone implements IPlugin {

    List<Contact> contacts;

    public Iphone() {
        this.contacts = new ArrayList<Contact>();
    }

    @Override
    public void showContacts() {
        System.out.println("IPHONE CONTACTS:");
        for (Contact contact : this.contacts) {
            System.out.println(contact);
        }
        System.out.println("\n");
    }

    @Override
    public void addContact(String name, String number) {
        name = name.toUpperCase();
        // separate number like 123456789 into 123-456-789
        String newNumber = "";
        for (int i = 0; i < number.length(); i++) {
            if (i % 3 == 0 && i != 0) {
                newNumber += "-";
            }
            newNumber += number.charAt(i);
        }
        this.contacts.add(new Contact(name, newNumber));
    }

    @Override
    public boolean removeContact(String number) {
        String newNumber = "";
        for (int i = 0; i < number.length(); i++) {
            if (i % 3 == 0 && i != 0) {
                newNumber += "-";
            }
            newNumber += number.charAt(i);
        }
        for (Contact contact : this.contacts) {
            if (contact.getNumber().equals(newNumber)) {
                this.contacts.remove(contact);
                return true;
            }
        }
        return false;
    }
}