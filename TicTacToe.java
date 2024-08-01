import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        String gameMode = getGameMode(scanner);

        Board.printBoard(board);

        Player player1 = new Player("Player-1", 'X');
        Player player2 = gameMode.equals("0") ? new Player("Computer", 'O') : new Player("Player-2", 'O');

        Player[] players = { player1, player2 };

        startGame(board, players, scanner);

        scanner.close();
    }

    private static String getGameMode(Scanner scanner) {
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

        return gameMode;
    }

    private static void startGame(char[][] board, Player[] players, Scanner scanner) {
        while (true) {
            for (Player player : players) {
                player.playerTurn(board, scanner);

                if (Game.isGameFinished(board,player)) return;
                Board.printBoard(board);
            }
        }
    }
}
