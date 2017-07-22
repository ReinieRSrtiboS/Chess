package testPiece;

import Model.Board;
import Pieces.Piece;
import Exception.NotOnBoardException;
import Exception.NoPieceException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testKing {

    private Piece king;
    private Board board;

    @Before
    public void before() {
        board = new Board();
        king = board.get(0, 4).getOccupant();
    }

    @Test
    public void testIsAttacking() {
        Assert.assertTrue(king.isAttacking(board.get(0, 4), board).contains(board.get(0, 5)));

    }

    @Test
    public void testCastle() throws NotOnBoardException, NoPieceException {
        Assert.assertFalse(king.isLegal(board.get(0, 4), board.get(0, 2), board));
        board.moveLogistics(board.get(1, 4), board.get(3, 4));
        board.moveLogistics(board.get(6, 1), board.get(5, 1));
        board.moveLogistics(board.get(0, 6), board.get(2, 5));
        board.moveLogistics(board.get(6, 2), board.get(5, 2));
        board.moveLogistics(board.get(0, 5), board.get(5, 0));
        Assert.assertTrue(king.isLegal(board.get(0, 4), board.get(0, 6), board));
        board.moveLogistics(board.get(7, 2), board.get(5, 0));
        Assert.assertFalse(king.isLegal(board.get(0, 4), board.get(0, 6), board));
        board.moveLogistics(board.get(0, 7), board.get(0, 6));
        board.moveLogistics(board.get(5, 0), board.get(6, 1));
        Assert.assertFalse(king.isLegal(board.get(0, 4), board.get(0, 6), board));
    }

}
