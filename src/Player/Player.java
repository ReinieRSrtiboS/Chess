package Player;

import Model.Board;
import Model.Colour;
import Model.Location;

public interface Player {

    Location[] getMove(Board board);
    String getName();
    Colour getColour();

}
