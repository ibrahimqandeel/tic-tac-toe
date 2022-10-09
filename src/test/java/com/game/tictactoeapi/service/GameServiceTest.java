package com.game.tictactoeapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private GameService gameServiceUnderTest;
    private String[][] gameBoard;

    @BeforeEach
    void setUp() {
        gameServiceUnderTest = new GameService();
        gameBoard = new String[3][3];
    }

    @Test
    void test_play_with_correct_cell() {
        //when
        String gameStatus = gameServiceUnderTest.play("x", 4, gameBoard);

        //Then
        assertEquals("Keep playing ...", gameStatus);
    }

    @Test
    void test_play_with_wrong_cell() {
        gameBoard[1][1] = "o"; //current cell value
        String gameStatus = gameServiceUnderTest.play("x", 5, gameBoard);
        assertEquals("Cell already acquired. Choose another cell.", gameStatus);
    }

    @Test
    void test_play_and_win_game_rows() {
        String playerName = "x";
        gameBoard[0][0] = playerName;
        gameBoard[0][1] = playerName;
        String gameStatus = gameServiceUnderTest.play("x", 3, gameBoard);
        assertEquals("Player " + playerName + " Won", gameStatus);
    }

    @Test
    void test_win_game_columns() {
        String playerName = "x";
        gameBoard[0][0] = playerName;
        gameBoard[1][0] = playerName;
        String gameStatus = gameServiceUnderTest.play("x", 7, gameBoard);
        assertEquals("Player " + playerName + " Won", gameStatus);
    }

    @Test
    void test_win_game_diagonal() {
        String playerName = "x";
        gameBoard[0][0] = gameBoard[1][1] = playerName;
        String gameStatus = gameServiceUnderTest.play("x", 9, gameBoard);
        assertEquals("Player " + playerName + " Won", gameStatus);
    }

    @Test
    void test_draw_game() {
        gameBoard = new String[][]{{"o", "x", "o"}, {"o", "x", "o"}, {"x", "o", null}};
        String gameStatus = gameServiceUnderTest.play("x", 9, gameBoard);
        assertEquals("Draw", gameStatus);
    }

}