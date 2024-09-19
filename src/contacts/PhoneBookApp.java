package contacts;


import java.util.Scanner;

public class PhoneBookApp {

    private Contact contact;

    public void start() {
        contact = new Contact();
        readContactDetails();
        displayContactCreatedMessage();
    }

    private void displayContactCreatedMessage() {

        System.out.println("A record created!");
        System.out.println("A Phone Book with a single record created");
    }

    private void readContactDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the person");
        contact.setName(scanner.nextLine());

        System.out.println("Enter the surname of the person");
        contact.setSurname(scanner.nextLine());

        System.out.println("Enter the number");
        contact.setPhoneNumber(scanner.nextLine());
    }


}
