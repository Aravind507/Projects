package Tic_Tac_Toe;

import java.util.Scanner;

public class Tic_Tac_Toe {
    final int BOARD_SIZE = 3;

    protected void playGame() {
        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = ' ';
            }
        }
        printBoard(board);
        char card = '⭕';
        int player = 1;
        System.out.println("Enter a valid values in range of 0 - 2");
        startGame(board, card, player);
        // play again
    }

    // main logic
    private void startGame(char[][] board, char card, int player) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Its player " + player + "->" + card + " turn");
            System.out.println("Choose the index to place the " + card);
            int r = scan.nextInt();
            int c = scan.nextInt();
            if (r >= BOARD_SIZE || r < 0 || c >= BOARD_SIZE || c < 0) {
                System.err.println("Enter a valid values in range of 0 - 2");
                continue;
            }

            try {
                if (validDataEntered(r, c, board)) {
                    board[r][c] = card;
                    if (winOrLoss(board, card)) {
                        printBoard(board);
                        System.out.println("Player " + player + " won the match ❤️❤️❤️❤️");
                        break;
                    }
                    printBoard(board);
                    card = card == '⭕' ? '❌' : '⭕';
                } else {
                    throw new UserInvalidInput("Entered a invalid move at row : col " + r + " : " + c);
                }
            } catch (Exception e) {
                System.err.println("Already placed " + board[r][c]);
                System.err.println(e.toString());
            }

            player = card == '⭕' ? 1 : 2;
            if (isTie(board)) {
                System.out.println("Match is tie..😉");
                break;
            }
        }
        scan.close();
    }

    private boolean isTie(char[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                if (board[i][j] == ' ')
                    return false;

        return true;
    }

    private boolean winOrLoss(char[][] board, char card) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            // checking every row
            if (board[i][0] == card && board[i][1] == card && board[i][2] == card) return true;
            // checking every col
            if (board[0][i] == card && board[1][i] == card && board[2][i] == card) return true;
        }
        // checking left diagonal
        if (board[0][0] == card && board[1][1] == card && board[2][2] == card) return true;
        // checking right diagonal
        if (board[0][2] == card && board[1][1] == card && board[2][0] == card) return true;
        return false;
    }

    private boolean validDataEntered(int r, int c, char[][] board) {
        return board[r][c] == ' ';
    }

    private void printBoard(char[][] board) {
        System.out.println("    0    1    2  ");
        System.out.println(" |----|----|----|");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println(" |--------------|");
        }
    }
}
