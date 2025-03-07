package minesweeper.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {

    @Test
    void testMakeCoordinate() {
        Coordinate coordinate = new Coordinate(2, 4);
        Coordinate coordinate2 = new Coordinate("2-4");

        assertEquals(2, coordinate.getX());
        assertEquals(4, coordinate.getY());

        assertEquals(2, coordinate2.getX());
        assertEquals(4, coordinate2.getY());
    }

    @Test
    void testCoordinateIsNonNegativeInteger() {
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(-2, 4));
        assertThrows(IllegalArgumentException.class, () -> new Coordinate(2, Field.length + 1));
        assertThrows(IllegalArgumentException.class, () -> new Coordinate("-2-4"));
    }

}
