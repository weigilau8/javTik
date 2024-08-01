/*   Class Game
 *   This class contains only static methods. The methods of this class check whether one of the players has won or not.
 *
 *   Authors: Sergei, Luigi, Valeri, Diego
 *   Date: 08.1.2024 
 */

public class Game {
    public static boolean isThereWinner = false;

    public static boolean isGameFinished(char[][] board, Player player) {
        if (hasContestantWon(board, player.getPlayerSymbol())) {
            Board.printBoard(board);
            System.out.println(player.getPlayerLabel() + " wins!");
            isThereWinner = true;
            return isThereWinner;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        Board.printBoard(board);
        System.out.println("The game ended in a tie!");
        isThereWinner = true;
        return isThereWinner;
    }

    private static boolean hasContestantWon(char[][] board, char symbol) {
        if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
            (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
            (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||
            (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
            (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
            (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||
            (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
            (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
            return true;
        }
        return false;
    }
}
