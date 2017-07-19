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
        copy.moveLogistics(copy.get(1, 1), copy.get(3, 1));
        Assert.assertFalse(copy.equals(board));
        Assert.assertTrue(copy.get(3, 1).getOccupant() == pawn);
        Assert.assertTrue(board.get(3, 1).getOccupant() == null);
        board.moveLogistics(board.get(1, 1), board.get(2,1));
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
        board.moveLogistics(board.get(1, 1), board.get(3, 1));
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
        board.moveLogistics(board.get(6, 5), board.get(4, 5));
        board.moveLogistics(board.get(1, 4), board.get(3, 4));
        board.moveLogistics(board.get(6, 4), board.get(4, 4));
        board.moveLogistics(board.get(0, 3), board.get(4, 7));
        Assert.assertTrue(board.check());
    }

    @Test
    public void testCapture() throws NotOnBoardException {
        Piece deadPawn = board.get(6, 5).getOccupant();
        board.moveLogistics(board.get(1, 4), board.get(3, 4));
        board.moveLogistics(board.get(6, 5), board.get(4, 5));
        board.moveLogistics(board.get(3, 4), board.get(4, 5));
        Assert.assertFalse(deadPawn.isAlive());
        Assert.assertFalse(board.pieces.contains(deadPawn));
    }

    @Test
    public void testCastle() throws NotOnBoardException {
        Piece king = board.get(0, 4).getOccupant();
        Piece rook = board.get(0, 7).getOccupant();
        board.moveLogistics(board.get(1, 4), board.get(3, 4));
        board.moveLogistics(board.get(6, 1), board.get(5, 1));
        board.moveLogistics(board.get(0, 6), board.get(2, 5));
        board.moveLogistics(board.get(6, 2), board.get(5, 2));
        board.moveLogistics(board.get(0, 5), board.get(3, 2));
        board.moveLogistics(board.get(7, 2), board.get(6, 1));
        board.moveLogistics(board.get(0, 4), board.get(0, 6));
        System.out.println(board.toString());
        Assert.assertTrue(board.get(0, 7).getAttackers().contains(king));
        Assert.assertFalse(board.get(0, 7).getAttackers().contains(rook));
        Assert.assertTrue(board.get(1, 5).getAttackers().contains(rook));
        Assert.assertTrue(board.get(0, 3).getAttackers().contains(rook));
        Assert.assertTrue(board.get(0, 5).getAttackers().contains(board.get(0, 3).getOccupant()));
    }
}
