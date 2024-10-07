# PhoneBook Application

## Overview

The **PhoneBook Application** is a simple console-based phone book management system that allows users to add, edit, search, and delete contacts. Contacts can be either individuals or organizations. The system supports storing personal information like name, surname, birth date, and gender for individuals, as well as organization-specific details like address and phone numbers.

## Features

- **Add Contacts:** Add both person and organization contacts.
- **List Contacts:** View all saved contacts in the phone book.
- **Search Contacts:** Search contacts by name, surname, or phone number.
- **Edit Contacts:** Modify contact details such as name, surname, birth date, address, etc.
- **Delete Contacts:** Remove contacts from the phone book.
- **Count Contacts:** Display the total number of records in the phone book.

## Project Structure

```plaintext
├── contacts/
│   ├── Contact.java            # Base class for storing contact details
│   ├── PersonContact.java      # Class for storing individual contact details
│   ├── OrganizationContact.java# Class for storing organization details
│   ├── PhoneBook.java          # Manages a list of contacts
│   ├── PhoneBookApp.java       # Main application class to interact with the user
│   ├── Console.java            # Utility class for user input
│   └── Main.java               # Entry point for running the application
```

## How to Run the Application

### Clone the repository:

```bash
git clone https://github.com/your-username/phonebook-app.git
cd phonebook-app
```

### Compile and run the project:
Ensure you have Java installed, then compile and run the application using the following commands:

```bash
javac contacts/Main.java
java contacts.Main
```

### Follow the on-screen prompts to interact with the phone book. You can:
- Add a person or organization by choosing ```add```.
- ```List```, ```search```, and ```edit``` contacts via intuitive prompts.
- Use ```count``` to see the total number of contacts.
- Use ```exit``` to close the app.

## Sample Usage
Here’s a sample interaction:

```[menu] Enter action (add, list, search, count, exit): add
Enter the type (person, organization): person
Enter the name: John
Enter the surname: Doe
Enter the birth date: 1990-05-10
Enter the gender (M, F): M
Enter the number: +123456789
The record added.

[menu] Enter action (add, list, search, count, exit): list
1. John Doe
[list] Enter action ([number], back): 1
Name: John
Surname: Doe
Birth date: 1990-05-10
Gender: M
Number: +123456789
Time created: 2024-10-07T12:34:56
Time last edit: 2024-10-07T12:34:56
```

## Technologies Used
- **Java:** The application is written in pure Java and follows object-oriented principles.
- **Console I/O:** The application uses a simple console interface for user input and output.

## Possible Enhancements
- **Persistent Storage:** Currently, contacts are stored in memory. Adding file-based or database storage would allow saving contacts between sessions.
- **User Interface:** Building a graphical user interface (GUI) or a web-based front-end would improve user interaction.
- **Validation:** Improve input validation, especially for phone numbers and birth dates.
