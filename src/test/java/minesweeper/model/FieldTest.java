package minesweeper.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FieldTest {

    private Field field;

    @BeforeEach
    void setUp() {
        this.field = new Field();
    }

    private void setMines() {
        field.setCountMines(10);
        field.setMine(new Coordinate(1,0));
        field.setMine(new Coordinate(5,3));
        field.setMine(new Coordinate(2,4));
        field.setMine(new Coordinate(7,3));
        field.setMine(new Coordinate(4,2));
        field.setMine(new Coordinate(8,7));
        field.setMine(new Coordinate(5,8));
        field.setMine(new Coordinate(7,6));
        field.setMine(new Coordinate(2,8));
        field.setMine(new Coordinate(8,8));
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

    @ParameterizedTest
    @CsvSource({
            "0, 1, 1",
            "0, 2, 0",
            "5, 1, 1",
            "5, 2, 2",
            "6, 2, 2",
            "7, 2, 1",
            "7, 0, 0",
            "7, 3, 0",
            "7, 4, 1",
            "8, 6, 2",
    })
    void testGetCountMinesNearby(int x, int y, int expectedCount) {
        setMines();
        int actualCount = field.getCountMinesNearby(new Coordinate(x, y));

        String displayName = String.format("(%d, %d) -> expectedCount: %d, actualCount: %d",
                x, y, expectedCount, actualCount);
        System.out.println(displayName);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    void testCorrectMinefieldStringFormat() {
        setMines();
        String expectedBoard = "\u00A0|123456789|\n"+
                "-|---------|\n" +
                "1|1.1......|\n" +
                "2|111111...|\n" +
                "3|...1.2211|\n" +
                "4|.1122.2.1|\n" +
                "5|.1.111211|\n" +
                "6|.111..111|\n" +
                "7|......1.2|\n" +
                "8|.1111123.|\n" +
                "9|.1.11.12.|\n" +
                "-|---------|";

        assertEquals(expectedBoard, field.toString());
    }
}
