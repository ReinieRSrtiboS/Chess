package Pieces;

import Model.Colour;

public class Pawn extends Piece {

    private Boolean firstMove;

    public Pawn(Colour colour) {
        super(colour);
        firstMove = true;
    }

//    @Override
//    public Boolean isLegal(int newX, int newY) {
//        return (newX == x + 1 || (firstMove && newX == x + 2));
//    }
}
