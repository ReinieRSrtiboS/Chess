package testModel;

import Model.Board;
import Pieces.Piece;
import Exception.NotOnBoardException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testBoard {

    Board board;

    @Before
    public void before() {
        board = new Board();
    }

    @Test
    public void testCopy() throws NotOnBoardException {
        Piece pawn = board.get(1, 1).getOccupant();
        Board copy = board.copy();
        Assert.assertTrue(copy.equals(board));
        copy.setMove(copy.get(1, 1), copy.get(3, 1));
        Assert.assertFalse(copy.equals(board));
        Assert.assertTrue(copy.get(3, 1).getOccupant() == pawn);
        Assert.assertTrue(board.get(3, 1).getOccupant() == null);
        board.setMove(board.get(1, 1), board.get(2,1));
        Assert.assertFalse(copy.equals(board));
        Assert.assertTrue(copy.get(2, 1).getOccupant() == null);
        Assert.assertTrue(board.get(2, 1).getOccupant() == pawn);
    }

    @Test
    public void testSetMove() throws NotOnBoardException {
        Piece pawn = board.get(1, 1).getOccupant();
        Piece bishop = board.get(0, 2).getOccupant();
        Assert.assertFalse(board.get(2, 0).getAttackers().contains(bishop));
        Assert.assertTrue(board.get(2, 0).getAttackers().contains(pawn));
        board.setMove(board.get(1, 1), board.get(3, 1));
        Assert.assertTrue(board.get(1, 1).getOccupant() == null);
        Assert.assertTrue(board.get(3, 1).getOccupant() == pawn);
        Assert.assertTrue(board.get(2, 0).getAttackers().contains(bishop));
        Assert.assertFalse(board.get(2, 0).getAttackers().contains(pawn));
        Assert.assertTrue(board.get(4, 0).getAttackers().contains(pawn));
    }

    @Test
    public void testIsLegalMove() throws NotOnBoardException {
        Assert.assertTrue(board.isLegalMove(board.get(1, 1), board.get(3, 1)));
        Assert.assertTrue(board.isLegalMove(board.get(1, 1), board.get(2, 1)));
        Assert.assertFalse(board.isLegalMove(board.get(1, 1), board.get(4, 1)));
    }

    @Test
    public void testCheck() throws NotOnBoardException {
        Assert.assertFalse(board.check());
        board.setMove(board.get(6, 5), board.get(4, 5));
        board.setMove(board.get(1, 4), board.get(3, 4));
        board.setMove(board.get(6, 4), board.get(4, 4));
        board.setMove(board.get(0, 3), board.get(4, 7));
        Assert.assertTrue(board.check());
    }

    @Test
    public void testCapture() throws NotOnBoardException {
        Piece deadPawn = board.get(6, 5).getOccupant();
        board.setMove(board.get(1, 4), board.get(3, 4));
        board.setMove(board.get(6, 5), board.get(4, 5));
        board.setMove(board.get(3, 4), board.get(4, 5));
        Assert.assertFalse(deadPawn.isAlive());
        Assert.assertFalse(board.pieces.contains(deadPawn));
    }
}
