package Pieces;

import Model.Board;
import Model.Colour;
import Model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Knight extends Piece {

    private Map<Board, List<Location>> attacking = new HashMap<>();

    public Knight(Colour colour, String name) {
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
        int x = location.getX();
        int y = location.getY();
        List<Location> result = new ArrayList<>();
        if (board.inBorder(x + 2, y + 1)) {
            result.add(board.board[x+2][y+1]);
        }
        if (board.inBorder(x + 2, y - 1)) {
            result.add(board.board[x+2][y-1]);
        }
        if (board.inBorder(x - 2, y + 1)) {
            result.add(board.board[x-2][y+1]);
        }
        if (board.inBorder(x - 2, y - 1)) {
            result.add(board.board[x-2][y-1]);
        }
        if (board.inBorder(x + 1, y + 2)) {
            result.add(board.board[x+1][y+2]);
        }
        if (board.inBorder(x - 1, y + 2)) {
            result.add(board.board[x-1][y+2]);
        }
        if (board.inBorder(x + 1, y - 2)) {
            result.add(board.board[x+1][y-2]);
        }
        if (board.inBorder(x - 1, y - 2)) {
            result.add(board.board[x-1][y-2]);
        }
        attacking.clear();
        attacking.put(board, result);
        return result;
    }
}
