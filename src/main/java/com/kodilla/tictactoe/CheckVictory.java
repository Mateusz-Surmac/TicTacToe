package com.kodilla.tictactoe;

public class CheckVictory extends Game {
    static boolean victory;
    static char potentiallyWinningSymbol;
    static char winningSymbol;

    public static void checkVictory3x3Row() {
        boolean win = false;

        for (int x = 0; x <= 2; x++) {
            int goodSymbolCounter = 1;
            potentiallyWinningSymbol = getSymbol(x, 0);

            for (int y = 1; y <= 2; y++) {
                if (potentiallyWinningSymbol != getSymbol(x, y)) {
                    break;
                } else if (potentiallyWinningSymbol == 'X' || potentiallyWinningSymbol == 'O'){
                    goodSymbolCounter++;
                }
                if (goodSymbolCounter == 3) {
                    win = true;
                    break;
                }
            }
            if (win) {break;}
        }
        if (win) {
            victory = true;
            winningSymbol = potentiallyWinningSymbol;
        }
    }

    public static void checkVictory3x3Column() {
        boolean win = false;

        for (int x = 0; x <= 2; x++) {
            int goodSymbolCounter = 1;
            potentiallyWinningSymbol = getSymbol(0, x);

            for (int y = 1; y <= 2; y++) {
                if (potentiallyWinningSymbol != getSymbol(y, x)) {
                    break;
                } else if (potentiallyWinningSymbol == 'X' || potentiallyWinningSymbol == 'O'){
                    goodSymbolCounter++;
                }
                if (goodSymbolCounter == 3) {
                    win = true;
                    break;
                }
            }
            if (win) {break;}
        }
        if (win) {
            victory = true;
            winningSymbol = potentiallyWinningSymbol;
        }
    }

    public static void checkVictory3x3Diagonal1() {
        boolean win = true;

        for (int x = 0; x <= 1; x++) {
            potentiallyWinningSymbol = getSymbol(x, x);
            if (potentiallyWinningSymbol != getSymbol(x + 1, x + 1)) {
                win = false;
                break;
            }
        }
        if (potentiallyWinningSymbol != 'X' && potentiallyWinningSymbol != 'O') {
            win = false;
        } else if (win) {
            victory = true;
            winningSymbol = potentiallyWinningSymbol;
        }
    }

    public static void checkVictory3x3Diagonal2() {
        boolean win = true;
        int y = 0;

        for (int x = 2; x >= 1; x--) {
            potentiallyWinningSymbol = getSymbol(y, x);
            if (potentiallyWinningSymbol != getSymbol(y + 1, x - 1)) {
                win = false;
                break;
            }
            y++;
        }
        if (potentiallyWinningSymbol != 'X' && potentiallyWinningSymbol != 'O') {
            win = false;
        } else if (win) {
            victory = true;
            winningSymbol = potentiallyWinningSymbol;
        }
    }

    public static boolean isVictory() {

            if (boardSize) {
                checkVictory3x3Row();
                checkVictory3x3Column();
                checkVictory3x3Diagonal1();
                checkVictory3x3Diagonal2();

            } else {
                checkVictory10x10Row();
                checkVictory10x10Column();
                checkVictory10x10Diagonal1();
                checkVictory10x10Diagonal2();

            }

        return victory;
    }

    public static void checkVictory10x10Row() {
        boolean win = false;

        for (int x = 0; x <= 9; x++) {
            int goodSymbolCounter = 1;

            for (int y = 0; y < 9; y++) {
                potentiallyWinningSymbol = getSymbol(x, y);
                if (potentiallyWinningSymbol == 'X' || potentiallyWinningSymbol == 'O') {
                    if (potentiallyWinningSymbol != getSymbol(x, y + 1)) {
                        goodSymbolCounter = 1;
                    } else {
                        goodSymbolCounter++;
                        if (goodSymbolCounter == 5) {
                            win = true;
                            break;
                        }
                    }
                }
            }
            if (goodSymbolCounter == 5) {
                break;
            }
        }
        if (win) {
            victory = true;
            winningSymbol = potentiallyWinningSymbol;
        }
    }

    public static void checkVictory10x10Column() {
        boolean win = false;

        for (int x = 0; x <= 9; x++) {
            int goodSymbolCounter = 1;

            for (int y = 0; y < 9; y++) {
                potentiallyWinningSymbol = getSymbol(y, x);
                if (potentiallyWinningSymbol == 'X' || potentiallyWinningSymbol == 'O') {
                    if (potentiallyWinningSymbol != getSymbol(y + 1, x)) {
                        goodSymbolCounter = 1;
                    } else {
                        goodSymbolCounter++;
                        if (goodSymbolCounter == 5) {
                            win = true;
                            break;
                        }
                    }
                }
            }
            if (goodSymbolCounter == 5) {
                break;
            }
        }
        if (win) {
            victory = true;
            winningSymbol = potentiallyWinningSymbol;
        }
    }

    public static void checkVictory10x10Diagonal1() {
        boolean win = false;

        for (int diagonalCounter = 0; diagonalCounter <=5 ; diagonalCounter++) {
            int goodSymbolCounter = 1;
            for (int x = 0; x < 9; x++){
                if (x + diagonalCounter == 9) {break;}
                potentiallyWinningSymbol = getSymbol(x,x + diagonalCounter);
                if (potentiallyWinningSymbol == 'X' || potentiallyWinningSymbol == 'O' && (x + 1 + diagonalCounter) <= 9) {
                    if (potentiallyWinningSymbol != getSymbol(x + 1, x + 1 + diagonalCounter)) {
                        goodSymbolCounter = 1;
                    } else {
                        goodSymbolCounter++;
                        if (goodSymbolCounter == 5) {
                            win = true;
                            break;
                        }
                    }
                }
            }
            if (win) {
                victory = true;
                winningSymbol = potentiallyWinningSymbol;
                break;
            }

        }


        for (int diagonalCounter = 1; diagonalCounter <= 5; diagonalCounter++) {
            int goodSymbolCounter = 1;
            if (victory) {break;}
            for (int x = 0; x < 9; x++) {
                if (x + diagonalCounter == 9) {break;}
                potentiallyWinningSymbol = getSymbol(x + diagonalCounter, x);
                if (potentiallyWinningSymbol == 'X' || potentiallyWinningSymbol == 'O' && (x + 1 + diagonalCounter) <= 9) {
                    if (potentiallyWinningSymbol != getSymbol(x + diagonalCounter + 1, x + 1)) {
                        goodSymbolCounter = 1;
                    } else {
                        goodSymbolCounter++;
                        if (goodSymbolCounter == 5) {
                            win = true;
                            break;
                        }
                    }
                }
            }
            if (win) {
                victory = true;
                winningSymbol = potentiallyWinningSymbol;
                break;
            }
        }
    }
    public static void checkVictory10x10Diagonal2() {
        boolean win = false;

        for (int diagonalCounter = 0; diagonalCounter <= 5; diagonalCounter++) {
            int goodSymbolCounter = 1;
            for (int x = 9; x > 0; x--) {
                if ((x - diagonalCounter) <= 0) {break;}
                potentiallyWinningSymbol = getSymbol(x - diagonalCounter, 9 - x );
                if (potentiallyWinningSymbol == 'X' || potentiallyWinningSymbol == 'O' && (x - 1 - diagonalCounter) <= 0) {
                    if (potentiallyWinningSymbol != getSymbol(x - 1 - diagonalCounter, 10 - x)) {
                        goodSymbolCounter = 1;
                    } else {
                        goodSymbolCounter++;
                        if (goodSymbolCounter == 5) {
                            win = true;
                            break;
                        }
                    }
                }
            }
            if (win) {
                victory = true;
                winningSymbol = potentiallyWinningSymbol;
                break;
            }
        }


        for (int diagonalCounter = 1; diagonalCounter <= 5; diagonalCounter++) {
            int goodSymbolCounter = 1;
            if (victory) {break;}
            for (int x = 9; x > 0; x--) {
                if ((9 - x + diagonalCounter) == 9) {break;}
                potentiallyWinningSymbol = getSymbol(x, 9 - x + diagonalCounter);
                if (potentiallyWinningSymbol == 'X' || potentiallyWinningSymbol == 'O' && (x - 1) <= 0) {
                    if (potentiallyWinningSymbol != getSymbol(x - 1, 10 - x + diagonalCounter)) {
                        goodSymbolCounter = 1;
                    } else {
                        goodSymbolCounter++;
                        if (goodSymbolCounter == 5) {
                            win = true;
                            break;
                        }
                    }
                }
            }
            if (win) {
                victory = true;
                winningSymbol = potentiallyWinningSymbol;
                break;
            }
        }
    }
}
