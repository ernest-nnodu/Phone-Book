package contacts;


import java.time.LocalDateTime;
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

    public List<Contact> getContacts(String query) {
        List<Contact> contactList = new ArrayList<>();
        String searchQuery = ".*" + query.toLowerCase() + ".*";

        for (Contact contact : contacts) {
            List<String> fields = contact.getFields();
            for (String field : fields) {
                String fieldValue = contact.getFieldValue(field);
                if (fieldValue.toLowerCase().matches(searchQuery)){
                    contactList.add(contact);
                }
            }
        }
        return contactList;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void updateContact(Contact contact, int id) {
        contact.setTimeLastEdited(LocalDateTime.now());
        contacts.set(id - 1, contact);
    }

    public void removeContact(int id) {
        contacts.remove(id - 1);
    }

    public String phoneBookSize() {
        return "The Phone Book has " + contacts.size() + " records.";
    }
}