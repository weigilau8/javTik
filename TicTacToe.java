import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        Board.printBoard(board);

        while (true) {
            Player.playerTurn(board, scanner);

            if (Game.isGameFinished(board)) {
                break;
            }
            Board.printBoard(board);

            Computer.computerTurn(board);
            if (Game.isGameFinished(board)) {
                break;
            }
            Board.printBoard(board);
        }
        scanner.close();
    }
}
