package minesweeper.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Coordinate {

    private int x;

    private int y;

    public Coordinate(int x, int y) {
        if (x < 0 || x >= Field.length || y < 0 || y >= Field.length) {
            throw new IllegalArgumentException("The coordinates must be valid integer numbers.");
        }

        this.x = x;
        this.y = y;
    }

    public Coordinate(String coordinateString) {
        this(parseCoordinate(coordinateString)[0], parseCoordinate(coordinateString)[1]);
    }

    private static int[] parseCoordinate(String coordinateString) {
        if (coordinateString == null || !coordinateString.contains("-")) {
            throw new IllegalArgumentException("Invalid format. It must be 'x-y'.");
        }

        String[] coordinates = coordinateString.split("-");
        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Invalid format. It must be 'x-y'.");
        }

        try {
            int x = Integer.parseInt(coordinates[0].trim());
            int y = Integer.parseInt(coordinates[1].trim());
            return new int[]{x, y};
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("The coordinates must be valid integer numbers.");
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Set<Coordinate> getNeighbors() {
        Set<Coordinate> neighbors = new HashSet<>();

        int x = getX();
        int y = getY();

        int[][] directions = {
                {1, 0},  {-1, 0},
                {0, 1},  {0, -1},
                {1, 1},  {-1, -1},
                {1, -1}, {-1, 1}
        };

        for (int[] dir : directions) {
            int newX = x + dir[0];
            int newY = y + dir[1];

            if (newX < 0 || newX == Field.length) continue;
            if (newY < 0 || newY == Field.length) continue;

            neighbors.add(new Coordinate(newX, newY));
        }

        return neighbors;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coordinate that  = (Coordinate) obj;
        return this.x == that.getX() && this.y == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "("+ x + "," + y + ")";
    }

}
