package minesweeper.model;

import java.util.HashSet;
import java.util.Set;

import com.google.common.annotations.VisibleForTesting;

public class Board {

    private char[][] board;

    private final int lenght = 10;

    private int countMines;

    public Board() {
        board = new char[lenght][lenght];
        fillDefault();
    }

    public void fill() {
        randomMines();
//        getNearbyMines();
    }

    public int getSize() {
        return lenght;
    }

    public void setCountMines(int countMines) {
        this.countMines = countMines;
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

    /**
     * This method places a mine at a given position and is primarily intended for testing.
     *
     * @param pos
     */
    @VisibleForTesting
    public void setMine(int[] pos) {
        int x = pos[1];
        int y = pos[0];

        if (x < 0 || x >= lenght || y < 0 || y >= lenght ) {
            throw new IllegalArgumentException("The position is not in the range 0 to " + lenght);
        }

        board[x][y] = 'X';
    }

    private void getNearbyMines() {
        for (int i = 0; i < lenght; i++) {
            for (int j = 0; j < lenght; j++) {

                System.out.printf("{%d, %d} => ",i, j);
                System.out.println(getNeighbors(new int[]{j, i}));

            }
        }
    }

    /**
     *  Get de number of mines near of a position
     *
     * @param pos
     * @return int
     */
    public int getCountMinesNearbyPos(int[] pos) {
        int count = 0;

        for (String neighbor : getNeighbors(pos) ) {
            int[] neighborPos = parsePosition(neighbor);

            int x = neighborPos[0];
            int y = neighborPos[1];

            if (board[x][y] == 'X') {
                count++;
            }
        }

        return count;
    }

    private int[] parsePosition(String posString) {
        String[] parts = posString.split("-");
        if (parts.length != 2) {
            throw new IllegalArgumentException("invalidate format: 'num-num'");
        }

        int[] newPos = new int[2];
        for (int i = 0; i < 2; i++) {
            newPos[i] = Integer.parseInt(parts[i]);
        }

        return newPos;
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



    public Set<String> getNeighbors(int[] pos) {

        Set<String> neighbors = new HashSet<>();

        int x = pos[0];
        int y = pos[1];

        int[][] directions = {
                {1, 0},  {-1, 0},
                {0, 1},  {0, -1},
                {1, 1},  {-1, -1},
                {1, -1}, {-1, 1}
        };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX < 0 || newX == lenght) continue;
            if (newY < 0 || newY == lenght) continue;

            neighbors.add(newX+"-"+newY);

        }

        return neighbors;
    }

}
