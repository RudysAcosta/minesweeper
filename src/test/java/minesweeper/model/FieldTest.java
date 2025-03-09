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




}
