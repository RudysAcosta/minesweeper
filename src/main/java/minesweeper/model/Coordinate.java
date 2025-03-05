package minesweeper.model;

public class Coordinate {

    private int x;

    private int y;

    public Coordinate(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("The coordinates must be valid integer numbers.");
        }

        this.x = x;
        this.y = y;
    }

    public Coordinate(String coordinateString) {
        if (coordinateString == null || !coordinateString.contains("-")) {
            throw new IllegalArgumentException("Invalid format. It must be 'x-y'.");
        }

        String[] coordinates = coordinateString.split("-");

        if (coordinates.length != 2) {
            throw new IllegalArgumentException("Invalid format. It must be 'x-y'.");
        }

        try {
            this.x = Integer.parseInt(coordinates[0].trim());
            this.y = Integer.parseInt(coordinates[1].trim());
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

}
