package Player;

import Controller.View;
import Model.Board;
import Model.Colour;
import Model.Location;

public class HumanPlayer implements Player {

    private String name;
    private Colour colour;
    private View view;

    public HumanPlayer(String name, Colour colour, View view) {
        this.name = name;
        this.colour = colour;
        this.view = view;
    }

    @Override
    public Location[] getMove(Board board) {
        Location[] result = new Location[2];
        String[] move = view.askMove(name).split(" ");
        result[0] = board.notationToLocation(move[0]);
        result[1] = board.notationToLocation(move[1]);
        return result;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Colour getColour() {
        return colour;
    }
}
