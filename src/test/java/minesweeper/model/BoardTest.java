package minesweeper.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();

        board.setMine(new int[]{4,2});
        board.setMine(new int[]{4,3});
        board.setMine(new int[]{5,4});
        board.setMine(new int[]{1,0});
        board.setMine(new int[]{5,3});
        board.setMine(new int[]{7,0});
        board.setMine(new int[]{7,7});
        board.setMine(new int[]{5,8});
        board.setMine(new int[]{6,1});
        board.setMine(new int[]{8,8});

        board.fill();
    }

    @Test
    void testGetNeighbors() {
        board.setCountMines(4);
        board.fill();

        Set<String> neighbors = board.getNeighbors(new int[]{0, 0});

        assertEquals(3, neighbors.size());
        assertTrue(neighbors.contains("1-0"));
        assertTrue(neighbors.contains("0-1"));
        assertTrue(neighbors.contains("1-1"));

        neighbors = board.getNeighbors(new int[]{3, 3});
        assertTrue(neighbors.contains("2-2"));
        assertTrue(neighbors.contains("2-3"));
        assertTrue(neighbors.contains("2-4"));
        assertTrue(neighbors.contains("3-4"));
        assertTrue(neighbors.contains("4-4"));
        assertTrue(neighbors.contains("4-3"));
        assertTrue(neighbors.contains("4-2"));
        assertTrue(neighbors.contains("3-2"));
    }

    @Test
    void testGetCountMinesNearbyPos() {
        assertEquals(board.getCountMinesNearbyPos(new int[]{0,0}), 1);
        assertEquals(board.getCountMinesNearbyPos(new int[]{6,0}), 0);
        assertEquals(board.getCountMinesNearbyPos(new int[]{7,8}), 2);
        assertEquals(board.getCountMinesNearbyPos(new int[]{6,6}), 1);
        assertEquals(board.getCountMinesNearbyPos(new int[]{6,6}), 1);
        assertEquals(board.getCountMinesNearbyPos(new int[]{2,5}), 4);
        assertEquals(board.getCountMinesNearbyPos(new int[]{0,2}), 1);
        assertEquals(board.getCountMinesNearbyPos(new int[]{8,9}), 1);
        assertEquals(board.getCountMinesNearbyPos(new int[]{8,7}), 2);
    }

    @Test
    void tesStartBoard() {
        String expectedBoard =
                "\u00A0|123456789|\n" +
                "-|---------|\n" +
                "1|1X1..12X1|\n" +
                "2|111112X21|\n" +
                "3|...2X421.|\n" +
                "4|...2XX2..|\n" +
                "5|...13X2..|\n" +
                "6|....111..|\n" +
                "7|......111|\n" +
                "8|....112X2|\n" +
                "9|....1X22X|\n" +
                "-|---------|";

        assertEquals(expectedBoard, board.boardToString());
    }

    @Test
    void testRandomMines() {
        Board boardTest = new Board();
        boardTest.setCountMines(5);

        Board boardTest2 = new Board();
        boardTest2.setCountMines(10);

        assertEquals(5, boardTest.getMines().size());
        assertEquals(10, boardTest2.getMines().size());
    }

}
