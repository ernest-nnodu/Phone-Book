package contacts.model;

import java.util.List;

public interface PhoneBook {
    void addContact(Contact contact);
    void removeContact(int index);
    Contact getContact(int index);
    List<Contact> getAllContacts();
    List<Contact> searchContacts(String query);
    int getContactCount();
    void updateContact(Contact contact, int index);
}
