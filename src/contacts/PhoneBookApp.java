package contacts;


import java.util.List;

public class PhoneBookApp {

    private Console console;
    private PhoneBook phoneBook;
    private boolean runApp;
    private final String menuMessage = "Enter action (add, remove, edit, count, list, exit):";
    private final String namePrompt = "Enter the name";
    private final String surnamePrompt = "Enter the surname";
    private final String numberPrompt = "Enter the number";
    private final String selectRecordPrompt = "Select a record:";
    private final String selectFieldPrompt = "Select a field (name, surname, number):";
    private final String wrongNumberFormatMessage = "Wrong number format!";
    private final String recordAddedMessage = "The record added.";
    private final String recordUpdatedMessage = "The record updated!";
    private final String recordRemovedMessage = "The record removed!";

    public PhoneBookApp() {
        console = new Console();
        phoneBook = new PhoneBook();
        runApp = true;
    }

    public void start() {

        while (runApp) {
            String userAction = readUserCommand();
            processUserAction(userAction);
        }
    }

    private void processUserAction(String userAction) {

        switch (userAction) {
            case "add":
                addContact();
                break;
            case "remove":
                removeContact();
                break;
            case "edit":
                editContact();
                break;
            case "count":
                countContacts();
                break;
            case "list":
                listContacts();
                break;
            case "exit":
                runApp = false;
        }
    }

    private void removeContact() {
        if (phoneBook.getContacts().isEmpty()) {
            System.out.println("No records to remove!");
            return;
        }
        
        listContacts();
        phoneBook.removeContact(getContactId());
        System.out.println(recordRemovedMessage);
    }

    private void editContact() {
        if (phoneBook.getContacts().isEmpty()) {
            System.out.println("No records to edit!");
            return;
        }

        listContacts();
        int contactId = getContactId();
        Contact contact = getContactDetails(contactId); //modify selected contact details

        phoneBook.updateContact(contact, contactId);
        if (contact.hasNumber()) {
            System.out.println(wrongNumberFormatMessage);
        }
        System.out.println(recordUpdatedMessage);
    }

    private Contact getContactDetails(int selectedContact) {
        Contact contact = phoneBook.getContact(selectedContact);
        String fieldToEdit = console.read(selectFieldPrompt);

        switch (fieldToEdit) {
            case "name":
                String name = console.read("Enter name:");
                contact.setName(name);
                break;
            case "surname":
                String surname = console.read("Enter surname:");
                contact.setSurname(surname);
                break;
            case "number":
                String number = console.read("Enter number:");
                contact.setPhoneNumber(number);
        }
        return contact;
    }

    private int getContactId() {
        return Integer.parseInt(console.read(selectRecordPrompt));
    }

    private void listContacts() {
        List<Contact> contactList = phoneBook.getContacts();

        for (int index = 0; index < contactList.size(); index++) {
            Contact contact = contactList.get(index);
            System.out.println((index + 1) + ". " +
                    contact.getName() + " " + contact.getSurname() + ", " + contact.getPhoneNumber());
        }
    }

    private void countContacts() {
        System.out.println(phoneBook.phoneBookSize());
    }

    private void addContact() {
        String name = console.read(namePrompt);
        String surname = console.read(surnamePrompt);
        String number = console.read(numberPrompt);

        Contact contact = new Contact(name, surname, number);
        if (contact.hasNumber()) {
            System.out.println(wrongNumberFormatMessage);
        }
        phoneBook.addContact(contact);
        System.out.println(recordAddedMessage);
    }

    private String readUserCommand() {
        return console.read(menuMessage);
    }

    private void displayContactCreatedMessage() {

        System.out.println("A record created!");
        System.out.println("A Phone Book with a single record created");
    }


}
