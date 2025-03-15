package minesweeper.model;

public class Action {

    private String moveType;

    private Coordinate coordinate;

    public Action(String moveType, Coordinate coordinate) {
        this.moveType = moveType;
        this.coordinate = coordinate;
    }

    public String getMoveType() {
        return moveType;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return moveType + "=>" + coordinate;
    }
}