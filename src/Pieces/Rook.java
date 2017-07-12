package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.List;

public class Rook extends Piece {

    private Boolean castle;

    public Rook(Colour colour) {
        super(colour);
        castle = true;
    }

    @Override
    public Boolean isLegal(Location oldLocation, Location newLocation) {
        return super.isLegal(oldLocation, newLocation);
    }

    @Override
    public List<Location> isAttacking(Location location, Board board) {
        return super.isAttacking(location, board);
    }

    @Override
    public Location getLocation(Board board) {
        return super.getLocation(board);
    }
}
