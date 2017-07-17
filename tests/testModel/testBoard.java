package testModel;

import Model.Board;
import Pieces.Piece;
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
    public void testCopy() {
        Piece pawn = board.board[1][1].getOccupied();
        Board copy = board.copy();
        Assert.assertTrue(copy.equals(board));
        copy.setMove(copy.board[1][1], copy.board[3][1]);
        Assert.assertFalse(copy.equals(board));
        Assert.assertTrue(copy.board[3][1].getOccupied() == pawn);
        Assert.assertTrue(board.board[3][1].getOccupied() == null);
        board.setMove(board.board[1][1], board.board[2][1]);
        Assert.assertFalse(copy.equals(board));
        Assert.assertTrue(copy.board[2][1].getOccupied() == null);
        Assert.assertTrue(board.board[2][1].getOccupied() == pawn);
    }

    @Test
    public void testSetMove() {
        Piece pawn = board.board[1][1].getOccupied();
        Piece bishop = board.board[0][2].getOccupied();
        Assert.assertFalse(board.board[2][0].getAttackers().contains(bishop));
        Assert.assertTrue(board.board[2][0].getAttackers().contains(pawn));
        board.setMove(board.board[1][1], board.board[3][1]);
        Assert.assertTrue(board.board[1][1].getOccupied() == null);
        Assert.assertTrue(board.board[3][1].getOccupied() == pawn);
        Assert.assertTrue(board.board[2][0].getAttackers().contains(bishop));
        Assert.assertFalse(board.board[2][0].getAttackers().contains(pawn));
        Assert.assertTrue(board.board[4][0].getAttackers().contains(pawn));
    }

    @Test
    public void testIsLegalMove() {
        Assert.assertTrue(board.isLegalMove(board.board[1][1], board.board[3][1]));
        Assert.assertTrue(board.isLegalMove(board.board[1][1], board.board[2][1]));
        Assert.assertFalse(board.isLegalMove(board.board[1][1], board.board[4][1]));
    }

    @Test
    public void testCheck() {
        Assert.assertFalse(board.check());
        board.setMove(board.board[6][5], board.board[4][5]);
        board.setMove(board.board[1][4], board.board[3][4]);
        board.setMove(board.board[6][4], board.board[4][4]);
        board.setMove(board.board[0][3], board.board[4][7]);
        Assert.assertTrue(board.check());
    }
}
