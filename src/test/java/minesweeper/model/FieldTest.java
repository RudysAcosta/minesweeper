package minesweeper.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

    private Field field;

    @BeforeEach
    void setUp() {
        this.field = new Field();
    }

    @Test
    void testFieldDefaultStructure() {
        String expectedBoard = "\u00A0|123456789|\n"+
                "-|---------|\n" +
                "1|.........|\n" +
                "2|.........|\n" +
                "3|.........|\n" +
                "4|.........|\n" +
                "5|.........|\n" +
                "6|.........|\n" +
                "7|.........|\n" +
                "8|.........|\n" +
                "9|.........|\n" +
                "-|---------|";

        assertEquals(expectedBoard, field.toString());
    }

    @Test
    void testSetMine() {
        field.setCountMines(5);
        field.setMine(new Coordinate(0,0));

        assertEquals(1, field.getMines().size());

        field.setMine(new Coordinate(1,0));
        field.setMine(new Coordinate(2,0));

        assertEquals(3, field.getMines().size());

        field.setMine(new Coordinate(2,0));
        assertEquals(3, field.getMines().size());
    }


}
