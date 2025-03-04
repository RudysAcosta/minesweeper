package minesweeper.output;

import minesweeper.model.Board;

public class Print {

    public static void board(Board board) {
        char[][] boardElement = board.getBoard();

        for (int i = 0; i < board.getSize(); i++) {
            System.out.println();
            for (int j = 0; j < board.getSize(); j++) {
                System.out.print(boardElement[i][j]);
            }
        }
    }
}
