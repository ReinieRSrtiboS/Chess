package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    private Boolean castle;

    public King(Colour colour, String name) {
        super(colour, name);
        castle = true;
    }

    @Override
    public Boolean isLegal(Location oldLocation, Location newLocation, Board board) {
        int difX = oldLocation.getX() - newLocation.getX();
        int difY = oldLocation.getY() - newLocation.getY();
        return !isFriendly(newLocation) && difX >= -1 && difX <= 1 && difY >= -1 && difY <= 1 && (difX != 0 && difY != 0);
    }

    @Override
    public List<Location> isAttacking(Location location, Board board) {
        List<Location> result = new ArrayList<>();
        int x = location.getX();
        int y = location.getY();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (board.inBorder(x + i, y + j) && board.board[x+i][y+j].getOccupied() != this) {
                    result.add(board.board[x+i][y+j]);
                }
            }
        }
        return result;
    }
}
