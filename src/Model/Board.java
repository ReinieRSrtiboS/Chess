package Model;

import Pieces.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    public Location[][] board;
    public List<Piece> pieces = new ArrayList<>();

    public Board() {
        Pawn aWhite = new Pawn(Colour.WHITE);           pieces.add(aWhite);
        Pawn bWhite = new Pawn(Colour.WHITE);           pieces.add(bWhite);
        Pawn cWhite = new Pawn(Colour.WHITE);           pieces.add(cWhite);
        Pawn dWhite = new Pawn(Colour.WHITE);           pieces.add(dWhite);
        Pawn eWhite = new Pawn(Colour.WHITE);           pieces.add(eWhite);
        Pawn fWhite = new Pawn(Colour.WHITE);           pieces.add(fWhite);
        Pawn gWhite = new Pawn(Colour.WHITE);           pieces.add(gWhite);
        Pawn hWhite = new Pawn(Colour.WHITE);           pieces.add(hWhite);
        Pawn aBlack = new Pawn(Colour.BLACK);           pieces.add(aBlack);
        Pawn bBlack = new Pawn(Colour.BLACK);           pieces.add(bBlack);
        Pawn cBlack = new Pawn(Colour.BLACK);           pieces.add(cBlack);
        Pawn dBlack = new Pawn(Colour.BLACK);           pieces.add(dBlack);
        Pawn eBlack = new Pawn(Colour.BLACK);           pieces.add(eBlack);
        Pawn fBlack = new Pawn(Colour.BLACK);           pieces.add(fBlack);
        Pawn gBlack = new Pawn(Colour.BLACK);           pieces.add(gBlack);
        Pawn hBlack = new Pawn(Colour.BLACK);           pieces.add(hBlack);
        Rook rook1 = new Rook(Colour.WHITE);            pieces.add(rook1);
        Rook rook2 = new Rook(Colour.WHITE);            pieces.add(rook2);
        Rook rook3 = new Rook(Colour.BLACK);            pieces.add(rook3);
        Rook rook4 = new Rook(Colour.BLACK);            pieces.add(rook4);
        Knight knight4 = new Knight(Colour.BLACK);      pieces.add(knight4);
        Knight knight3 = new Knight(Colour.BLACK);      pieces.add(knight3);
        Knight knight2 = new Knight(Colour.WHITE);      pieces.add(knight2);
        Knight knight1 = new Knight(Colour.WHITE);      pieces.add(knight1);
        Bishop lightWhite = new Bishop(Colour.WHITE);   pieces.add(lightWhite);
        Bishop darkWhite = new Bishop(Colour.WHITE);    pieces.add(darkWhite);
        Bishop lightBlack = new Bishop(Colour.BLACK);   pieces.add(lightBlack);
        Bishop darkBlack = new Bishop(Colour.BLACK);    pieces.add(darkBlack);
        Queen blackQueen = new Queen(Colour.BLACK);     pieces.add(blackQueen);
        Queen whiteQueen = new Queen(Colour.WHITE);     pieces.add(whiteQueen);
        King whiteKing = new King(Colour.WHITE);        pieces.add(whiteKing);
        King blackKing = new King(Colour.BLACK);        pieces.add(blackKing);
        board = new Location[][]{{new Location(1, 1, rook1, null, Colour.BLACK)
                                , new Location(2, 1, knight1, new ArrayList<>(Collections.singletonList(rook1)), Colour.WHITE)
                                , new Location(3, 1, darkWhite, new ArrayList<>(Collections.singleton(whiteQueen)), Colour.BLACK)
                                , new Location(4, 1, whiteQueen, new ArrayList<>(Collections.singleton(whiteKing)), Colour.WHITE)
                                , new Location(5, 1, whiteKing, new ArrayList<>(Collections.singleton(whiteQueen)), Colour.BLACK)
                                , new Location(6, 1, lightWhite, new ArrayList<>(Collections.singleton(whiteKing)), Colour.WHITE)
                                , new Location(7, 1, knight2, new ArrayList<>(Collections.singleton(rook2)), Colour.BLACK)
                                , new Location(8, 1, rook2, null, Colour.WHITE)}
                                ,{new Location(1, 2, aWhite, new ArrayList<>(Collections.singleton(rook1)), Colour.WHITE)
                                , new Location(2, 2, bWhite, new ArrayList<>(Collections.singleton(darkWhite)), Colour.BLACK)
                                , new Location(3, 2, cWhite, new ArrayList<>(Collections.singleton(whiteQueen)), Colour.WHITE)
                                , new Location(4, 2, dWhite, new ArrayList<>(Arrays.asList(whiteKing, whiteQueen, darkWhite, knight1)), Colour.BLACK)
                                , new Location(5, 2, eWhite, new ArrayList<>(Arrays.asList(whiteKing, whiteQueen, lightWhite, knight2)), Colour.WHITE)
                                , new Location(6, 2, fWhite, new ArrayList<>(Collections.singleton(whiteKing)), Colour.BLACK)
                                , new Location(7, 2, gWhite, new ArrayList<>(Collections.singleton(lightWhite)), Colour.WHITE)
                                , new Location(8, 2, hWhite, new ArrayList<>(Collections.singleton(rook2)), Colour.BLACK)}
                                ,{new Location(1, 3, null, new ArrayList<>(Arrays.asList(bWhite, knight1)), Colour.BLACK)
                                , new Location(2, 3, null, new ArrayList<>(Arrays.asList(aWhite, cWhite)), Colour.WHITE)
                                , new Location(3, 3, null, new ArrayList<>(Arrays.asList(bWhite, dWhite, knight1)), Colour.BLACK)
                                , new Location(4, 3, null, new ArrayList<>(Arrays.asList(cWhite, eWhite)), Colour.WHITE)
                                , new Location(5, 3, null, new ArrayList<>(Arrays.asList(dWhite, fWhite)), Colour.BLACK)
                                , new Location(6, 3, null, new ArrayList<>(Arrays.asList(eWhite, gWhite, knight2)), Colour.WHITE)
                                , new Location(7, 3, null, new ArrayList<>(Arrays.asList(fWhite, hWhite)), Colour.BLACK)
                                , new Location(8, 3, null, new ArrayList<>(Arrays.asList(gWhite, knight2)), Colour.WHITE)}
                                ,{new Location(1, 4, null, null, Colour.WHITE)
                                , new Location(2, 4, null, null, Colour.BLACK)
                                , new Location(3, 4, null, null, Colour.WHITE)
                                , new Location(4, 4, null, null, Colour.BLACK)
                                , new Location(5, 4, null, null, Colour.WHITE)
                                , new Location(6, 4, null, null, Colour.BLACK)
                                , new Location(7, 4, null, null, Colour.WHITE)
                                , new Location(8, 4, null, null, Colour.BLACK)}
                                ,{new Location(1, 5, null, null, Colour.BLACK)
                                , new Location(2 ,5, null, null, Colour.WHITE)
                                , new Location(3, 5, null, null, Colour.BLACK)
                                , new Location(4, 5, null, null, Colour.WHITE)
                                , new Location(5 ,5, null, null, Colour.BLACK)
                                , new Location(6, 5, null, null, Colour.WHITE)
                                , new Location(7, 5, null, null, Colour.BLACK)
                                , new Location(8, 5, null, null, Colour.WHITE)}
                                ,{new Location(1, 6, null, new ArrayList<>(Arrays.asList(bBlack, knight3)), Colour.WHITE)
                                , new Location(2, 6, null, new ArrayList<>(Arrays.asList(aBlack, cBlack)), Colour.BLACK)
                                , new Location(3, 6, null, new ArrayList<>(Arrays.asList(bBlack, dBlack, knight3)), Colour.WHITE)
                                , new Location(4, 6, null, new ArrayList<>(Arrays.asList(cBlack, eBlack)), Colour.BLACK)
                                , new Location(5, 6, null, new ArrayList<>(Arrays.asList(dBlack, fBlack)), Colour.WHITE)
                                , new Location(6, 6, null, new ArrayList<>(Arrays.asList(eBlack, gBlack, knight4)), Colour.BLACK)
                                , new Location(7, 6, null, new ArrayList<>(Arrays.asList(fBlack, hBlack)), Colour.WHITE)
                                , new Location(8, 6, null, new ArrayList<>(Arrays.asList(gBlack, knight4)), Colour.BLACK)}
                                ,{new Location(1, 7, aBlack, new ArrayList<>(Collections.singletonList(rook3)), Colour.BLACK)
                                , new Location(2 ,7, bBlack, new ArrayList<>(Collections.singletonList(lightBlack)), Colour.WHITE)
                                , new Location(3, 7, cBlack, new ArrayList<>(Collections.singletonList(blackQueen)), Colour.BLACK)
                                , new Location(4, 7, dBlack, new ArrayList<>(Arrays.asList(blackKing, blackQueen, lightBlack, knight3)), Colour.WHITE)
                                , new Location(5 ,7, eBlack, new ArrayList<>(Arrays.asList(blackKing, blackQueen, darkBlack, knight4)), Colour.BLACK)
                                , new Location(6, 7, fBlack, new ArrayList<>(Collections.singletonList(blackKing)), Colour.WHITE)
                                , new Location(7, 7, gBlack, new ArrayList<>(Collections.singletonList(darkBlack)), Colour.BLACK)
                                , new Location(8, 7, hBlack, new ArrayList<>(Collections.singletonList(rook4)), Colour.WHITE)}
                                ,{new Location(1, 8, rook1, null, Colour.WHITE)
                                , new Location(2, 8, knight3, new ArrayList<>(Collections.singleton(rook3)), Colour.BLACK)
                                , new Location(3, 8, lightBlack, new ArrayList<>(Collections.singleton(blackQueen)), Colour.WHITE)
                                , new Location(4, 8, blackQueen, new ArrayList<>(Collections.singleton(blackKing)), Colour.BLACK)
                                , new Location(5, 8, blackKing, new ArrayList<>(Collections.singleton(blackQueen)), Colour.WHITE)
                                , new Location(6, 8, darkBlack, new ArrayList<>(Collections.singleton(blackKing)), Colour.BLACK)
                                , new Location(7, 8, knight4, new ArrayList<>(Collections.singleton(rook4)), Colour.WHITE)
                                , new Location(8, 8, rook4, null, Colour.BLACK)}};
    }

    public Board(List<Piece> pieces, Location[][] board) {
        this.pieces = pieces;
        for(int i = 0; i < 8; i++) {
            this.board[i] = board[i].clone();
        }
    }

    public Board copy() {
        return new Board(pieces, board);
    }

    public void setMove(Piece piece, Location oldLocation, Location newLocation) {
        // Remove set piece from every location it attacks
        for (Location location : piece.isAttacking(oldLocation, this)) {
            location.removeAttacker(piece);
        }
        // Remove the pieces that attack the new location to update later
        for (Piece piece1 : newLocation.getAttackers()) {
            //TODO optimise
            for (Location location : piece1.isAttacking(newLocation, this)) {
                location.removeAttacker(piece1);
            }
        }

        if (newLocation.getOccupied() == null) {
            // set the piece to the new location
            newLocation.setOccupied(piece);
            oldLocation.setOccupied(null);
        } else {
            // Remove the dead piece from the game
            Piece deadPiece = newLocation.getOccupied();
            for (Location location : deadPiece.isAttacking(oldLocation, this)) {
                location.removeAttacker(piece);
            }
            pieces.remove(deadPiece);
            deadPiece.isDead();
            newLocation.setOccupied(piece);
            oldLocation.setOccupied(null);
        }
        // update the locations the piece now attacks
        for (Location location : piece.isAttacking(newLocation, this)) {
            location.addAttacker(piece);
        }
        //update the attackers from the old location
        for (Piece piece1 : oldLocation.getAttackers()) {
            //TODO optimise
            for (Location location : piece1.isAttacking(oldLocation, this)) {
                if (!location.getAttackers().contains(piece1)) {
                    location.addAttacker(piece1);
                }
            }
        }
        //update the attackers from the new location
        for (Piece piece1 : newLocation.getAttackers()) {
            //TODO optimise
            for (Location location : piece1.isAttacking(newLocation, this)) {
                location.addAttacker(piece1);
            }
        }
    }

    public Boolean isLegalMove(Piece piece, Location oldLocation, Location newLocation) {
        return false; //TODO
    }

    public Boolean inBorder(int x, int y) {
        return x < 9 && x > 0 & y < 9 && y > 0;
    }
}