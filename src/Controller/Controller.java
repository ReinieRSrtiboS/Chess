package Controller;

import Exception.NoPieceException;
import Exception.NotOnBoardException;
import Model.Board;
import Model.Colour;
import Model.Location;
import Player.HumanPlayer;
import Player.Player;

public class Controller {

    private static Board board = new Board();
    private static Player[] players = new Player[2];
    private static Player turn;
    private static View view = new View(false);

    public static void main(String[] args) throws NotOnBoardException, NoPieceException {
        // TODO pat
        Boolean checkmate = false;
        players[0] = new HumanPlayer("white", Colour.WHITE, view);
        players[1] = new HumanPlayer("black", Colour.BLACK, view);
        turn = players[0];

        while(!checkmate) {
            view.printBoard(board);
            Location[] move = turn.getMove(board);
            if (board.isLegalMove(move[0], move[1])) {
                board.moveLogistics(move[0], move[1]);
            }
            if (board.check()) {
                checkmate = board.checkMate(turn.getColour());
            }
            nextTurn();
        }
    }

    private static void nextTurn() {
        if (turn == players[0]) {
            turn = players[1];
        } else {
            turn = players[0];
        }
    }
}
