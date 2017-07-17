package testPiece;

import Model.Board;
import Pieces.Piece;
import Exception.NotOnBoardException;

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
    public void testCastle() throws NotOnBoardException {
        Piece bishop = board.get(0, 5).getOccupant();
        Assert.assertFalse(king.isLegal(board.get(0, 4), board.get(0, 2), board));
        board.setMove(board.get(1, 4), board.get(3, 4));
        board.setMove(board.get(6, 1), board.get(5, 1));
        board.setMove(board.get(0, 6), board.get(2, 5));
        board.setMove(board.get(6, 2), board.get(5, 2));
        board.setMove(board.get(0, 5), board.get(5, 0));
        Assert.assertTrue(king.isLegal(board.get(0, 4), board.get(0, 6), board));
        board.setMove(board.get(7, 2), board.get(5, 0));
        Assert.assertFalse(king.isLegal(board.get(0, 4), board.get(0, 6), board));
//        System.out.println(board.toString());
        board.setMove(board.get(0, 7), board.get(0, 6));
        board.setMove(board.get(5, 0), board.get(6, 1));
        System.out.println(board.toString());
        Assert.assertFalse(king.isLegal(board.get(0, 4), board.get(0, 6), board));
    }

}
