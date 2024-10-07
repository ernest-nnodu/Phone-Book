package contacts.view;

import java.util.Scanner;

public class ConsoleView implements InputOutput {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String read(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    @Override
    public void write(String message) {
        System.out.println(message);
    }
}
