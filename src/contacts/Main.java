package contacts;

import contacts.controller.PhoneBookApp;
import contacts.model.PhoneBookImpl;
import contacts.view.ConsoleView;
import contacts.view.InputOutput;

public class Main {
    public static void main(String[] args) {
        //new PhoneBookApp().start();

        InputOutput io = new ConsoleView();
        PhoneBookImpl phoneBook = new PhoneBookImpl();
        PhoneBookApp app = new PhoneBookApp(io, phoneBook);
        app.start();
    }
}