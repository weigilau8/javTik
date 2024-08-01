/** The purpose of the class: This is the main class of the game, it contains only the "main" method. In this class, some variables are created, instances of other classes are created, and their methods are called.
*   Working with a scanner, randomizer, array, used char, String,.
*   Authors: Sergei, Luigi, Valeri, Diego
*   Date: 08.1.2024
*/

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        String gameMode;

        while (true) {
            System.out.println("Would you like to play with a buddy or the computer?");
            System.out.println("Enter 0 to play with the computer, or 1 to play with a buddy.");
            gameMode = scanner.nextLine();

            if (gameMode.equals("0") || gameMode.equals("1")) break;

            System.out.println(" ");
            System.out.println("You have entered an incorrect game mode, try again.");
            System.out.println(" ");
        }

        Board.printBoard(board);

        Player player1 = new Player("Player-1", 'X');
        Player player2;

        if (gameMode.equals("0")) {
            player2 = new Player("Computer", 'O');
        } else {
            player2 = new Player("Player-2", 'O');
        }

        Player[] players = { player1, player2 };

        while (true) {
            for (Player player : players) {
                player.playerTurn(board, scanner);

                if (Game.isGameFinished(board, player)) return;
                Board.printBoard(board);
            }

            if (Game.isThereWinner) break;
        }

        scanner.close();
    }
}
