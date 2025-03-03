package minesweeper.model;

public class Board {

    private char[][] board;

    private final int lenght = 9;

    private int countMines;

    public Board() {
        board = new char[lenght][lenght];
        fillDefault();
    }

    public int getSize() {
        return lenght;
    }

    public void setCountMines(int countMines) {
        this.countMines = countMines;
        randomMines();
    }

    public char[][] getBoard() {
        return board;
    }

    private void fillDefault() {
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {
                board[i][j] = '.';
            }
        }
    }

    private void randomMines() {
        for (int i = 0; i < countMines;) {
            int pos1 = getRandom();
            int pos2 = getRandom();

            if (board[pos1][pos2] == '.') {
                board[pos1][pos2] = 'X';
                i++;
            }
        }
    }

    private int getRandom() {
        return (int) (Math.random() * lenght);
    }

}
