
package com.cavazos;
import java.util.Scanner;
import java.util.Stack;
import java.util.Random;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
            Stack<String> history = new Stack<>();
            Stack<String> undone = new Stack<>();
            Random random = new Random();
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
            } else if (command.equals("l")) {
                String[] commands = CavazosExample.getCommandArray(
                JSONFile.readArray("commands.json")
                );
                CavazosExample.print(commands);
            } else if (command.equals("i")) {
                String[] commands = CavazosExample.getCommandArray(
                JSONFile.readArray("commands.json")
                );
                int randIndex = random.nextInt(commands.length);
                String issued = commands[randIndex];

                history.push(issued);
                undone.clear();

                System.out.println("Command issued: " + issued);
            } else if (command.equals("u")) {
                if (!history.empty()) {
                String last = history.pop();
                undone.push(last);
                System.out.println("Undone: " + last);
                } else {
    System.out.println("Nothing to undo.");
}
            } else if (command.equals("r")) {
                if (!undone.empty()) {
                String last = undone.pop();
                history.push(last);
                System.out.println("Redone: " + last);
                } else {
                System.out.println("Nothing to redo.");
                }
            } else {
                System.out.println("Invalid command. Try again.");
            }
        }

        scanner.close();
    }
}
