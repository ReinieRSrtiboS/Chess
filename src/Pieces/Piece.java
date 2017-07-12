package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.List;

public abstract class Piece {

    public Colour colour;
    public Boolean alive;

    public Piece(Colour colour) {
        this.colour = colour;
        alive = true;
    }

    public Boolean isAlive() { return alive; }

    public Colour getColour() { return colour; }

    public Boolean isLegal(Location oldLocation, Location newLocation) { return false; }

    public List<Location> isAttacking(Location location, Board board) { return null; }

    public Location getLocation(Board board) { return null; }
}
