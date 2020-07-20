package me.hebing.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        printGameBoard(gameBoard);
        enterCoords(gameBoard);
    }

    public static void printGameBoard(char[][] gameBoard) {
        System.out.println("---------");
        System.out.println("| " + gameBoard[0][0] + " " + gameBoard[0][1] + " " + gameBoard[0][2] + " |");
        System.out.println("| " + gameBoard[1][0] + " " + gameBoard[1][1] + " " + gameBoard[1][2] + " |");
        System.out.println("| " + gameBoard[2][0] + " " + gameBoard[2][1] + " " + gameBoard[2][2] + " |");
        System.out.println("---------");
    }

    public static void enterCoords(char[][] gameBoard) {
        System.out.println("Enter the coordinates: ");
        int pos1;
        int pos2;
        char symbol = 'X';

        while (true) {
            while (true) {
                String coords1 = scanner.next();
                boolean pass = isANumber(coords1);
                if (pass) {
                    pos1 = Integer.parseInt(coords1);
                    String coords2 = scanner.next();
                    pass = isANumber(coords2);
                    if (pass) {
                        pos2 = Integer.parseInt(coords2);
                        break;
                    }
                } else {
                    System.out.println("You should enter numbers!");
                }
            }
            if (pos1 > 3 || pos1 < 1 || pos2 > 3 || pos2 < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
            } else if (gameBoard[pos1 - 1][pos2 - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                gameBoard[pos1 - 1][pos2 - 1] = symbol;
                printGameBoard(gameBoard);
                if (hasWinner(gameBoard)) {
                    System.out.println(symbol + " wins");
                    break;
                } else if (boardIsFull(gameBoard)) {
                    System.out.println("Draw");
                    break;
                }
                if (symbol == 'X') {
                    symbol = 'O';
                } else {
                    symbol = 'X';
                }
            }
        }
    }

    public static boolean isANumber(String number) {
        boolean isTrue = true;
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            isTrue = false;
        }
        return isTrue;
    }

    public static boolean hasWinner(char[][] gameBoard) {
        return
                gameBoard[0][0] == gameBoard[0][1] && gameBoard[0][0] == gameBoard[0][2] && gameBoard[0][0] != ' ' ||
                gameBoard[1][0] == gameBoard[1][1] && gameBoard[1][0] == gameBoard[1][2] && gameBoard[1][0] != ' ' ||
                gameBoard[2][0] == gameBoard[2][1] && gameBoard[2][0] == gameBoard[2][2] && gameBoard[2][0] != ' ' ||
                gameBoard[0][0] == gameBoard[1][0] && gameBoard[0][0] == gameBoard[2][0] && gameBoard[0][0] != ' ' ||
                gameBoard[0][1] == gameBoard[1][1] && gameBoard[0][1] == gameBoard[2][1] && gameBoard[0][1] != ' ' ||
                gameBoard[0][2] == gameBoard[1][2] && gameBoard[0][2] == gameBoard[2][2] && gameBoard[0][2] != ' ' ||
                gameBoard[0][0] == gameBoard[1][1] && gameBoard[0][0] == gameBoard[2][2] && gameBoard[0][0] != ' ' ||
                gameBoard[0][2] == gameBoard[1][1] && gameBoard[0][2] == gameBoard[2][0] && gameBoard[0][2] != ' ';
    }

    public static boolean boardIsFull(char[][] gameBoard) {
        int counter = 0;
        for (char[] row : gameBoard) {
            for (char c : row) {
                if (c == ' ') {
                    counter++;
                }
            }
        }
        return counter == 0;
    }
}
