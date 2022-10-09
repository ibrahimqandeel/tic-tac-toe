package com.game.tictactoeapi;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicTacToeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicTacToeApiApplication.class, args);
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Tic-Tac-Toe API Docs")
                        .description("Tic-Tac-Toe online game")
                        .version("v1"));
    }
}
