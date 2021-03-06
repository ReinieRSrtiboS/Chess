package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bishop extends Piece {

    private Map<Board, List<Location>> attacking = new HashMap<>();

    public Bishop(Colour colour, String name) {
        super(colour, name);
        setScore(30);
    }

    @Override
    public Boolean isLegal(Location oldLocation, Location newLocation, Board board) {
        Boolean result;
        if (attacking.get(board) != null) {
            result = attacking.get(board).contains(newLocation);
        } else {
            result = isAttacking(oldLocation, board).contains(newLocation);
        }
        return result && !isFriendly(newLocation);
    }

    @Override
    public List<Location> isAttacking(Location location, Board board) {
        List<Location> result = new ArrayList<>();
        int y = location.getY();
        int x = location.getX();
        int i = 1;
        while (board.inBorder(x + i, y + i)) {
            if (board.get(x+i, y+i).getOccupant() == null) {
                result.add(board.get(x+i, y+i));
            } else {
                result.add(board.get(x+i, y+i));
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x + i, y - i)) {
            if (board.get(x+i, y-i).getOccupant() == null) {
                result.add(board.get(x+i, y-i));
            } else {
                result.add(board.get(x+i, y-i));
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x - i, y + i)) {
            if (board.get(x-i, y+i).getOccupant() == null) {
                result.add(board.get(x-i, y+i));
            } else {
                result.add(board.get(x-i, y+i));
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x - i, y - i)) {
            if (board.get(x-i, y-i).getOccupant() == null) {
                result.add(board.get(x-i, y-i));
            } else {
                result.add(board.get(x-i, y-i));
                break;
            }
            i++;
        }
        attacking.clear();
        attacking.put(board, result);
        return result;
    }

    @Override
    public List<Location> legalMoves(Location location, Board board) {
        List<Location> result = new ArrayList<>();
        if (attacking.get(board) != null) {
            for (Location location1 : attacking.get(board)) {
                if (!isFriendly(location1)) {
                    result.add(location1);
                }
            }
        } else {
            for (Location location1 : isAttacking(location, board)) {
                if (!isFriendly(location1)) {
                    result.add(location1);}
            }
        }
        return result;
    }
}
