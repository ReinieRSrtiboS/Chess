package Model;

import Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private int x;
    private int y;
    private Piece occupant;
    private List<Piece> attacked = new ArrayList<>();
    private Colour colour;
    private String[] notation = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};

    public Location(int y, int x, Piece occupant, List<Piece> attacked, Colour colour) {
        this.x = x;
        this.y = y;
        this.occupant = occupant;
        this.attacked = attacked;
        this.colour = colour;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Piece getOccupant() {
        return occupant;
    }

    public void setOccupant(Piece occupied) {
        this.occupant = occupied;
    }

    public List<Piece> getAttackers() {
        return attacked;
    }

    public void removeAttacker(Piece attacker) {
        attacked.remove(attacker);
    }

    public void addAttacker(Piece attacker) {
        attacked.add(attacker);
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public String getNotation() {
        return notation[y] + (x + 1);
    }
}
