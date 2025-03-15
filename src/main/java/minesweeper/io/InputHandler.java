package minesweeper.io;

import minesweeper.model.Action;
import minesweeper.model.Coordinate;

import java.security.InvalidParameterException;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

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

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(line);
                if (number >= 1) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
                System.out.print(ignored.getMessage());
            }
            System.out.print("\nTry again with a number: ");
        }

        throw new IllegalStateException("No input available");
    }

    public Coordinate getCoordinate() {
        System.out.print("Set/unset mines marks or claim a cell as free: ");

        while (true) {
            String line = scanner.nextLine().trim();

            try {
                String[] coordinate = line.split(" ");

                // We less 1 become we work with index 0
                int x = Integer.parseInt(coordinate[0]) - 1;
                int y = Integer.parseInt(coordinate[1]) - 1;

                return new Coordinate(x, y);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter valid coordinates (x-y).");
            }
        }
    }

    public Action input() {
        System.out.print("Set/unset mines marks or claim a cell as free: ");

        while(true) {
            String[] input = scanner.nextLine().trim().split(" ");

            if (input.length != 3) {
                System.out.println("Something error try again.");
                continue;
            }

            if (!Objects.equals(input[2], "free") && !Objects.equals(input[2], "mine")) {
                System.out.println("Something error try again.");
                continue;
            }

            try {
                int x = Integer.parseInt(input[0]) - 1;
                int y = Integer.parseInt(input[1]) - 1;

                if (!Coordinate.validateCoordinate(x, y)) {
                    System.out.println("Something error try again.");
                    continue;
                }

                return new Action(input[2], new Coordinate(x, y));
            } catch (NumberFormatException e) {
                System.out.println("Something error try again.");
            }
        }
    }


}
