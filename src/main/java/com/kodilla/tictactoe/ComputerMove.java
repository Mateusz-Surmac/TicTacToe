package com.kodilla.tictactoe;

import java.util.Random;

public class ComputerMove extends GameStart {
    static int emptyX;
    static int emptyY;
    static int goodEmptyX;
    static int goodEmptyY;

    public void setName() {
        if (singlePlayer) {
            player2Name = "Computer";
        }
    }

    public void computerMakeMove() {
        int size = 3;
        if (!boardSize) {
            size = 10;
        }
        char symbol = 'O';
        int x;
        int y;

        if (difficultyLevel) {
            do {
                Random random = new Random();
                x = random.nextInt(size);
                y = random.nextInt(size);

            } while (Game.board[x][y] != 0);
            Game.board[x][y] = symbol;
        } else {

            if (boardSize) {
                goodEmptyX = 11;
                findMoveRow3x3();
                findMoveColumn3x3();
                findMoveDiagonal1();
                findMoveDiagonal2();

                if (goodEmptyX == 11) {
                    while (true) {
                        Random random = new Random();
                        x = random.nextInt(size);
                        y = random.nextInt(size);
                        if (Game.board[x][y] == 0) {
                            goodEmptyX = x;
                            goodEmptyY = y;
                            break;
                        }
                    }
                }
                Game.board[goodEmptyX][goodEmptyY] = symbol;
            } else {
                goodEmptyX = 11;
                findMoveRow10x10();
                findMoveColumn10x10();
                findMove10x10Diagonal1();
                findMove10x10Diagonal2();
                if (goodEmptyX == 11){
                    noBlockMoveClose();
                }
                Game.board[goodEmptyX][goodEmptyY] = symbol;
            }
        }
    }

    public void findMoveRow3x3() {
        for (int x = 0; x <= 2; x++) {
            int goodSymbol = 0;
            int emptyPlace = 0;
            for (int y = 0; y <= 2; y++) {
                if (Game.getSymbol(x, y) == 'X') {
                    goodSymbol++;
                } else if (Game.getSymbol(x, y) == 0) {
                    emptyPlace++;
                    emptyX = x;
                    emptyY = y;
                }
            }
            if (goodSymbol == 2 && emptyPlace == 1) {
                goodEmptyX = emptyX;
                goodEmptyY = emptyY;
                break;
            }
        }
    }

    public void findMoveColumn3x3() {
        for (int x = 0; x <= 2; x++) {
            int goodSymbol = 0;
            int emptyPlace = 0;
            for (int y = 0; y <= 2; y++) {
                if (Game.getSymbol(y, x) == 'X') {
                    goodSymbol++;
                } else if (Game.getSymbol(y, x) == 0) {
                    emptyPlace++;
                    emptyX = y;
                    emptyY = x;
                }
            }
            if (goodSymbol == 2 && emptyPlace == 1) {
                goodEmptyX = emptyX;
                goodEmptyY = emptyY;
                break;
            }
        }
    }

    public void findMoveDiagonal1() {
        int goodSymbol = 0;
        int emptyPlace = 0;
        for (int x = 0; x <= 2; x++) {
            if (Game.getSymbol(x, x) == 'X') {
                goodSymbol++;
            } else if (Game.getSymbol(x, x) == 0) {
                emptyPlace++;
                emptyX = x;
                emptyY = x;
            }
        }
        if (goodSymbol == 2 && emptyPlace == 1) {
            goodEmptyX = emptyX;
            goodEmptyY = emptyY;
        }
    }

    public void findMoveDiagonal2() {
        int goodSymbol = 0;
        int emptyPlace = 0;
        for (int x = 0; x <= 2; x++) {
            if (Game.getSymbol(x, 2 - x) == 'X') {
                goodSymbol++;
            } else if (Game.getSymbol(x, 2 - x) == 0) {
                emptyPlace++;
                emptyX = x;
                emptyY = x - 2;
            }
        }
        if (goodSymbol == 2 && emptyPlace == 1) {
            goodEmptyX = emptyX;
            goodEmptyY = emptyY;
        }
    }

    public void findMoveRow10x10() {
        for (int x = 0; x <= 9; x++) {
            int goodSymbol = 0;
            int emptyPlace = 0;

            for (int y = 0; y <= 9; y++) {
                if (Game.getSymbol(x, y) == 'X') {
                    goodSymbol++;
                } else if (Game.getSymbol(x, y) == 0) {
                    emptyPlace++;
                    if (emptyPlace <= 2) {
                        emptyX = x;
                        emptyY = y;
                    }
                } else if (Game.getSymbol(x, y) == 'O') {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
                if (goodSymbol >= 3 || goodSymbol >= 3 && emptyPlace == 1) {
                    if (emptyPlace >= 1) {
                        goodEmptyX = emptyX;
                        goodEmptyY = emptyY;
                        break;
                    }
                    if (y + 1 <= 9 && Game.getSymbol(x, y + 1) == 0){
                        goodEmptyX = x;
                        goodEmptyY = y + 1;
                        break;
                    }
                    if (y - 3 >= 0 && Game.getSymbol(x, y - 3) == 0){
                        goodEmptyX = x;
                        goodEmptyY = y - 3;
                        break;
                    }
                } else if (emptyPlace == 2 && goodSymbol == 0 || emptyPlace == 3 && goodSymbol < 1) {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
            }
            if (goodEmptyX != 11) {
                break;
            }
        }
    }
    public void findMoveColumn10x10() {
        for (int y = 0; y <= 9; y++) {
            int goodSymbol = 0;
            int emptyPlace = 0;

            for (int x = 0; x <= 9; x++) {
                if (Game.getSymbol(x, y) == 'X') {
                    goodSymbol++;
                } else if (Game.getSymbol(x, y) == 0) {
                    emptyPlace++;
                    if (emptyPlace <= 2) {
                        emptyX = x;
                        emptyY = y;
                    }
                } else if (Game.getSymbol(x, y) == 'O') {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
                if (goodSymbol >= 3 || goodSymbol >= 3 && emptyPlace == 1) {
                    if (emptyPlace >= 1) {
                        goodEmptyX = emptyX;
                        goodEmptyY = emptyY;
                        break;
                    }
                    if (y + 1 <= 9 && Game.getSymbol(x + 1 ,y) == 0){
                        goodEmptyX = x + 1;
                        goodEmptyY = y;
                        break;
                    }
                    if (x - 3 >= 0 && Game.getSymbol(x - 3, y) == 0){
                        goodEmptyX = x - 3;
                        goodEmptyY = y;
                        break;
                    }
                } else if (emptyPlace == 2 && goodSymbol == 0 || emptyPlace == 3 && goodSymbol < 1) {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
            }
            if (goodEmptyX != 11) {
                break;
            }
        }
    }
    public void findMove10x10Diagonal1() {
        for (int x = 0; x <= 5; x++) {
            int goodSymbol = 0;
            int emptyPlace = 0;

            for (int y = 0; y < 9; y++) {
                if (y + x >= 9) {break;}
                if (Game.getSymbol(y, y + x) == 'X') {
                    goodSymbol++;
                } else if (Game.getSymbol(y, y + x) == 0) {
                    emptyPlace++;
                    if (emptyPlace <= 2) {
                        emptyX = y;
                        emptyY = y + x;
                    }
                } else if (Game.getSymbol(y,y + x) == 'O') {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
                if (goodSymbol >= 3 || goodSymbol >= 3 && emptyPlace >= 1) {
                    if (emptyPlace >= 1) {
                        goodEmptyX = emptyX;
                        goodEmptyY = emptyY;
                        break;
                    }
                    if (y + x + 1 <= 9 && y + 1 <= 9 && Game.getSymbol(y + 1, y + x + 1) == 0){
                        goodEmptyX = y + 1;
                        goodEmptyY = y + x + 1;
                        break;
                    }
                    if (y + x - 3 >= 0 && y - 3 >= 0 && Game.getSymbol(y - 3, y + x - 3) == 0){
                        goodEmptyX = y - 3;
                        goodEmptyY = y + x - 3;
                        break;
                    }
                } else if (emptyPlace == 2 && goodSymbol == 0 || emptyPlace == 3 && goodSymbol < 1 || emptyPlace > 3) {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
            }
            if (goodEmptyX != 11) {
                break;
            }
        }


        for (int x = 0; x <= 5; x++) {
            int goodSymbol = 0;
            int emptyPlace = 0;

            for (int y = 0; y < 9; y++) {
                if (y + x >= 9) {break;}
                if (Game.getSymbol(y + x, y) == 'X') {
                    goodSymbol++;
                } else if (Game.getSymbol(y + x, y) == 0) {
                    emptyPlace++;
                    if (emptyPlace <= 2) {
                        emptyX = y + x;
                        emptyY = y;
                    }
                } else if (Game.getSymbol(y + x, y) == 'O') {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
                if (goodSymbol >= 3 || goodSymbol >= 3 && emptyPlace == 1) {
                    if (emptyPlace >= 1) {
                        goodEmptyX = emptyX;
                        goodEmptyY = emptyY;
                        break;
                    }
                    if (y + x + 1 <= 9 && y + 1 <= 9 && Game.getSymbol(y + x + 1, y + 1) == 0){
                        goodEmptyX = y + x + 1;
                        goodEmptyY = y + 1;
                        break;
                    }
                    if (y + x - 3 >= 0 && y - 3 >=0 && Game.getSymbol(y + x - 3, y - 3) == 0){
                        goodEmptyX = y + x - 3;
                        goodEmptyY = y - 3;
                        break;
                    }
                } else if (emptyPlace == 2 && goodSymbol == 0 || emptyPlace == 3 && goodSymbol < 1 || emptyPlace > 3) {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
            }
            if (goodEmptyX != 11) {
                break;
            }
        }
    }
    public void findMove10x10Diagonal2() {
        for (int x = 0; x <= 5; x++) {
            int goodSymbol = 0;
            int emptyPlace = 0;

            for (int y = 9; y > 0; y--) {
                if (y - x < 0) {
                    break;
                }
                if (Game.getSymbol(y - x, 9 - y) == 'X') {
                    goodSymbol++;
                } else if (Game.getSymbol(y - x, 9 - y) == 0) {
                    emptyPlace++;
                    if (emptyPlace <= 2) {
                        emptyX = y - x;
                        emptyY = 9 - y;
                    }
                } else if (Game.getSymbol(y - x, 9 - y) == 'O') {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
                if (goodSymbol >= 3 || goodSymbol >= 3 && emptyPlace == 1) {
                    if (emptyPlace >= 1) {
                        goodEmptyX = emptyX;
                        goodEmptyY = emptyY;
                        break;
                    }
                    if (y - x + 3 >= 0 && 6 - y >= 0 && Game.getSymbol(y - x + 3, 6 - y) == 0) {
                        goodEmptyX = y - x + 3;
                        goodEmptyY = 6 - y;
                        break;
                    }
                    if (y - x - 1 >= 0 && 10 - y <= 9 && Game.getSymbol(y - x - 1, 10 - y) == 0) {
                        goodEmptyX = y - x - 1;
                        goodEmptyY = 10 - y;
                        break;
                    }
                } else if (emptyPlace == 2 && goodSymbol == 0 || emptyPlace == 3 && goodSymbol < 1 || emptyPlace > 3) {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
            }
            if (goodEmptyX != 11) {
                break;
            }
        }

        for (int x = 0; x <= 5; x++) {
            int goodSymbol = 0;
            int emptyPlace = 0;

            for (int y = 9; y > 0; y--) {
                if (9 - y + x > 9) {
                    break;
                }
                if (Game.getSymbol(y,9 -y + x) == 'X') {
                    goodSymbol++;
                } else if (Game.getSymbol(y,9- y + x) == 0) {
                    emptyPlace++;
                    if (emptyPlace <= 2) {
                        emptyX = y;
                        emptyY = 9 - y + x;
                    }
                } else if (Game.getSymbol(y, 9 - y + x) == 'O') {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
                if (goodSymbol >= 3 || goodSymbol >= 3 && emptyPlace == 1) {
                    if (emptyPlace >= 1) {
                        goodEmptyX = emptyX;
                        goodEmptyY = emptyY;
                        break;
                    }
                    if (y - 1 > 0 && 10 - y + x <= 9 && Game.getSymbol(y - 1 ,9 - y + x) == 0) {
                        goodEmptyX = y - 1;
                        goodEmptyY = 10 - y + x ;
                        break;
                    } if (6 - y + x >= 0 && y + 3 <= 9 && Game.getSymbol(y + 3, 6 - y + x) == 0) {
                        goodEmptyX = y + 3;
                        goodEmptyY = 6 -y + x;
                        break;
                    }
                } else if (emptyPlace == 2 && goodSymbol == 0 || emptyPlace == 3 && goodSymbol < 1 || emptyPlace > 3) {
                    goodSymbol = 0;
                    emptyPlace = 0;
                }
            }
            if (goodEmptyX != 11) {
                break;
            }
        }
    }
    public void noBlockMoveClose() {
        while (true) {
            Random random = new Random();
            int randomX = random.nextInt(10);
            int randomY = random.nextInt(10);

            if (Game.getSymbol(randomX,randomY) == 'X') {

                while (true){
                    try {
                        int randomMove = random.nextInt(9);
                        if (randomMove == 1 && Game.getSymbol(randomX + 1, randomY) == 0) {
                            goodEmptyX = randomX + 1;
                            goodEmptyY = randomY;
                            break;
                        }
                        if (randomMove == 2 && Game.getSymbol(randomX - 1, randomY) == 0) {
                            goodEmptyX = randomX - 1;
                            goodEmptyY = randomY;
                            break;
                        }
                        if (randomMove == 3 && Game.getSymbol(randomX, randomY + 1) == 0) {
                            goodEmptyX = randomX;
                            goodEmptyY = randomY + 1;
                            break;
                        }
                        if (randomMove == 4 && Game.getSymbol(randomX, randomY - 1) == 0) {
                            goodEmptyX = randomX;
                            goodEmptyY = randomY - 1;
                            break;
                        }
                        if (randomMove == 5 && Game.getSymbol(randomX + 1, randomY + 1) == 0) {
                            goodEmptyX = randomX + 1;
                            goodEmptyY = randomY + 1;
                            break;
                        }
                        if (randomMove == 6 && Game.getSymbol(randomX + 1, randomY - 1) == 0) {
                            goodEmptyX = randomX + 1;
                            goodEmptyY = randomY - 1;
                            break;
                        }
                        if (randomMove == 7 && Game.getSymbol(randomX - 1, randomY + 1) == 0) {
                            goodEmptyX = randomX - 1;
                            goodEmptyY = randomY + 1;
                            break;
                        }
                        if (randomMove == 8 && Game.getSymbol(randomX - 1, randomY - 1) == 0) {
                            goodEmptyX = randomX - 1;
                            goodEmptyY = randomY - 1;
                            break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {}
                }
            }
            if (goodEmptyX != 11) {break;}
        }
    }
}
