package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Queen extends Piece {

    private Map<Board, List<Location>> attacking = new HashMap<>();

    public Queen(Colour colour, String name) {
        super(colour, name);
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
            if (board.board[x+i][y+i].getOccupied() == null) {
                result.add(board.board[x+i][y+i]);
            } else {
                result.add(board.board[x+i][y+i]);
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x + i, y - i)) {
            if (board.board[x+i][y-i].getOccupied() == null) {
                result.add(board.board[x+i][y-i]);
            } else {
                result.add(board.board[x+i][y-i]);
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x - i, y + i)) {
            if (board.board[x-i][y+i].getOccupied() == null) {
                result.add(board.board[x-i][y+i]);
            } else {
                result.add(board.board[x-i][y+i]);
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x - i, y - i)) {
            if (board.board[x-i][y-i].getOccupied() == null) {
                result.add(board.board[x-i][y-i]);
            } else {
                result.add(board.board[x-i][y-i]);
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x+i, y)) {
            if (board.board[x+i][y].getOccupied() == null) {
                result.add(board.board[x+i][y]);
            } else {
                result.add(board.board[x+i][y]);
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x-i, y)) {
            if (board.board[x-i][y].getOccupied() == null) {
                result.add(board.board[x-i][y]);
            } else {
                result.add(board.board[x-i][y]);
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x, y+i)) {
            if (board.board[x][y+i].getOccupied() == null) {
                result.add(board.board[x][y+i]);
            } else {
                result.add(board.board[x][y+i]);
                break;
            }
            i++;
        }
        i = 1;
        while (board.inBorder(x, y-i)) {
            if (board.board[x][y-i].getOccupied() == null) {
                result.add(board.board[x][y-i]);
            } else {
                result.add(board.board[x][y-i]);
                break;
            }
            i++;
        }
        attacking.clear();
        attacking.put(board, result);
        return result;
    }
}
