package testPiece;

import Model.Board;
import Pieces.Piece;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testQueen {

    private Piece queen;
    private Board board;

    @Before
    public void before() {
        board = new Board();
        queen = board.board[0][3].getOccupied();
    }

    @Test
    public void testIsAttacking() {
        board.setMove(board.board[1][4], board.board[2][4]);
        board.setMove(board.board[0][3], board.board[3][6]);
        Assert.assertTrue(board.board[3][1].getAttackers().contains(queen));
        Assert.assertFalse(board.board[0][4].getAttackers().contains(queen));
    }

    @Test
    public void testGetLocation() {
        Assert.assertEquals(queen.getLocation(board), board.board[0][3]);
        board.setMove(board.board[1][4], board.board[2][4]);
        board.setMove(board.board[0][3], board.board[3][6]);
        Assert.assertEquals(queen.getLocation(board), board.board[3][6]);
    }
}
