package Ex2;

import java.util.List;
import java.util.ArrayList;

class ContactsImp implements ContactsInterface{
    protected List<Contact> contacts;
    protected ContactsStorageInterface storage;

    public ContactsImp() {
        this.contacts = new ArrayList<Contact>();
    }

    @Override
    public void openAndLoad(ContactsStorageInterface store) {
        this.storage = store;
        this.contacts.addAll(storage.loadContacts());

        System.out.println("Contacts found:\n");

        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    @Override
    public void saveAndClose() {
        boolean stored = storage.saveContacts(contacts);

        if (stored == true) {
            System.out.println("Contact is in Storage");
        } else {
            System.out.println("Contact is not in Storage");
        }
    }

    @Override
    public void saveAndClose(ContactsStorageInterface store) {
        boolean stored = store.saveContacts(this.contacts);

        if (stored == true) {
            System.out.println("Contact is in Storage");
        } else {
            System.out.println("Contact is not in Storage");
        }
    }

    @Override
    public boolean exist(Contact contact) {
        for (Contact c : this.contacts)
            if (c.toString().equals(contact.toString()))
                return true;
        return false;
    }

    @Override
    public Contact getByName(String name) {
        for (Contact c : this.contacts)
            if (c.getName().equals(name))
                return c;
        System.out.println("No such Contact");
        return null;
    }

    @Override
    public boolean add(Contact contact){
        return contacts.add(contact);
    }

    @Override
    public boolean remove(Contact contact){
        return contacts.remove(contact);
    }


}
