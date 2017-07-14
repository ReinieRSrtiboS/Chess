package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;
import Model.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rook extends Piece {

    private Boolean castle;
    private Map<Pair<Location, Board>, List<Location>> attacking = new HashMap<>();

    public Rook(Colour colour) {
        super(colour);
        castle = true;
    }

    @Override
    public Boolean isLegal(Location oldLocation, Location newLocation, Board board) {
        // TODO test
        if (attacking.get(new Pair<>(oldLocation, board)) != null) {
            return attacking.get(new Pair<>(oldLocation, board)).contains(newLocation);
        } else {
            return isAttacking(oldLocation, board).contains(newLocation);
        }
    }

    //TODO defending
    @Override
    public List<Location> isAttacking(Location location, Board board) {
        List<Location> result = new ArrayList<>();
        int y = location.getY();
        int x = location.getX();
        for (int i = x; i < 8; i++) {
            if (board.board[i][y].getOccupied() == null) {
                result.add(board.board[i][y]);
            } else if (board.board[i][y].getOccupied().getColour() == getColour()) {
                break;
            } else {
                result.add(board.board[i][y]);
                break;
            }
        }
        for (int i = x; i >= 0; i--) {
            if (board.board[i][y].getOccupied() == null) {
                result.add(board.board[i][y]);
            } else if (board.board[i][y].getOccupied().getColour() == getColour()) {
                break;
            } else {
                result.add(board.board[i][y]);
                break;
            }
        }
        for (int i = y; i < 8; i++) {
            if (board.board[x][i].getOccupied() == null) {
                result.add(board.board[x][i]);
            } else if (board.board[x][i].getOccupied().getColour() != getColour()) {
                result.add(board.board[x][i]);
                break;
            } else {
                break;
            }
        }
        for (int i = y; i >= 0; i--) {
            if (board.board[x][i].getOccupied() == null) {
                result.add(board.board[x][i]);
            } else if (board.board[x][i].getOccupied().getColour() != getColour()) {
                result.add(board.board[x][i]);
                break;
            } else {
                break;
            }
        }
        attacking.clear();
        attacking.put(new Pair<>(location, board), result);
        return result;
    }

}
