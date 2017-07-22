package testPiece;

import Model.Board;
import Pieces.Piece;
import Exception.NotOnBoardException;
import Exception.NoPieceException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testRook {

    private Piece rook;
    private Board board;

    @Before
    public void before() {
        board = new Board();
        rook = board.get(0, 0).getOccupant();
    }

    @Test
    public void testIsAttacking() throws NotOnBoardException, NoPieceException {
        Assert.assertTrue(rook.isAttacking(board.get(0, 0), board).contains(board.get(1, 0)));
        board.moveLogistics(board.get(1, 0), board.get(3, 0));
        board.moveLogistics(board.get(0, 1), board.get(2, 2));
        Assert.assertTrue(rook.isAttacking(board.get(0, 0), board).contains(board.get(0, 2)));
        Assert.assertTrue(rook.isAttacking(board.get(0, 0), board).contains(board.get(3, 0)));
        Assert.assertTrue(board.get(3, 0).getAttackers().contains(rook));
        Assert.assertTrue(board.get(0, 2).getAttackers().contains(rook));
    }
}
