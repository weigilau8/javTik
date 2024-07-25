import java.util.Random;

public class Computer {

    public static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (Board.isValidMove(board, Integer.toString(computerMove))) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        Board.placeMove(board, Integer.toString(computerMove), 'O');
    }
}
