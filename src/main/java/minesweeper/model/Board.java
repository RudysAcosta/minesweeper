package minesweeper.model;

import java.util.HashSet;
import java.util.Set;

import com.google.common.annotations.VisibleForTesting;

public class Board {

    private char[][] board;

    private final int length = 9;

    private int countMines;

    public Board() {
        board = new char[length][length];
        fillDefault();
    }

    public void fill() {
        randomMines();
        setNearbyMines();
//        getNearbyMines();
    }

    public int getSize() {
        return length;
    }

    public void setCountMines(int countMines) {
        this.countMines = countMines;
    }

    public char[][] getBoard() {
        return board;
    }

    private void fillDefault() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
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

        if (x < 0 || x >= length || y < 0 || y >= length ) {
            throw new IllegalArgumentException("The position is not in the range 0 to " + length);
        }

        board[x][y] = 'X';
    }

    private void setNearbyMines() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int countMines = getCountMinesNearbyPos(new int[]{i, j});

                if (countMines > 0 && board[i][j] != 'X') {
                    board[i][j] = Character.forDigit(countMines, 10);
                }
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
        return (int) (Math.random() * length);
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

            if (newX < 0 || newX == length) continue;
            if (newY < 0 || newY == length) continue;

            neighbors.add(newX+"-"+newY);

        }

        return neighbors;
    }

    public String boardToString() {
        StringBuilder sb = new StringBuilder();

        sb.append(boardTop());
        for (int i = 0; i < length; i++) {
            sb.append((i + 1) + "|").append(new String(board[i])).append("|\n");
        }
        sb.append(boardBottom());

        return sb.toString().trim();
    }

    private String boardTop() {
        StringBuilder line = new StringBuilder("\u00A0|");

        for(int i = 1; i <= length; i++) {
            line.append(i);
        }
        line.append("|\n");
        line.append("-|---------|\n");

        return line.toString();
    }

    private String boardBottom() {
        return "-|---------|";
    }
}
