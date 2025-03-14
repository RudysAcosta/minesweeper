package minesweeper;

import minesweeper.io.InputHandler;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class MinesweeperTest {

    Scanner testScanner;

    @AfterEach
    void setUp() {
        testScanner.close();
    }

    void testHowManyMinesWith5() {
        String input = "5\n";
        testScanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        InputHandler inputHandler = new InputHandler(testScanner);
    }
}
