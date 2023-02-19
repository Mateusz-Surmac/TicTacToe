package com.kodilla.tictactoe;

public class TicTacToeApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to the TicTacToe game!");
        startGame();
    }
    public static void startGame() {
        GameStart gameStart = new GameStart();
        ComputerMove computerMove = new ComputerMove();
        Game game = new Game();

        gameStart.setSinglePlayer();
        if (gameStart.isSinglePlayer()) {
            gameStart.setDifficultyLevel();
            computerMove.setName();
        }
        gameStart.setPlayer1Name();
        if (!gameStart.isSinglePlayer()) {gameStart.setPlayer2Name();}
        gameStart.setBoardSize();

        game.drawBoard();
        game.makeMove();
    }
}
