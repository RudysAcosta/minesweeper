package minesweeper.model;

public class Action {

    private String action;

    private Coordinate coordinate;

    public Action(String action, Coordinate coordinate) {
        this.action = action;
        this.coordinate = coordinate;
    }

    public String getAction() {
        return action;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return action + "=>" + coordinate;
    }
}