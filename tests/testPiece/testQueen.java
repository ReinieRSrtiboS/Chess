package testPiece;

import Model.Board;
import Pieces.Piece;
import Exception.NotOnBoardException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testQueen {

    private Piece queen;
    private Board board;

    @Before
    public void before() {
        board = new Board();
        queen = board.get(0, 3).getOccupant();
    }

    @Test
    public void testIsAttacking() throws NotOnBoardException {
        board.setMove(board.get(1, 4), board.get(2, 4));
        board.setMove(board.get(0, 3), board.get(3, 6));
        Assert.assertTrue(board.get(3, 1).getAttackers().contains(queen));
        Assert.assertFalse(board.get(0, 4).getAttackers().contains(queen));
    }

    @Test
    public void testGetLocation() throws NotOnBoardException {
        Assert.assertEquals(queen.getLocation(board), board.get(0, 3));
        board.setMove(board.get(1, 4), board.get(2, 4));
        board.setMove(board.get(0, 3), board.get(3, 6));
        Assert.assertEquals(queen.getLocation(board), board.get(3, 6));
    }
}
