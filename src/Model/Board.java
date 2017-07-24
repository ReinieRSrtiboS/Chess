package Model;

import Exception.NotOnBoardException;
import Exception.NoPieceException;
import Pieces.*;

import java.util.*;

public class Board {

    private Location[][] board = new Location[8][8];
    public List<Piece> pieces = new ArrayList<>();
    public List<String> moves = new ArrayList<>();
    private Boolean check;
    private List<Character> letter = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'));

    public Board() {
        check = false;
        Pawn aWhite = new Pawn(Colour.WHITE, "aWhite");            pieces.add(aWhite);
        Pawn bWhite = new Pawn(Colour.WHITE, "bWhite");            pieces.add(bWhite);
        Pawn cWhite = new Pawn(Colour.WHITE, "cWhite");            pieces.add(cWhite);
        Pawn dWhite = new Pawn(Colour.WHITE, "dWhite");            pieces.add(dWhite);
        Pawn eWhite = new Pawn(Colour.WHITE, "eWhite");            pieces.add(eWhite);
        Pawn fWhite = new Pawn(Colour.WHITE, "fWhite");            pieces.add(fWhite);
        Pawn gWhite = new Pawn(Colour.WHITE, "gWhite");            pieces.add(gWhite);
        Pawn hWhite = new Pawn(Colour.WHITE, "hWhite");            pieces.add(hWhite);
        Pawn aBlack = new Pawn(Colour.BLACK, "aBlack");            pieces.add(aBlack);
        Pawn bBlack = new Pawn(Colour.BLACK, "bBlack");            pieces.add(bBlack);
        Pawn cBlack = new Pawn(Colour.BLACK, "cBlack");            pieces.add(cBlack);
        Pawn dBlack = new Pawn(Colour.BLACK, "dBlack");            pieces.add(dBlack);
        Pawn eBlack = new Pawn(Colour.BLACK, "eBlack");            pieces.add(eBlack);
        Pawn fBlack = new Pawn(Colour.BLACK, "fBlack");            pieces.add(fBlack);
        Pawn gBlack = new Pawn(Colour.BLACK, "gBlack");            pieces.add(gBlack);
        Pawn hBlack = new Pawn(Colour.BLACK, "hBlack");            pieces.add(hBlack);
        Rook rook1 = new Rook(Colour.WHITE, "rook1");              pieces.add(rook1);
        Rook rook2 = new Rook(Colour.WHITE, "rook2");              pieces.add(rook2);
        Rook rook3 = new Rook(Colour.BLACK, "rook3");              pieces.add(rook3);
        Rook rook4 = new Rook(Colour.BLACK, "rook4");              pieces.add(rook4);
        Knight knight4 = new Knight(Colour.BLACK, "knight4");      pieces.add(knight4);
        Knight knight3 = new Knight(Colour.BLACK, "knight3");      pieces.add(knight3);
        Knight knight2 = new Knight(Colour.WHITE, "knight2");      pieces.add(knight2);
        Knight knight1 = new Knight(Colour.WHITE, "knight1");      pieces.add(knight1);
        Bishop lightWhite = new Bishop(Colour.WHITE, "lightWhite");pieces.add(lightWhite);
        Bishop darkWhite = new Bishop(Colour.WHITE, "darkWhite");  pieces.add(darkWhite);
        Bishop lightBlack = new Bishop(Colour.BLACK, "lightBlack");pieces.add(lightBlack);
        Bishop darkBlack = new Bishop(Colour.BLACK, "darkBlack");  pieces.add(darkBlack);
        Queen blackQueen = new Queen(Colour.BLACK, "blackQueen");  pieces.add(blackQueen);
        Queen whiteQueen = new Queen(Colour.WHITE, "whiteQueen");  pieces.add(whiteQueen);
        King whiteKing = new King(Colour.WHITE, "whiteKing");      pieces.add(whiteKing);
        King blackKing = new King(Colour.BLACK, "blackKing");      pieces.add(blackKing);
        board = new Location[][]{{new Location(0, 0, rook1, new ArrayList<>(), Colour.BLACK)
                                , new Location(1, 0, knight1, new ArrayList<>(Collections.singletonList(rook1)), Colour.WHITE)
                                , new Location(2, 0, darkWhite, new ArrayList<>(Collections.singleton(whiteQueen)), Colour.BLACK)
                                , new Location(3, 0, whiteQueen, new ArrayList<>(Collections.singleton(whiteKing)), Colour.WHITE)
                                , new Location(4, 0, whiteKing, new ArrayList<>(Collections.singleton(whiteQueen)), Colour.BLACK)
                                , new Location(5, 0, lightWhite, new ArrayList<>(Collections.singleton(whiteKing)), Colour.WHITE)
                                , new Location(6, 0, knight2, new ArrayList<>(Collections.singleton(rook2)), Colour.BLACK)
                                , new Location(7, 0, rook2, new ArrayList<>(), Colour.WHITE)}
                                ,{new Location(0, 1, aWhite, new ArrayList<>(Collections.singleton(rook1)), Colour.WHITE)
                                , new Location(1, 1, bWhite, new ArrayList<>(Collections.singleton(darkWhite)), Colour.BLACK)
                                , new Location(2, 1, cWhite, new ArrayList<>(Collections.singleton(whiteQueen)), Colour.WHITE)
                                , new Location(3, 1, dWhite, new ArrayList<>(Arrays.asList(whiteKing, whiteQueen, darkWhite, knight1)), Colour.BLACK)
                                , new Location(4, 1, eWhite, new ArrayList<>(Arrays.asList(whiteKing, whiteQueen, lightWhite, knight2)), Colour.WHITE)
                                , new Location(5, 1, fWhite, new ArrayList<>(Collections.singleton(whiteKing)), Colour.BLACK)
                                , new Location(6, 1, gWhite, new ArrayList<>(Collections.singleton(lightWhite)), Colour.WHITE)
                                , new Location(7, 1, hWhite, new ArrayList<>(Collections.singleton(rook2)), Colour.BLACK)}
                                ,{new Location(0, 2, null, new ArrayList<>(Arrays.asList(bWhite, knight1)), Colour.BLACK)
                                , new Location(1, 2, null, new ArrayList<>(Arrays.asList(aWhite, cWhite)), Colour.WHITE)
                                , new Location(2, 2, null, new ArrayList<>(Arrays.asList(bWhite, dWhite, knight1)), Colour.BLACK)
                                , new Location(3, 2, null, new ArrayList<>(Arrays.asList(cWhite, eWhite)), Colour.WHITE)
                                , new Location(4, 2, null, new ArrayList<>(Arrays.asList(dWhite, fWhite)), Colour.BLACK)
                                , new Location(5, 2, null, new ArrayList<>(Arrays.asList(eWhite, gWhite, knight2)), Colour.WHITE)
                                , new Location(6, 2, null, new ArrayList<>(Arrays.asList(fWhite, hWhite)), Colour.BLACK)
                                , new Location(7, 2, null, new ArrayList<>(Arrays.asList(gWhite, knight2)), Colour.WHITE)}
                                ,{new Location(0, 3, null, new ArrayList<>(), Colour.WHITE)
                                , new Location(1, 3, null, new ArrayList<>(), Colour.BLACK)
                                , new Location(2, 3, null, new ArrayList<>(), Colour.WHITE)
                                , new Location(3, 3, null, new ArrayList<>(), Colour.BLACK)
                                , new Location(4, 3, null, new ArrayList<>(), Colour.WHITE)
                                , new Location(5, 3, null, new ArrayList<>(), Colour.BLACK)
                                , new Location(6, 3, null, new ArrayList<>(), Colour.WHITE)
                                , new Location(7, 3, null, new ArrayList<>(), Colour.BLACK)}
                                ,{new Location(0, 4, null, new ArrayList<>(), Colour.BLACK)
                                , new Location(1 ,4, null, new ArrayList<>(), Colour.WHITE)
                                , new Location(2, 4, null, new ArrayList<>(), Colour.BLACK)
                                , new Location(3, 4, null, new ArrayList<>(), Colour.WHITE)
                                , new Location(4 ,4, null, new ArrayList<>(), Colour.BLACK)
                                , new Location(5, 4, null, new ArrayList<>(), Colour.WHITE)
                                , new Location(6, 4, null, new ArrayList<>(), Colour.BLACK)
                                , new Location(7, 4, null, new ArrayList<>(), Colour.WHITE)}
                                ,{new Location(0, 5, null, new ArrayList<>(Arrays.asList(bBlack, knight3)), Colour.WHITE)
                                , new Location(1, 5, null, new ArrayList<>(Arrays.asList(aBlack, cBlack)), Colour.BLACK)
                                , new Location(2, 5, null, new ArrayList<>(Arrays.asList(bBlack, dBlack, knight3)), Colour.WHITE)
                                , new Location(3, 5, null, new ArrayList<>(Arrays.asList(cBlack, eBlack)), Colour.BLACK)
                                , new Location(4, 5, null, new ArrayList<>(Arrays.asList(dBlack, fBlack)), Colour.WHITE)
                                , new Location(5, 5, null, new ArrayList<>(Arrays.asList(eBlack, gBlack, knight4)), Colour.BLACK)
                                , new Location(7, 5, null, new ArrayList<>(Arrays.asList(fBlack, hBlack)), Colour.WHITE)
                                , new Location(7, 5, null, new ArrayList<>(Arrays.asList(gBlack, knight4)), Colour.BLACK)}
                                ,{new Location(0, 6, aBlack, new ArrayList<>(Collections.singletonList(rook3)), Colour.BLACK)
                                , new Location(1 ,6, bBlack, new ArrayList<>(Collections.singletonList(lightBlack)), Colour.WHITE)
                                , new Location(2, 6, cBlack, new ArrayList<>(Collections.singletonList(blackQueen)), Colour.BLACK)
                                , new Location(3, 6, dBlack, new ArrayList<>(Arrays.asList(blackKing, blackQueen, lightBlack, knight3)), Colour.WHITE)
                                , new Location(4 ,6, eBlack, new ArrayList<>(Arrays.asList(blackKing, blackQueen, darkBlack, knight4)), Colour.BLACK)
                                , new Location(5, 6, fBlack, new ArrayList<>(Collections.singletonList(blackKing)), Colour.WHITE)
                                , new Location(6, 6, gBlack, new ArrayList<>(Collections.singletonList(darkBlack)), Colour.BLACK)
                                , new Location(7, 6, hBlack, new ArrayList<>(Collections.singletonList(rook4)), Colour.WHITE)}
                                ,{new Location(0, 7, rook1, new ArrayList<>(), Colour.WHITE)
                                , new Location(1, 7, knight3, new ArrayList<>(Collections.singleton(rook3)), Colour.BLACK)
                                , new Location(2, 7, lightBlack, new ArrayList<>(Collections.singleton(blackQueen)), Colour.WHITE)
                                , new Location(3, 7, blackQueen, new ArrayList<>(Collections.singleton(blackKing)), Colour.BLACK)
                                , new Location(4, 7, blackKing, new ArrayList<>(Collections.singleton(blackQueen)), Colour.WHITE)
                                , new Location(5, 7, darkBlack, new ArrayList<>(Collections.singleton(blackKing)), Colour.BLACK)
                                , new Location(6, 7, knight4, new ArrayList<>(Collections.singleton(rook4)), Colour.WHITE)
                                , new Location(7, 7, rook4, new ArrayList<>(), Colour.BLACK)}};
    }

    private Board(Board b) {
        this.pieces = b.pieces;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Location old = b.board[i][j];
                this.board[i][j] = new Location(old.getY(), old.getX(), old.getOccupant(), old.getAttackers(), old.getColour());
            }
        }
        this.moves = b.moves;
        this.check = b.getCheck();
    }

    public Board copy() {
        return new Board(this);
    }

    public Location get(int x, int y) {
        return board[x][y];
    }

    public Boolean getCheck() {
        return check;
    }

    public void moveLogistics(Location oldLocation, Location newLocation) throws NotOnBoardException, NoPieceException {
        if (oldLocation.getOccupant() == null) {
            throw new NoPieceException(oldLocation.getNotation());
        }
        Piece piece = oldLocation.getOccupant();

        // Remove set piece from every location it attacks
        for (Location location : piece.isAttacking(oldLocation, this)) {
            location.removeAttacker(piece);
        }

        // Remove the pieces that attack the new location to update later
        Map<Piece, List<Location>> toRemove = new HashMap<>();
        List<Piece> attackers = new ArrayList<>();
        for (Piece piece1 : newLocation.getAttackers()) {
            attackers.add(piece1);
            //TODO optimise
            for (Location location : piece1.isAttacking(piece1.getLocation(this), this)) {
                if (toRemove.get(piece1) != null) {
                    List<Location> locations = toRemove.get(piece1);
                    locations.add(location);
                    toRemove.put(piece1, locations);
                } else {
                    toRemove.put(piece1, new ArrayList<>(Collections.singleton(location)));
                }
            }
        }
        for (Piece piece1 : toRemove.keySet()) {
            for (Location location : toRemove.get(piece1)) {
                location.removeAttacker(piece1);
            }
        }

        if (piece instanceof Pawn) {
            Pawn pawn = (Pawn) piece;
            moves.add(newLocation.getNotation());
            pawn.setFirstMove(false);
            if (oldLocation.getY() != newLocation.getY() && newLocation.getOccupant() == null) {
                enPassant(oldLocation, newLocation, pawn);
            } else {
                setMove(oldLocation, newLocation, piece);
            }
        } else if (piece instanceof Rook) {
            moves.add("R" + newLocation.getNotation());
            Rook rook = (Rook) piece;
            rook.setCastle(false);
            setMove(oldLocation, newLocation, piece);
        } else if (piece instanceof King) {
            King king = (King) piece;
            moves.add("K" + newLocation.getNotation());
            if (king.getCastle()) {
                castle(oldLocation, newLocation, king);
            } else {
                setMove(oldLocation, newLocation, piece);
            }
            king.setCastle(false);
        } else if (piece instanceof Queen){
            moves.add("Q" + newLocation.getNotation());
            setMove(oldLocation, newLocation, piece);
        } else if (piece instanceof Knight){
            moves.add("N" + newLocation.getNotation());
            setMove(oldLocation, newLocation, piece);
        } else if (piece instanceof Bishop){
            moves.add("B" + newLocation.getNotation());
            setMove(oldLocation, newLocation, piece);
        }

        // update the locations the piece now attacks
        for (Location location : piece.isAttacking(newLocation, this)) {
            location.addAttacker(piece);
        }
        //update the attackers from the old location
        for (Piece piece1 : oldLocation.getAttackers()) {
            //TODO optimise
            for (Location location : piece1.isAttacking(piece1.getLocation(this), this)) {
                if (!location.getAttackers().contains(piece1)) {
                    location.addAttacker(piece1);
                }
            }
        }
        //update the attackers from the new location
        for (Piece piece1 : attackers) {
            //TODO optimise
            for (Location location : piece1.isAttacking(piece1.getLocation(this), this)) {
                location.addAttacker(piece1);
            }
        }
        check = check();
        if (check) {
            moves.set(moves.size() - 1, moves.get(moves.size() - 1) + "+");
        }
    }

    private void castle(Location oldLocation, Location newLocation, King king) {
        if (king.getColour() == Colour.WHITE) {
            if (newLocation.getX() == 0 && newLocation.getY() == 2) {
                Rook rook = (Rook) board[0][0].getOccupant();

                for (Location location : rook.isAttacking(board[0][0], this)) {
                    location.removeAttacker(rook);
                }

                setMove(board[0][0], board[0][3], rook);
                setMove(oldLocation, newLocation, king);
                moves.set(moves.size() - 1, "O-O-O");

            } else if (newLocation.getX() == 0 && newLocation.getY() == 6) {
                Rook rook = (Rook) board[0][7].getOccupant();

                for (Location location : rook.isAttacking(board[0][7], this)) {
                    location.removeAttacker(rook);
                }

                setMove(board[0][7], board[0][5], rook);
                setMove(oldLocation, newLocation, king);
                moves.set(moves.size() - 1, "O-O");

            } else {
                setMove(oldLocation, newLocation, king);
            }
        } else {
            if (newLocation.getX() == 7 && newLocation.getY() == 2) {
                Rook rook = (Rook) board[7][0].getOccupant();

                for (Location location : rook.isAttacking(board[7][0], this)) {
                    location.removeAttacker(rook);
                }

                setMove(board[7][0], board[7][3], rook);
                setMove(oldLocation, newLocation, king);
                moves.set(moves.size() - 1, "O-O-O");

            } else if (newLocation.getX() == 7 && newLocation.getY() == 6) {
                Rook rook = (Rook) board[7][7].getOccupant();

                for (Location location : rook.isAttacking(board[7][7], this)) {
                    location.removeAttacker(rook);
                }

                setMove(board[7][7], board[7][5], rook);
                setMove(oldLocation, newLocation, king);
                moves.set(moves.size() - 1, "O-O");

            } else {
                setMove(oldLocation, newLocation, king);
            }
        }
        king.setCastle(false);
    }

    private void enPassant(Location oldLocation, Location newLocation, Piece piece) throws NotOnBoardException {
        Location deadPawnLocation = board[oldLocation.getX()][newLocation.getY()];
        Piece deadPawn = deadPawnLocation.getOccupant();
        for (Location location : deadPawn.isAttacking(newLocation, this)) {
            location.removeAttacker(deadPawn);
        }
        pieces.remove(deadPawn);
        deadPawn.died();
        deadPawnLocation.setOccupant(null);
        setMove(oldLocation, newLocation, piece);
        for (Piece piece1 : deadPawnLocation.getAttackers()) {
            for (Location location : piece1.isAttacking(piece1.getLocation(this), this)) {
                location.addAttacker(piece1);
            }
        }

    }

    private void setMove(Location oldLocation, Location newLocation, Piece piece) {
        if (newLocation.getOccupant() == null) {
            newLocation.setOccupant(piece);
            oldLocation.setOccupant(null);
        } else {
            Piece deadPiece = newLocation.getOccupant();
            for (Location location : deadPiece.isAttacking(newLocation, this)) {
                location.removeAttacker(deadPiece);
            }
            pieces.remove(deadPiece);
            deadPiece.died();
            newLocation.setOccupant(piece);
            oldLocation.setOccupant(null);
            String move;
            if (piece instanceof Pawn) {
                move = oldLocation.getNotation().charAt(0) + "x" + newLocation.getNotation();
            } else {
                move = moves.get(moves.size() - 1).charAt(0) + "x" + newLocation.getNotation();
            }
            moves.set(moves.size() - 1, move);
        }
    }

    public Boolean isLegalMove(Location oldLocation, Location newLocation) throws NotOnBoardException, NoPieceException {
        if (oldLocation.getOccupant() == null) {
            throw new NoPieceException(oldLocation.getNotation());
        }
        Piece piece = oldLocation.getOccupant();
        Board copy = copy();
        if (piece.isLegal(oldLocation, newLocation, this)) {
            copy.moveLogistics(copy.get(oldLocation.getX(), oldLocation.getY()), copy.get(newLocation.getX(), newLocation.getY()));
            return !copy.getCheck();
        } else {
            return false;
        }
    }

    public Location notationToLocation(String notation) {
        int y = letter.indexOf(notation.charAt(0));
        int x = Character.getNumericValue(notation.charAt(1)) - 1;
        return board[x][y];
    }

    public Boolean checkMate(Colour turn) throws NoPieceException, NotOnBoardException{
        Boolean checkmate = true;
        for (Piece piece : pieces) {
            if (piece.getColour() != turn) {
                Location pieceLocation = piece.getLocation(this);
                for (Location location : piece.legalMoves(pieceLocation, this)) {
                    checkmate = checkmate && !isLegalMove(pieceLocation, location);
                }
            }
        }
        return checkmate;
    }

    public Boolean check() {
        int done = 0;
        for (int i = 0; i < 8; i++) {
            for (Location location : board[i]) {
                if (location.getOccupant() instanceof King) {
                    for (Piece attacker : location.getAttackers()) {
                        if (attacker.getColour() != location.getOccupant().getColour()) {
                            return true;
                        }
                    }
                    done++;
                }
                if (done == 2) {
                    break;
                }
            }
        }
        return false;
    }

    public Boolean inBorder(int x, int y) {
        return x < 8 && x >= 0 & y < 8 && y >= 0;
    }

    public boolean equals(Board board) {
        boolean result = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result = result && (this.board[i][j].getOccupant() == board.board[i][j].getOccupant());
            }
        }
        return result;
    }

    public String getNotation() {
        String result = "";
        for (int i = 0; i < moves.size(); i++) {
            if (i % 2 == 0) {
                result = result + ((i+2)/2) + ". " + moves.get(i);
            } else {
                result = result + " " + moves.get(i) + "\n";
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "||-a-||-b-||-c-||-d-||-e-||-f-||-g-||-h-||\n";
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getOccupant() == null) {
                    result = result + "||   ";
                } else if (board[i][j].getOccupant() instanceof Pawn) {
                    result = result + "|| P ";
                } else if (board[i][j].getOccupant() instanceof Rook) {
                    result = result + "|| R ";
                } else if (board[i][j].getOccupant() instanceof Knight) {
                    result = result + "|| N ";
                } else if (board[i][j].getOccupant() instanceof Bishop) {
                    result = result + "|| B ";
                } else if (board[i][j].getOccupant() instanceof Queen) {
                    result = result + "|| Q ";
                } else {
                    result = result + "|| K ";
                }
            }
            result = result + "||\n" + (i+1) + " ---||---||---||---||---||---||---||---||\n";
        }
        return result;
    }
}