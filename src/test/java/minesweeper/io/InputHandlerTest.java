package minesweeper.io;

import minesweeper.model.Coordinate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class InputHandlerTest {

    Scanner testScanner;

    @AfterEach
    void setUp() {
        testScanner.close();
    }

    @Test
    void testGetValidNumber() {
        String input = "5\n";
        testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler(testScanner);

        int result = inputHandler.get("Enter a number: ");
        assertEquals(5, result);
    }

    @Test
    void testGetCoordinateValidInput() {
        String input = "3 4\n";
        testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler(testScanner);

        Coordinate coord = inputHandler.getCoordinate();
        assertEquals(3, coord.getX());
        assertEquals(4, coord.getY());
    }

    @Test
    void testGetCoordinateInvalidThenValid() {
        String input = "invalid\n2 5\n";
        testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler(testScanner);

        Coordinate coord = inputHandler.getCoordinate();
        assertEquals(2, coord.getX());
        assertEquals(5, coord.getY());
    }

    @Test
    void testGetCoordinateWithSpacesInsteadOfDashes() {
        String input = "7 8\n";
        testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler(testScanner);

        Coordinate coord = inputHandler.getCoordinate();
        assertEquals(7, coord.getX());
        assertEquals(8, coord.getY());
    }

    @Test
    void testGetCoordinateWithDashes() {
        String input = "5-7\n";
        testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler(testScanner);

        Coordinate coord = inputHandler.getCoordinate();
        assertEquals(5, coord.getX());
        assertEquals(7, coord.getY());
    }

    @Test
    void testGetCoordinateMultipleInvalidBeforeValid() {
        String input = "a-b\n-5 6\ninvalid\n3 2\n";
        testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler(testScanner);

        Coordinate coordinate = inputHandler.getCoordinate();
        assertEquals(3, coordinate.getX());
        assertEquals(2, coordinate.getY());
    }
}

