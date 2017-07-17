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
        if (getColour() == Colour.WHITE) {
            if (newLocation.getY() == 2 && newLocation.getX() == 0 && castle) {
                Rook rook = (Rook) board.get(0, 0).getOccupant();
                for (Piece piece : board.get(0, 4).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(0, 3).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(0, 2).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(0, 1).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                return rook != null && rook.getCastle() && board.get(0, 1).getOccupant() == null && board.get(0, 2).getOccupant() == null && board.get(0, 3).getOccupant() == null;
            } else if (newLocation.getY() == 6 && newLocation.getX() == 0 && castle) {
                Rook rook = (Rook) board.get(0, 7).getOccupant();
                for (Piece piece : board.get(0, 7).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(0, 6).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(0, 5).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(0, 4).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                return rook != null && rook.getCastle() && board.get(0, 6).getOccupant() == null && board.get(0, 5).getOccupant() == null;
            } else {
                int difX = oldLocation.getX() - newLocation.getX();
                int difY = oldLocation.getY() - newLocation.getY();
                return !isFriendly(newLocation) && difX >= -1 && difX <= 1 && difY >= -1 && difY <= 1 && (difX != 0 && difY != 0);
            }
        } else {
            if (newLocation.getY() == 2 && newLocation.getX() == 7 && castle) {
                Rook rook = (Rook) board.get(7, 0).getOccupant();
                for (Piece piece : board.get(7, 4).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(7, 3).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(7, 2).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(7, 1).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                return rook != null && rook.getCastle() && board.get(7, 1).getOccupant() == null && board.get(7, 2).getOccupant() == null && board.get(7, 3).getOccupant() == null;
            } else if (newLocation.getY() == 6 && newLocation.getX() == 7 && castle) {
                Rook rook = (Rook) board.get(7, 7).getOccupant();
                for (Piece piece : board.get(7, 7).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(7, 6).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(7, 5).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                for (Piece piece : board.get(7, 4).getAttackers()) {
                    if (piece.getColour() != Colour.WHITE) {
                        return false;
                    }
                }
                return rook != null && rook.getCastle() && board.get(7, 6).getOccupant() == null && board.get(7, 5).getOccupant() == null;
            } else {
                int difX = oldLocation.getX() - newLocation.getX();
                int difY = oldLocation.getY() - newLocation.getY();
                return !isFriendly(newLocation) && difX >= -1 && difX <= 1 && difY >= -1 && difY <= 1 && (difX != 0 && difY != 0);
            }
        }
    }

    @Override
    public List<Location> isAttacking(Location location, Board board) {
        List<Location> result = new ArrayList<>();
        int x = location.getX();
        int y = location.getY();
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (board.inBorder(x + i, y + j) && board.get(x+i, y+j).getOccupant() != this) {
                    result.add(board.get(x+i, y+j));
                }
            }
        }
        return result;
    }

    public Boolean getCastle() {
        return castle;
    }

    public void setCastle(Boolean castle) {
        this.castle = castle;
    }
}
