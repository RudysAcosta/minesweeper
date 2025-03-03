package minesweeper;

import minesweeper.model.Board;
import minesweeper.output.Print;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Print.board(board);
    }
}