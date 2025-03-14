package minesweeper;

import minesweeper.io.InputHandler;
import minesweeper.model.Action;
import minesweeper.model.Field;

import java.util.Scanner;

public class Minesweeper {

    private Field field = new Field();
    private InputHandler inputHandler;

    {
        inputHandler = new InputHandler(new Scanner(System.in));
    }

    public void start() {
        int countMines = inputHandler.get("How many mines do you want on the field?");

        try {
            field.setCountMines(countMines);
            field.setRandomMines();
            System.out.println(field.toString());

            while(!field.hasUserWon() && !field.hasUserLoss()) {
                playTurn();
                System.out.println();
                System.out.println(field.toString());
            }

            if (field.hasUserLoss()) {
                System.out.println("You stepped on a mine and failed!");
            }

            if (field.hasUserWon()) {
                System.out.println("Congratulations! You found all the mines!");
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    private void playTurn() {
        Action action = inputHandler.getAction();
        field.processAction(action);
    }

}
