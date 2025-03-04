package minesweeper.output;

import minesweeper.model.Board;

public class Print {

    public static void board(Board board) {
        System.out.print(board.boardToString());
    }
}
