package com.game.tictactoeapi.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String play(String expectedPlayer, int cellNumber, String[][] gameBoard) {

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ++count;
                if (count == cellNumber && gameBoard[i][j] == null) {
                    gameBoard[i][j] = expectedPlayer;
                    return checkGameStatus(expectedPlayer, gameBoard);
                }
            }
        }

        return "Cell already acquired. Choose another cell.";
    }

    private String checkGameStatus(String playerName, String[][] gameBoard) {
        if (checkRowsAndColumns(playerName, gameBoard)
                || checkDiagonals(playerName, gameBoard)) {
            return "Player " + playerName + " Won";
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (gameBoard[i][j] == null) {
                        return "Keep playing ...";
                    }
                }
            }
        }
        return "Draw";
    }

    //check rows
    private boolean checkRowsAndColumns(String playerName, String[][] gameBoard) {
        for (int i = 0; i < 3; i++) {
            if ((gameBoard[i][0] != null && gameBoard[i][0].equalsIgnoreCase(playerName))
                    && (gameBoard[i][1] != null && gameBoard[i][1].equalsIgnoreCase(playerName))
                    && (gameBoard[i][2] != null && gameBoard[i][2].equalsIgnoreCase(playerName))) {
                return true;
            }

            if ((gameBoard[0][i] != null && gameBoard[0][i].equalsIgnoreCase(playerName))
                    && (gameBoard[1][i] != null && gameBoard[1][i].equalsIgnoreCase(playerName))
                    && (gameBoard[2][i] != null && gameBoard[2][i].equalsIgnoreCase(playerName))) {
                return true;
            }
        }
        return false;
    }

    //check diagonals
    private boolean checkDiagonals(String playerName, String[][] gameBoard) {
        boolean isWinner = true;
        for (int i = 0; i < 3; i++) {
            if (gameBoard[i][i] == null || !gameBoard[i][i].equalsIgnoreCase(playerName)) {
                isWinner = false;
                break;
            }
        }
        if (!isWinner) {
            isWinner = true;
            for (int i = 2; i >= 0; i--) {
                if (gameBoard[i][2 - i] == null || !gameBoard[i][2 - i].equalsIgnoreCase(playerName)) {
                    isWinner = false;
                    break;
                }
            }
        }

        return isWinner;
    }

    public void printBoard(String gameBoard[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((gameBoard[i][j] != null ? gameBoard[i][j] : "-") + " ");
            }
            System.out.println();
        }
        System.out.println("============");
    }
}