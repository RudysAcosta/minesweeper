package minesweeper.model;

import minesweeper.output.Print;
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

}
