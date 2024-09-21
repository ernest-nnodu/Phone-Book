package contacts;


import java.util.Scanner;

public class Console {

    private final Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public String read(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}