package minesweeper;

import minesweeper.io.InputHandler;
import minesweeper.model.Board;
import minesweeper.output.Print;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        InputHandler inputHandler = new InputHandler();

        int countMines = inputHandler.get("How many mines do you want on the field?");
        board.setCountMines(countMines);

        Print.board(board);
    }
}