package minesweeper.model;

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

}
