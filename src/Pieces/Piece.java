package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.List;

public abstract class Piece {

    private Colour colour;
    private Boolean alive;
    private String name;

    Piece(Colour colour, String name) {
        this.colour = colour;
        this.name = name;
        alive = true;
    }

    public Boolean isAlive() { return alive; }

    public void isDead() { alive = false; }

    public Colour getColour() { return colour; }

    public Boolean isLegal(Location oldLocation, Location newLocation, Board board) { return false; }

    public List<Location> isAttacking(Location location, Board board) { return null; }

    public Location getLocation(Board board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.get(i, j).getOccupant() == this) {
                    return board.get(i, j);
                }
            }
        }
        return null;
    }

    Boolean isFriendly(Location location) {
        return (location.getOccupant() != null && location.getOccupant().getColour() == this.getColour());
    }

    @Override
    public String toString() {
        return name;
    }
}
