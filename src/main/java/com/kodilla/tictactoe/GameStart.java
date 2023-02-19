package com.kodilla.tictactoe;

import java.util.Scanner;

public class GameStart {
    static String player1Name;
    static String player2Name;
    static boolean boardSize;
    static boolean singlePlayer;
    static boolean difficultyLevel;

    public static String getPlayer1Name() {
        return player1Name;
    }

    public static String getPlayer2Name() {
        return player2Name;
    }

    public void setDifficultyLevel() {
        System.out.println("""
                Press - 1 - to play easy level\s
                Press - 2 - to play medium level""");
        Scanner scanner = new Scanner(System.in);
        String difficulty;
        difficulty = scanner.nextLine();

        while (true) {
            if (difficulty.equals("1")) {
                difficultyLevel = true;
                break;

            } else if (difficulty.equals("2")) {
                difficultyLevel = false;
                break;
            } else {
                System.out.println("""
                        Wrong value!
                        Press - 1 - to play easy level\s
                        Press - 2 - to play medium level""");
                difficulty = scanner.nextLine();
            }
        }
    }

    public void setSinglePlayer() {
        System.out.println("""
                Press - 1 - to select single player mode\s
                Press - 2 - to select two-player mode""");
        Scanner scanner = new Scanner(System.in);
        String gameMode;
        gameMode = scanner.nextLine();
        while (true) {
            if (gameMode.equals("1")) {
                singlePlayer = true;
                break;

            } else if (gameMode.equals("2")) {
                singlePlayer = false;
                break;
            } else {
                System.out.println("""
                        Wrong value!
                        Press - 1 - to select single player mode\s
                        Press - 2 - to select two-player mode""");
                gameMode = scanner.nextLine();
            }
        }
    }

    public boolean isSinglePlayer() {
        return singlePlayer;
    }

    public static int getBoardSize() {
        int size = 3;
        if (!boardSize) {
            size = 10;
        }
        return size;
    }

    public void setPlayer1Name() {
        System.out.println("Enter player1 name : ");
        Scanner scanner = new Scanner(System.in);
        player1Name = scanner.nextLine();
    }

    public void setPlayer2Name() {
        System.out.println("Enter player2 name : ");
        Scanner scanner = new Scanner(System.in);
        player2Name = scanner.nextLine();
    }

    public char getPlayer1Symbol() {return 'X';}

    public char getPlayer2Symbol() {return 'O';}

    public void setBoardSize() {
        System.out.println("""
                Press - 3 - to select 3x3 board size\s
                Press - 10 - to select 10x10 board size""");
        String size;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            size = scanner.nextLine();
            if (size.equals("3")) {
                boardSize = true;
                break;
            } else if (size.equals("10")) {
                boardSize = false;
                break;
            } else {
                System.out.println("""
                           Wrong value!
                           Press - 3 - to select 3x3 board size\s
                           Press - 10 - to select 10x10 board size""");}
        }
    }
}
