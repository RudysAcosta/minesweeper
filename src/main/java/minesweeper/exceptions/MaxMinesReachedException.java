package minesweeper.exceptions;

public class MaxMinesReachedException extends RuntimeException {
    public MaxMinesReachedException(String message) {
        super(message);
    }
}
