package minesweeper;

import minesweeper.io.InputHandler;
import minesweeper.model.Action;
import minesweeper.model.Coordinate;
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



            while(!field.hasUserWon()) {
                markMines();
//                System.out.println();
//                System.out.println(field.toString());
            }
//
//            System.out.println("Congratulations! You found all the mines!");

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }

    }

    private void markMines() {
        while (true) {
            Action action = inputHandler.input();
            System.out.println(action);
//            Coordinate coordinate = new Coordinate(action[0], action[1]);
//            int minesNearCoordinate = field.getCountMinesNearby(coordinate);
//
//            if (minesNearCoordinate > 0 && !field.isAMine(coordinate)) {
//                System.out.println("There is a number here!");
//                continue;
//            }
//            field.toggleMarkCell(coordinate);
//            break;
        }

    }

}
