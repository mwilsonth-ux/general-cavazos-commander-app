
package com.cavazos;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals("q")) {
            System.out.println("--------------------------------");
            System.out.println("General Cavazos Commander App");
            System.out.println("--------------------------------");
            System.out.println("i - Issue a command");
            System.out.println("l - List all commands");
            System.out.println("u - Undo last command");
            System.out.println("r - Redo last command");
            System.out.println("q - Quit");
            System.out.println("--------------------------------");
            System.out.print("Enter a command: ");

            command = scanner.nextLine().trim().toLowerCase();

            if (command.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("You selected: " + command);
            }
        }

        scanner.close();
    }
}
