package minesweeper.io;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public int get(String promp) {
        System.out.print(promp);

        int num;
        while (true) {
            String line = scanner.nextLine().trim();

            try {
                num = Integer.parseInt(line);
            } catch (Exception e) {
                System.out.print("\ntry again with number. ");
                continue;
            }

            break;
        }
        return num;
    }

}
