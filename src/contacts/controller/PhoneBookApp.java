package contacts.controller;

import contacts.model.*;
import contacts.view.InputOutput;

import java.util.List;

public class PhoneBookApp {
    private final InputOutput io;
    private final PhoneBook phoneBook;
    private boolean isRunning;

    // Constants for prompts and messages
    private static final String MENU_PROMPT = "[menu] Enter action (add, list, search, count, exit):";
    private static final String CONTACT_TYPE_PROMPT = "Enter the type (person, organization):";
    private static final String NAME_PROMPT = "Enter the name:";
    private static final String SURNAME_PROMPT = "Enter the surname:";
    private static final String NUMBER_PROMPT = "Enter the number:";
    private static final String BIRTH_DATE_PROMPT = "Enter the birth date:";
    private static final String GENDER_PROMPT = "Enter the gender (M, F):";
    private static final String SELECT_RECORD_PROMPT = "Select a record:";
    private static final String RECORD_ADDED_MESSAGE = "The record added.";
    private static final String RECORD_UPDATED_MESSAGE = "The record updated!";
    private static final String RECORD_REMOVED_MESSAGE = "The record removed!";
    private static final String WRONG_NUMBER_FORMAT_MESSAGE = "Wrong number format!";
    private static final String NO_RECORDS_TO_REMOVE_MESSAGE = "No records to remove!";
    private static final String NO_RECORDS_TO_EDIT_MESSAGE = "No records to edit!";

    public PhoneBookApp(InputOutput io, PhoneBook phoneBook) {
        this.io = io;
        this.phoneBook = phoneBook;
        this.isRunning = true;
    }

    public void start() {
        while (isRunning) {
            String action = io.read(MENU_PROMPT).toLowerCase();
            processAction(action);
            io.write(""); // For spacing
        }
    }

    private void processAction(String action) {
        switch (action) {
            case "add":
                addContact();
                break;
            case "list":
                listContacts();
                break;
            case "search":
                searchContacts();
                break;
            case "count":
                countContacts();
                break;
            case "exit":
                exitApp();
                break;
            default:
                io.write("Unknown action! Please try again.");
        }
    }

    private void addContact() {
        String type = io.read(CONTACT_TYPE_PROMPT).toLowerCase();
        Contact contact = null;

        switch (type) {
            case "person":
                contact = createPersonContact();
                break;
            case "organization":
                contact = createOrganizationContact();
                break;
            default:
                io.write("Unknown contact type! Contact not added.");
                return;
        }

        if (!contact.hasValidNumber()) {
            io.write(WRONG_NUMBER_FORMAT_MESSAGE);
        }

        phoneBook.addContact(contact);
        io.write(RECORD_ADDED_MESSAGE);
    }

    private PersonContact createPersonContact() {
        String name = io.read(NAME_PROMPT);
        String surname = io.read(SURNAME_PROMPT);
        String birthDate = io.read(BIRTH_DATE_PROMPT);
        String gender = io.read(GENDER_PROMPT);
        String number = io.read(NUMBER_PROMPT);
        return new PersonContact(number, name, surname, birthDate, gender);
    }

    private OrganizationContact createOrganizationContact() {
        String name = io.read("Enter the organization name:");
        String address = io.read("Enter the address:");
        String number = io.read(NUMBER_PROMPT);
        return new OrganizationContact(number, name, address);
    }

    private void listContacts() {
        List<Contact> contacts = phoneBook.getAllContacts();

        if (contacts.isEmpty()) {
            io.write("No records to list!");
            return;
        }

        displayContacts(contacts);
        handleRecordAction();
    }

    private void searchContacts() {
        String query = io.read("Enter search query:");
        List<Contact> results = phoneBook.searchContacts(query);

        io.write("Found " + results.size() + " result(s):");
        displayContacts(results);
        handleRecordAction();
    }

    private void displayContacts(List<Contact> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            String displayName = contact.getFieldValue("name");
            String displaySurname = contact.getEditableFields().contains("surname") ?
                    " " + contact.getFieldValue("surname") : "";
            io.write((i + 1) + ". " + displayName + displaySurname);
        }
    }

    private void handleRecordAction() {
        String input = io.read("\n[list] Enter action ([number], back):").toLowerCase();

        if (input.equals("back")) {
            return;
        }

        try {
            int index = Integer.parseInt(input) - 1;
            Contact contact = phoneBook.getContact(index);

            if (contact == null) {
                io.write("Invalid record number!");
                return;
            }

            io.write(contact.toString());
            String action = io.read("\n[record] Enter action (edit, delete, menu):").toLowerCase();

            switch (action) {
                case "edit":
                    editContact(contact, index);
                    break;
                case "delete":
                    deleteContact(index);
                    break;
                case "menu":
                    // Return to main menu
                    break;
                default:
                    io.write("Unknown action! Returning to main menu.");
            }
        } catch (NumberFormatException e) {
            io.write("Invalid input! Returning to main menu.");
        }
    }

    private void editContact(Contact contact, int index) {
        List<String> fields = contact.getEditableFields();
        String fieldPrompt = String.join(", ", fields);
        String fieldToEdit = io.read("Select a field (" + fieldPrompt + "):").toLowerCase();
        String newValue = io.read("Enter " + fieldToEdit + ":");

        if (contact.updateField(fieldToEdit, newValue)) {
            io.write("Saved");
            phoneBook.updateContact(contact, index);
            io.write(RECORD_UPDATED_MESSAGE);
        } else {
            io.write("Invalid field! No changes made.");
        }
    }

    private void deleteContact(int index) {
        if (phoneBook.getContactCount() == 0) {
            io.write(NO_RECORDS_TO_REMOVE_MESSAGE);
            return;
        }

        phoneBook.removeContact(index);
        io.write(RECORD_REMOVED_MESSAGE);
    }

    private void countContacts() {
        int count = phoneBook.getContactCount();
        io.write("The Phone Book has " + count + " records.");
    }

    private void exitApp() {
        isRunning = false;
    }
}
