package testPiece;

import Model.Board;
import Pieces.Pawn;
import Exception.NotOnBoardException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testPawn {

    private Pawn pawn;
    private Board board;

    @Before
    public void before() {
        board = new Board();
        pawn = (Pawn) board.get(1, 4).getOccupant();
    }

    @Test
    public void testIsAttacking() throws NotOnBoardException{
        Assert.assertTrue(pawn.isAttacking(board.get(1, 4), board).contains(board.get(2, 5)));
        Assert.assertTrue(pawn.isAttacking(board.get(1, 4), board).contains(board.get(2, 3)));
        board.moveLogistics(board.get(1, 4), board.get(3, 4));
        Assert.assertFalse(pawn.isAttacking(board.get(3, 4), board).contains(board.get(2, 5)));
        Assert.assertFalse(pawn.isAttacking(board.get(3, 4), board).contains(board.get(2, 3)));
        Assert.assertTrue(pawn.isAttacking(board.get(3, 4), board).contains(board.get(4, 5)));
        Assert.assertTrue(pawn.isAttacking(board.get(3, 4), board).contains(board.get(4, 3)));
    }

    @Test
    public void testLegalMove() throws NotOnBoardException{
        Assert.assertTrue(pawn.isLegal(board.get(1, 4), board.get(3, 4), board));
        Assert.assertTrue(pawn.isLegal(board.get(1, 4), board.get(2, 4), board));
        board.moveLogistics(board.get(1, 4), board.get(3, 4));
        board.moveLogistics(board.get(6, 5), board.get(4, 5));
        Assert.assertTrue(pawn.isLegal(board.get(3, 4), board.get(4, 5), board));
        Assert.assertTrue(pawn.isLegal(board.get(3, 4), board.get(4, 4), board));
    }

    @Test
    public void testEnPassant() throws NotOnBoardException{
        board.moveLogistics(board.get(1, 4), board.get(3, 4));
        board.moveLogistics(board.get(6, 5), board.get(4, 5));
        board.moveLogistics(board.get(3, 4), board.get(4, 4));
        board.moveLogistics(board.get(6, 3), board.get(4, 3));
        Assert.assertTrue(pawn.isLegal(board.get(4, 4), board.get(5, 3), board));
        board.moveLogistics(board.get(1, 5), board.get(3, 5));
        Assert.assertFalse(pawn.isLegal(board.get(4, 4), board.get(5, 3), board));
        Assert.assertFalse(pawn.isLegal(board.get(4, 4), board.get(5, 5), board));
    }
}
