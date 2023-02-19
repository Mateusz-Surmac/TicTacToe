package com.kodilla.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game extends GameStart {
    static char[][] board;
    static boolean possibleMoves;
    static int movesCounter;
    static boolean whoseFigure;

    public static void drawBoard() {
        board = new char[getBoardSize()][getBoardSize()];
    }
    public static char getSymbol(int row, int column) {return board[row][column];}

    public void printBoard() {
        System.out.print("\t");
        for (int i = 0; i < board.length; i++) {
            System.out.print("|" + i + "|\t");
        }
        System.out.println();
        for (int row = 0; row < getBoardSize(); row++) {
            System.out.print(row + "\t");
            for (int column = 0; column < getBoardSize(); column++) {
                System.out.print("|" + board[row][column] + "|\t");
            }
            System.out.println();
        }
    }

    public static void isPossibleMoves() {
        int maxMoves = getBoardSize() * getBoardSize();

        if (maxMoves == movesCounter) {
            possibleMoves = true;
        }
    }

    public void makeMove() {
        while (!possibleMoves) {

            boolean emptyPlace = false;
            boolean computerWait = false;

            while(!emptyPlace){
                printBoard();
                whoseFigure();

                if (!whoseFigure) {
                    System.out.println(getPlayer2Name() + " your turn");
                } else {
                    System.out.println(getPlayer1Name() + " your turn");
                }

                int row;

                while (true) {
                System.out.println("Enter the row number : ");

                try {
                    Scanner scanner = new Scanner(System.in);
                    row = scanner.nextInt();
                    if (row >= 0 && row < getBoardSize()) {break;
                    } else {System.out.println("Wrong value, enter a positive number from 0 to " + (getBoardSize()-1));}
                } catch (InputMismatchException e) {
                    System.out.println("Wrong value, enter an integer form 0 to " + (getBoardSize() - 1));
                }
            }

                int column;
                while (true) {

                System.out.println("Enter the column number : ");
                try {
                    Scanner scanner = new Scanner(System.in);
                    column = scanner.nextInt();
                    if (column >= 0 && column < getBoardSize()) {break;
                    } else {System.out.println("Wrong value, enter a positive number from 0 to " + (getBoardSize() - 1));}
                } catch (InputMismatchException e) {
                    System.out.println("Wrong value, enter an integer form 0 to " + (getBoardSize() - 1));}
            }

                emptyPlace = true;
                computerWait = false;

                if (board[row][column] == 0) {
                    char symbol;
                    if (!whoseFigure) {
                        symbol = getPlayer2Symbol();
                    } else{
                        symbol = getPlayer1Symbol();
                    }
                    movesCounter++;
                    board[row][column] = symbol;
                    emptyPlace = true;
                } else {
                    computerWait = true;
                    System.out.println("The place is occupied!");
                }
            }
            if (CheckVictory.isVictory()) {
                SomeoneWon();
                break;
            }
            isPossibleMoves();
            if (singlePlayer && !computerWait && !possibleMoves) {
                ComputerMove computerMove = new ComputerMove();
                computerMove.computerMakeMove();
                movesCounter++;
            }
            if (CheckVictory.isVictory()) {
                SomeoneWon();
                break;
            }
            if (possibleMoves) {
                System.out.println("Draw! Nobody won");
                break;
            }
        }
        printBoard();
    }
    public static void whoseFigure() {
        int whoseTurn = (movesCounter % 2);
        boolean x = false;

        if (whoseTurn == 1) {
            x = false;
        } else if (whoseTurn == 0) {
            x = true;
        }
        whoseFigure = x;
    }
    public void SomeoneWon() {
            String winner = "X";
            CheckVictory.isVictory();
            if (CheckVictory.winningSymbol == getPlayer2Symbol()) {
                winner = getPlayer2Name();
            } else if (CheckVictory.winningSymbol == getPlayer1Symbol()) {
                winner = getPlayer1Name();
            }
            System.out.println(winner + " won!");
    }

}