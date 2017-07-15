package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rook extends Piece {

    private Boolean castle;
    private Map<Board, List<Location>> attacking = new HashMap<>();

    public Rook(Colour colour) {
        super(colour);
        castle = true;
    }

    //TODO castle
    @Override
    public Boolean isLegal(Location oldLocation, Location newLocation, Board board) {
        // TODO test
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
        for (int i = x; i < 8; i++) {
            if (board.board[i][y].getOccupied() == null) {
                result.add(board.board[i][y]);
            } else {
                result.add(board.board[i][y]);
                break;
            }
        }
        for (int i = x; i >= 0; i--) {
            if (board.board[i][y].getOccupied() == null) {
                result.add(board.board[i][y]);
            } else {
                result.add(board.board[i][y]);
                break;
            }
        }
        for (int i = y; i < 8; i++) {
            if (board.board[x][i].getOccupied() == null) {
                result.add(board.board[x][i]);
            } else {
                result.add(board.board[x][i]);
                break;
            }
        }
        for (int i = y; i >= 0; i--) {
            if (board.board[x][i].getOccupied() == null) {
                result.add(board.board[x][i]);
            } else {
                result.add(board.board[x][i]);
                break;
            }
        }
        attacking.clear();
        attacking.put(board, result);
        return result;
    }

}
