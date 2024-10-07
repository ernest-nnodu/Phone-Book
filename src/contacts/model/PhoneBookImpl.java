package contacts.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookImpl implements PhoneBook {
    private final List<Contact> contacts;

    public PhoneBookImpl() {
        this.contacts = new ArrayList<>();
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    @Override
    public void removeContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        }
    }

    @Override
    public Contact getContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            return contacts.get(index);
        }
        return null;
    }

    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    @Override
    public List<Contact> searchContacts(String query) {
        List<Contact> result = new ArrayList<>();
        String lowerCaseQuery = query.toLowerCase();

        for (Contact contact : contacts) {
            for (String field : contact.getEditableFields()) {
                String value = contact.getFieldValue(field);
                if (value.toLowerCase().contains(lowerCaseQuery)) {
                    result.add(contact);
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public int getContactCount() {
        return contacts.size();
    }

    @Override
    public void updateContact(Contact contact, int index) {
        if (index >= 0 && index < contacts.size()) {
            contact.timeLastEdited = LocalDateTime.now();
            contacts.set(index, contact);
        }
    }
}
