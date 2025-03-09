package minesweeper.model;

import org.junit.jupiter.api.Test;

import java.util.Set;

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

    @Test
    void testGetNeighbors() {
        Coordinate coordinate1 = new Coordinate(0, 0);
        assertTrue(coordinate1.getNeighbors().containsAll(Set.of("1-0", "1-1", "0-1")));

        Coordinate coordinate2 = new Coordinate(1, 1);
        assertTrue(coordinate2.getNeighbors().containsAll(Set.of("0-1", "0-0", "1-0", "2-0", "2-1", "2-2", "1-2", "0-2")));

        Coordinate coordinate3 = new Coordinate(3, 0);
        assertTrue(coordinate3.getNeighbors().containsAll(Set.of("2-0", "2-1", "3-1", "4-1", "4-0")));

        Coordinate coordinate4 = new Coordinate(0, 3);
        assertTrue(coordinate4.getNeighbors().containsAll(Set.of("0-2", "1-2", "1-3", "1-4", "0-4")));
    }

}
