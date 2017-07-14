package testPiece;

import Model.Board;
import Model.Colour;
import Pieces.Rook;
import org.junit.Before;

public class testRook {

    private Rook rook;
    private Board board;

    @Before
    public void before() {
        rook = new Rook(Colour.WHITE);
        board = new Board();
    }

//    @Test
//    public void testIsAttacking() {
//        Assert.assertTrue(rook.isAttacking())
//    }
}
