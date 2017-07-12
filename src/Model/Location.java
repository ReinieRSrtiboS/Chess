package Model;

import Pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private int x;
    private int y;
    private Piece occupied;
    private List<Piece> attacked = new ArrayList<>();
    private Colour colour;

    public Location(int x, int y, Piece occupied, List<Piece> attacked, Colour colour) {
        this.x = x;
        this.y = y;
        this.occupied = occupied;
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

    public Piece getOccupied() {
        return occupied;
    }

    public void setOccupied(Piece occupied) {
        this.occupied = occupied;
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
}
