package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    private Boolean firstMove;

    public Pawn(Colour colour) {
        super(colour);
        firstMove = true;
    }

    // TODO en passant
    @Override
    public List<Location> isAttacking(Location location, Board board) {
        int y = location.getY();
        int x = location.getX();
        List<Location> result = new ArrayList<>();
        if (y == 8) {
            return null;
        } else {
            if (x > 1) {
                if (x < 8) {
                    if (!isFriendly(board.board[x+1][y+1])) {
                        result.add(board.board[x+1][y+1]);
                    }
                    if (!isFriendly(board.board[x-1][y+1])) {
                        result.add(board.board[x-1][y+1]);
                    }
                } else {
                    if (!isFriendly(board.board[x-1][y+1])) {
                        result.add(board.board[x-1][y+1]);
                    }
                }
            } else {
                if (!isFriendly(board.board[x+1][y+1])) {
                    result.add(board.board[x+1][y+1]);
                }
            }
        }
        return result;
    }

    //TODO en passant
    @Override
    public Boolean isLegal(Location oldLocation, Location newLocation, Board board) {
        return false;
    }
}
