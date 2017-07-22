import testModel.testBoard;
import testPiece.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)

@Suite.SuiteClasses({
        testBoard.class,
        testQueen.class,
        testRook.class,
        testKing.class,
        testPawn.class
})

public class testAll {

}