import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        Player currentPlayer = player1;

        System.out.println("Welcome to Tic-Tac-Toe!");
        board.display();

        while (true) {
            System.out.println("Enter the row and column from 0 to 2");
            System.out.print(currentPlayer.getName() + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            if (board.isValidMove(row, col)) {
                board.placeMove(row, col, currentPlayer.getSymbol());
                board.display();

                if (board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println(currentPlayer.getName() + " wins! Congratulations!");
                    break;
                } else if (board.isFull()) {
                    System.out.println("It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }
}

class Board {
    private char[][] board = new char[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void display() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    public void placeMove(int row, int col, char symbol) {
        board[row][col] = symbol;
    }

    public boolean checkWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) {
                return true; 
            }
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) {
                return true;
            }
        }
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) {
            return true;
        }
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }
}
