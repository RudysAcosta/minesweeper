package minesweeper.io;

import minesweeper.model.Coordinate;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public InputHandler() {
        this(new Scanner(System.in));
    }

    public int get(String prompt) {
        System.out.print(prompt);
        while (true) {
            if (!scanner.hasNextLine()) {
                throw new IllegalStateException("No input available");
            }

            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("\nTry again with a number: ");
            }
        }
    }

    public Coordinate getCoordinate() {
        System.out.print("Set/delete mines marks (x and y coordinates): ");

        while (true) {
            String line = scanner.nextLine().trim().replace(' ', '-');

            try {
                return new Coordinate(line);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter valid coordinates (x-y).");
            }
        }
    }

}
