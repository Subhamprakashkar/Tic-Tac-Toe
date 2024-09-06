
import java.util.Scanner;

public class TicTacToe {
    private char[][] board = new char[3][3];
    private char currentPlayer = 'X';

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }

    public void play() {
        initializeBoard();
        printBoard();

        while (true) {
            makeMove();
            printBoard();

            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }

            if (checkDraw()) {
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void makeMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + ", enter your move (row and column, 0-2):");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid move, try again.");
            makeMove();
            return;
        }

        if (board[row][col] != '-') {
            System.out.println("Cell already occupied, try again.");
            makeMove();
            return;
        }

        board[row][col] = currentPlayer;
    }

    private boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
}