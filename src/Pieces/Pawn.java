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
        setScore(10);
    }

    @Override
    public List<Location> isAttacking(Location location, Board board) {
        int y = location.getY();
        int x = location.getX();
        List<Location> result = new ArrayList<>();
        if (getColour() == Colour.WHITE) {
            if (board.inBorder(x+1, y+1)) {
                result.add(board.get(x+1, y+1));
            }
            if (board.inBorder(x+1, y-1)) {
                result.add(board.get(x+1, y-1));
            }
        } else {
            if (board.inBorder(x-1, y+1)) {
                result.add(board.get(x-1, y+1));
            }
            if (board.inBorder(x-1, y-1)) {
                result.add(board.get(x-1, y-1));
            }
        }

        return result;
    }

    @Override
    public Boolean isLegal(Location oldLocation, Location newLocation, Board board) {
        Boolean result;
        int x = oldLocation.getX();
        int y = oldLocation.getY();
        if (getColour() == Colour.WHITE) {
            result = firstMove && newLocation.getX() == x + 2 && newLocation.getY() == y && newLocation.getOccupant() == null;
            if (result) {
                return true;
            } else {
                if (newLocation.getY() == y) {
                    return newLocation.getX() == x + 1 && newLocation.getOccupant() == null;
                } else {
                    if (newLocation.getOccupant() == null) {
                        String locationOfDeadPawn = board.get(oldLocation.getX(), newLocation.getY()).getNotation();
                        Boolean firstMove = board.moves.get(board.moves.size() - 1).equals(locationOfDeadPawn);
                        Boolean enPassant = !board.moves.contains(newLocation.getNotation());
                        return firstMove && enPassant && newLocation.getX() == x + 1 && (newLocation.getY() == y + 1 || newLocation.getY() == y - 1) && newLocation.getOccupant() == null;
                    } else {
                        return newLocation.getX() == x + 1 && (newLocation.getY() == y + 1 || newLocation.getY() == y - 1) && !isFriendly(newLocation);
                    }
                }
            }
        } else {
            result = firstMove && newLocation.getX() == x - 2 && newLocation.getY() == y && newLocation.getOccupant() == null;
            if (result) {
                return true;
            } else {
                if (newLocation.getY() == y) {
                    return newLocation.getX() == x - 1 && newLocation.getOccupant() == null;
                } else {
                    if (newLocation.getOccupant() == null) {
                        String locationOfDeadPawn = board.get(newLocation.getX(), oldLocation.getY()).getNotation();
                        Boolean firstMove = board.moves.get(board.moves.size() - 1).equals(locationOfDeadPawn);
                        Boolean enPassant = !board.moves.contains(newLocation.getNotation());
                        return firstMove && enPassant && newLocation.getX() == x + 1 && (newLocation.getY() == y + 1 || newLocation.getY() == y - 1) && newLocation.getOccupant() == null;
                    } else {
                        return newLocation.getX() == x - 1 && (newLocation.getY() == y + 1 || newLocation.getY() == y - 1) && !isFriendly(newLocation);
                    }
                }
            }
        }
    }

    @Override
    public List<Location> legalMoves(Location location, Board board) {
        List<Location> result = new ArrayList<>();
        int x = location.getX();
        int y = location.getY();
        if (getColour() == Colour.WHITE) {
            if (board.get(x + 1, y).getOccupant() == null) {
                result.add(board.get(x + 1, y));
                if (firstMove && board.get(x + 2, y).getOccupant() == null) {
                    result.add(board.get(x + 2, y));
                }
            }
        } else {
            if (board.get(x - 1, y).getOccupant() == null) {
                result.add(board.get(x - 1, y));
                if (firstMove && board.get(x - 2, y).getOccupant() == null) {
                    result.add(board.get(x - 2, y));
                }
            }
        }
        for (Location location1 : isAttacking(location, board)) {
            if (isLegal(location, location1, board)) {
                result.add(location1);
            }
        }
        return result;
    }

    public Boolean getFirstMove() {
        return firstMove;
    }

    public void setFirstMove(Boolean firstMove) {
        this.firstMove = firstMove;
    }
}
