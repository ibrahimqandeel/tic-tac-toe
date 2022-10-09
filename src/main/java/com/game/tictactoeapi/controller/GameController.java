package com.game.tictactoeapi.controller;

import com.game.tictactoeapi.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    private String[][] gameBoard = new String[3][3];
    private String expectedPlayerName;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path = "play/{playerName}/{cellNumber}")
    public String play(@PathVariable String playerName,
                       @PathVariable Integer cellNumber) {
        String responseMessage;
        //Set expected player
        if (expectedPlayerName == null) {
            expectedPlayerName = playerName;
        }
        if (expectedPlayerName.equalsIgnoreCase(playerName)) {
            responseMessage = gameService.play(playerName,
                    cellNumber,
                    gameBoard);
            if (responseMessage.equalsIgnoreCase("Keep playing ...")) {
                setExpectedPlayerName(playerName);
            }

            gameService.printBoard(gameBoard);
        } else {
            responseMessage = "It is not " + playerName + " turn";
        }

        return responseMessage;
    }

    private void setExpectedPlayerName(String playerName) {
        if (playerName.equalsIgnoreCase("x")) {
            expectedPlayerName = "o";
        } else {
            expectedPlayerName = "x";
        }
    }
}
