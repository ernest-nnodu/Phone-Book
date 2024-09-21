package contacts;


import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Contact> contacts;

    public PhoneBook() {
        contacts = new ArrayList<>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public Contact getContact(int id) {
        return contacts.get(id);
    }

    public void addContact(Contact contact) {
        contact.setId(contacts.size() + 1);
        contacts.add(contact);
    }

    public void updateContact(Contact contact) {
        contacts.set(contact.getId(), contact);
    }

    public void removeContact(int id) {
        contacts.remove(id - 1);
    }

    public String phoneBookSize() {
        return "The Phone Book has " + contacts.size() + " records.";
    }
}