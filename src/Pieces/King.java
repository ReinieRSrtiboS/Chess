package Pieces;

import Model.Colour;

public class King extends Piece {

    private Boolean castle;

    public King(Colour colour) {
        super(colour);
        castle = true;
    }

//    @Override
//    public Boolean isLegal(int newX, int newY) {
//        return (-1 <= newX - x || newX - x <= 1) && (-1 <= newY - y || newY - y <= 1);
//    }
}
