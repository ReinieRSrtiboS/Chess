package testPiece;

import Model.Board;
import Pieces.Piece;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testRook {

    private Piece rook;
    private Board board;

    @Before
    public void before() {
        board = new Board();
        rook = board.board[0][0].getOccupied();
    }

    @Test
    public void testIsAttacking() {
        Assert.assertTrue(rook.isAttacking(board.board[0][0], board).contains(board.board[1][0]));
        board.setMove(board.board[1][0], board.board[3][0]);
        board.setMove(board.board[0][1], board.board[2][2]);
        Assert.assertTrue(rook.isAttacking(board.board[0][0], board).contains(board.board[0][2]));
        Assert.assertTrue(rook.isAttacking(board.board[0][0], board).contains(board.board[3][0]));
        Assert.assertTrue(board.board[3][0].getAttackers().contains(rook));
        Assert.assertTrue(board.board[0][2].getAttackers().contains(rook));
    }
}
