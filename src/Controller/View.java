package Controller;

import Model.Board;

import java.util.Scanner;

public class View {

    private Boolean GUI;
    private Scanner input;

    public View(Boolean GUI) {
        this.GUI = GUI;
        if (!GUI) {
            input = new Scanner(System.in);
        }
    }

    public void printBoard(Board board) {
        if (GUI) {
            //TODO
        } else {
            System.out.println(board.toString());
        }
    }

    public String askMove(String player) {
        System.out.print("Please enter a move for "+ player +": ");
        return input.nextLine();
    }
}
