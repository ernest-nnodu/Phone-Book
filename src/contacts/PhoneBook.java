package contacts;


import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private final List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int id) {
        return contacts.get(id - 1);
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(Contact contact, int id) {
        contacts.set(id - 1, contact);
    }

    public void removeContact(int id) {
        contacts.remove(id - 1);
    }

    public String phoneBookSize() {
        return "The Phone Book has " + contacts.size() + " records.";
    }
}