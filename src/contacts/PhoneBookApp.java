package contacts;


import java.util.List;

public class PhoneBookApp {

    private Console console;
    private PhoneBook phoneBook;
    private boolean runApp;
    private final String menuMessage = "[menu] Enter action (add, list, search, count, exit):";
    private final String contactTypePrompt = "Enter the type (person, organization):";
    private final String namePrompt = "Enter the name";
    private final String surnamePrompt = "Enter the surname";
    private final String numberPrompt = "Enter the number";
    private final String birthDatePrompt = "Enter the birth date:";
    private final String genderPrompt = "Enter the gender (M, F):";
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
            System.out.println();
        }
    }

    private void processUserAction(String userAction) {

        switch (userAction) {
            case "add":
                addContact();
                break;
            case "list":
                processListCommand();
                break;
            case "search":
                processSearchCommand();
                break;
            case "count":
                countContacts();
                break;
            case "exit":
                runApp = false;
        }
    }

    private void processSearchCommand() {
        String searchQuery = console.read("Enter search query:");
        List<Contact> contactList = phoneBook.getContacts(searchQuery);
        System.out.println("Found " + contactList.size() + " results:");
        displayContacts(contactList);
    }

    private void processListCommand() {
        displayContacts(phoneBook.getContacts());
        String userInput = console.read("\n[list] Enter action ([number], back):");
        if (userInput.equals("back")) {
            return;
        }
        processRecordCommand(Integer.parseInt(userInput));
    }

    private void listContacts() {
        List<Contact> contactList = phoneBook.getContacts();

        displayContacts(contactList);
    }

    private void displayContacts(List<Contact> contactList) {
        for (int index = 0; index < contactList.size(); index++) {
            Contact contact = contactList.get(index);
            List<String> fields = contact.getFields();
            System.out.print((index + 1) + ". " + contact.getFieldValue("name"));
            if (fields.contains("surname")) {
                System.out.println(" " + contact.getFieldValue("surname"));
            }
        }
    }

    private void processRecordCommand(int recordNumber) {
        Contact contact = phoneBook.getContact(recordNumber);
        List<String> fields = contact.getFields();
        displayRecord(contact);

        String userInput = console.read("\n[record] Enter action (edit, delete, menu):");

        switch (userInput) {
            case "edit":
                processEditCommand(contact, fields);
                break;
            case "delete":
                processDeleteCommand();
                break;
            case "menu":
        }
    }

    private void processDeleteCommand() {
        removeContact();
    }

    private void displayRecord(Contact contact) {
        System.out.println(contact.toString());
    }

    private void processEditCommand(Contact contact, List<String> fields) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Select a field (").append(fields.get(0));
        for (int index = 1; index < fields.size(); index++) {
            prompt.append(", ").append(fields.get(index));
        }
        prompt.append("):");
        String fieldToEdit = console.read(prompt.toString());
        String fieldValue = console.read("Enter " + fieldToEdit + ":");
        contact.setField(fieldToEdit, fieldValue);
        System.out.println("Saved");
        displayRecord(contact);
    }

    private void removeContact() {
        if (phoneBook.getContacts().isEmpty()) {
            System.out.println("No records to remove!");
            return;
        }
        
        listContacts();
        phoneBook.removeContact(getContactIndex());
        System.out.println(recordRemovedMessage);
    }

    private void editContact() {
        if (phoneBook.getContacts().isEmpty()) {
            System.out.println("No records to edit!");
            return;
        }

        listContacts();
        int contactIndex = getContactIndex();
        Contact contact = getContactDetails(contactIndex); //modify selected contact details

        phoneBook.updateContact(contact, contactIndex);
        if (contact.hasNumber()) {
            System.out.println(wrongNumberFormatMessage);
        }
        System.out.println(recordUpdatedMessage);
    }

    private Contact getContactDetails(int selectedContact) {
        Contact contact = phoneBook.getContact(selectedContact);
        
//        if (contact.isPerson()) {
//            return getPersonDetails(contact);
//        }
        return getOrganizationDetails(contact);
    }

    private Contact getOrganizationDetails(Contact contact) {

        String fieldToEdit = console.read("Select a field (address, number:");
        OrganizationContact organizationContact = (OrganizationContact) contact;

        switch (fieldToEdit) {
            case "address":
                String address = console.read("Enter address:");
                organizationContact.setAddress(address);
                break;
            case "number":
                String number = console.read("Enter number:");
                organizationContact.setPhoneNumber(number);
        }
        return organizationContact;
    }

    private Contact getPersonDetails(Contact contact) {
        String fieldToEdit;
        fieldToEdit = console.read("Select a field (name, surname, birth, gender, number:");
        PersonContact personContact = (PersonContact) contact;

        switch (fieldToEdit) {
            case "name":
                String name = console.read("Enter name:");
                personContact.setName(name);
                break;
            case "surname":
                String surname = console.read("Enter surname:");
                personContact.setName(surname);
                break;
            case "number":
                String number = console.read("Enter number:");
                personContact.setPhoneNumber(number);
                break;
            case "birth":
                String birthDate = console.read("Enter birth date:");
                personContact.setBirthDate(birthDate);
                break;
            case "gender":
                String gender = console.read("Enter gender:");
                personContact.setGender(gender);
        }
        return personContact;
    }

    private int getContactIndex() {
        return Integer.parseInt(console.read(selectRecordPrompt));
    }

    private void displayContactInfo() {
        listContacts();
        int contactIndex = Integer.parseInt(console.read("Enter index to show info:"));
        Contact contact = phoneBook.getContact(contactIndex);
        
        /*if (contact.isPerson()) {
            PersonContact personContact = (PersonContact) contact;
            System.out.println("Name: " + personContact.getName());
            System.out.println("Surname: " + personContact.getSurname());
            System.out.println("Birth date: " + personContact.getBirthDate());
            System.out.println("Gender: " + personContact.getGender());
            System.out.println("Number: " + personContact.getPhoneNumber());
            System.out.println("Time created: " + personContact.getTimeCreated());
            System.out.println("Time last edit: " + personContact.getTimeLastEdited());
        } else {
            OrganizationContact organizationContact = (OrganizationContact) contact;
            System.out.println("Organization name: " + organizationContact.getName());
            System.out.println("Address: " + organizationContact.getAddress());
            System.out.println("Number: " + organizationContact.getPhoneNumber());
            System.out.println("Time created: " + organizationContact.getTimeCreated());
            System.out.println("Time last edit: " + organizationContact.getTimeLastEdited());
        }*/
    }

    private void countContacts() {
        System.out.println(phoneBook.phoneBookSize());
    }

    private void addContact() {
        Console console = new Console();

        String contactType = console.read(contactTypePrompt);
        Contact contact = switch (contactType) {
            case "person" -> createPersonContact();
            case "organization" -> createOrganizationContact();
            default -> new Contact();
        };

        if (contact.hasNumber()) {
            System.out.println(wrongNumberFormatMessage);
        }
        phoneBook.addContact(contact);
        System.out.println(recordAddedMessage);
    }

    private Contact createOrganizationContact() {

        String name = console.read("Enter the organization name");
        String address = console.read("Enter the address");
        String number = console.read(numberPrompt);

        return new OrganizationContact(number, name, address);
    }

    private Contact createPersonContact() {
        String name = console.read(namePrompt);
        String surname = console.read(surnamePrompt);
        String birthDate = console.read(birthDatePrompt);

        if (birthDate.isEmpty()) {
            System.out.println("Bad birth date!");
            birthDate = "[no data]";
        }

        String gender = console.read(genderPrompt);
        if (gender.isEmpty()) {
            System.out.println("Bad gender!");
            gender = "[no data]";
        }
        String number = console.read(numberPrompt);

        return new PersonContact(number, name, surname, birthDate, gender);
    }

    private String readUserCommand() {
        return console.read(menuMessage);
    }

    private void displayContactCreatedMessage() {

        System.out.println("A record created!");
        System.out.println("A Phone Book with a single record created");
    }


}
