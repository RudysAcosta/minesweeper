package minesweeper;

import minesweeper.io.InputHandler;
import minesweeper.model.Field;

import java.util.Scanner;

public class Minesweeper {

    private Field field = new Field();
    private InputHandler inputHandler;

    {
        inputHandler = new InputHandler(new Scanner(System.in));
    }

    public Minesweeper() {

    }

    public void start() {
        int countMines = inputHandler.get("How many mines do you want on the field?");

        try {
            field.setCountMines(countMines);
            field.setRandomMines();
            System.out.println(field.toString());

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

}
