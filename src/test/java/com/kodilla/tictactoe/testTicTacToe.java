package com.kodilla.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testTicTacToe {
    @Test
    void winsInRowsForX() {
        //Given && When
        GameStart.boardSize = true;
        boolean win = false;

        for (int x = 0; x <= 2; x++){
            Game.drawBoard();
            Game.board[x][0] = 'X';
            Game.board[x][1] = 'X';
            Game.board[x][2] = 'X';
            win = CheckVictory.isVictory();
            CheckVictory.victory = false;
            if (!win) {break;}

        }

        //Then
        Assertions.assertTrue(win);
    }
    @Test
    void winsInRowsForO() {
        //Given && When
        GameStart.boardSize = true;
        boolean win = false;

        for (int x = 0; x <= 2; x++){
            Game.drawBoard();
            Game.board[x][0] = 'O';
            Game.board[x][1] = 'O';
            Game.board[x][2] = 'O';
            win = CheckVictory.isVictory();
            CheckVictory.victory = false;
            if (!win) {break;}
        }

        //Then
        Assertions.assertTrue(win);
    }
    @Test
    void winsInColumnForX() {
        //Given && When
        GameStart.boardSize = true;
        boolean win = false;

        for (int x = 0; x <= 2; x++){
            Game.drawBoard();
            Game.board[0][x] = 'X';
            Game.board[1][x] = 'X';
            Game.board[2][x] = 'X';
            win = CheckVictory.isVictory();
            CheckVictory.victory = false;
            if (!win) {break;}
        }

        //Then
        Assertions.assertTrue(win);
    }
    @Test
    void winsInColumnForO() {
        //Given && When
        GameStart.boardSize = true;
        boolean win = false;

        for (int x = 0; x <= 2; x++){
            Game.drawBoard();
            Game.board[0][x] = 'O';
            Game.board[1][x] = 'O';
            Game.board[2][x] = 'O';
            win = CheckVictory.isVictory();
            CheckVictory.victory = false;
            if (!win) {break;}
        }

        //Then
        Assertions.assertTrue(win);
    }
    @Test
    void winsInDiagonalForX() {
        //Given && When
        GameStart.boardSize = true;
        boolean win;

        Game.drawBoard();
        Game.board[0][0] = 'X';
        Game.board[1][1] = 'X';
        Game.board[2][2] = 'X';
        win = CheckVictory.isVictory();
        if (win) {
            Game.drawBoard();
            CheckVictory.victory = false;
            Game.board[0][2] = 'X';
            Game.board[1][1] = 'X';
            Game.board[2][0] = 'X';
            win = CheckVictory.isVictory();
        }

        //Then
        Assertions.assertTrue(win);
    }
    @Test
    void winsInDiagonalForO() {
        //Given && When
        GameStart.boardSize = true;
        boolean win;

        Game.drawBoard();
        Game.board[0][0] = 'O';
        Game.board[1][1] = 'O';
        Game.board[2][2] = 'O';
        win = CheckVictory.isVictory();
        if (win) {
            Game.drawBoard();
            CheckVictory.victory = false;
            Game.board[0][2] = 'O';
            Game.board[1][1] = 'O';
            Game.board[2][0] = 'O';
            win = CheckVictory.isVictory();
        }

        //Then
        Assertions.assertTrue(win);
    }

    @Test
    void draw() {
        //Given
        GameStart.boardSize = true;
        Game.drawBoard();
        Game.board[0][0] = 'O';
        Game.board[0][1] = 'O';
        Game.board[0][2] = 'X';
        Game.board[1][0] = 'X';
        Game.board[1][1] = 'X';
        Game.board[1][2] = 'O';
        Game.board[2][0] = 'O';
        Game.board[2][1] = 'O';
        Game.board[2][2] = 'X';

        //When
        int maxMoves = GameStart.getBoardSize() * GameStart.getBoardSize();
        for(int x = 0; x < maxMoves; x++) {Game.movesCounter++;}
        Game.isPossibleMoves();

        //Then
        Assertions.assertFalse(CheckVictory.isVictory());
        Assertions.assertTrue(Game.possibleMoves);

    }


}
