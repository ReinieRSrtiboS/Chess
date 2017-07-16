package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private Boolean firstMove;

    public Pawn(Colour colour, String name) {
        super(colour, name);
        firstMove = true;
    }

    @Override
    public List<Location> isAttacking(Location location, Board board) {
        int y = location.getY();
        int x = location.getX();
        List<Location> result = new ArrayList<>();
        if (getColour() == Colour.WHITE) {
            if (board.inBorder(x+1, y+1)) {
                result.add(board.board[x+1][y+1]);
            }
            if (board.inBorder(x+1, y-1)) {
                result.add(board.board[x+1][y-1]);
            }
        } else {
            if (board.inBorder(x-1, y+1)) {
                result.add(board.board[x-1][y+1]);
            }
            if (board.inBorder(x-1, y-1)) {
                result.add(board.board[x-1][y-1]);
            }
        }

        return result;
    }

    //TODO en passant
    @Override
    public Boolean isLegal(Location oldLocation, Location newLocation, Board board) {
        Boolean result;
        int x = oldLocation.getX();
        int y = oldLocation.getY();
        result = firstMove && newLocation.getX() == x + 2 && newLocation.getY() == y && newLocation.getOccupied() == null;
        firstMove = false;
        if (result) {
            return true;
        } else {
            if (newLocation.getY() == y) {
                return newLocation.getX() == x + 1 && newLocation.getOccupied() == null;
            } else {
                return newLocation.getX() == x + 1 && (newLocation.getY() == y + 1 || newLocation.getY() == y - 1) &&  !isFriendly(newLocation);
            }
        }
    }
}
