package minesweeper.model;

import java.util.HashSet;
import java.util.Set;

public class Field {

    public final static int length = 9;

    private Set<Coordinate> mines;

    private int countMines;

    private char[][] field;

    {
        field = new char[length][length];
    }

    public Field() {
        fillDefault();
    }

    private void fillDefault() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                field[i][j] = '.';
            }
        }
    }

    public void setMine(Coordinate coordinate) {
        mines.add(coordinate);
    }

    public Set<Coordinate> getMines() {
        return this.mines;
    }

    public char[][] getField() {
        return this.field;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(boardTop());
        for (int i = 0; i < length; i++) {
            sb.append((i + 1) + "|")
                    .append(new String(field[i]))
                    .append("|\n");
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
