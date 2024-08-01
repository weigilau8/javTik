/*  This Player class is connected to the Board class, 
 *  
 *   This is a blueprint class. 
 *   It is used to create players and corresponding variables. 
 *   It also contains setters and getters.
 *   And a method that implements the players' moves.
 * 
 *   Authors: Sergei, Luigi, Valeri, Diego
 *   Date: 08.1.2024 
 */

import java.util.Random;
import java.util.Scanner;

public class Player {
    private String playerLabel;
    private char playerSymbol;
    
    private static Random rand = new Random(    );

    public Player() {}

    public Player(String playerLabel, char playerSymbol) {
        this.playerLabel = playerLabel;
        this.playerSymbol = playerSymbol;
    }

    public void setPlayerLabel(String playerLabel) {
        this.playerLabel = playerLabel;
    }

    public String getPlayerLabel() {
        return playerLabel;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void playerTurn(char[][] board, Scanner scanner) {
        String input;
        while (true) {
            if (playerLabel.equals("Computer")) {
                input = Integer.toString(rand.nextInt(9) + 1);
            } else {
                System.out.println(playerLabel + ", where would you like to play? (1-9)");
                input = scanner.nextLine();
            }

            if (Board.isValidMove(board, input)) {
                break;
            } else {
                if (playerLabel.startsWith("Player")) {
                    System.out.println(input + " is not a valid move.");
                    Board.printBoard(board);
                }
            }
        }

        System.out.println(playerLabel + " chose " + input);
        Board.placeMove(board, input, playerSymbol);
    }
}
