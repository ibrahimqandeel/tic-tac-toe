# Tic-Tac-Toe
Tic-Tac-Toe - Game API

## Running the application locally

How to play?

* 1- Run the application
* 2- Send [Get] request to [localhost:8080/api/game/play/{playerName}/{cellNumber}](localhost:8080/api/game/play/{playerName}/{cellNumber})
* 3- If the cell is empty, and it's the player turn, the cell will be filled with the player name.
* 4- The application will check if there is any winner after every success request or end the game with draw if no more available cells. Otherwise, it will keep responding with 'Keep playing ...'
* 5- Check the game board in the console.

## Documentation

* [Swagger](http://localhost:8080/swagger-ui/index.html) - Documentation & Testing


## Built With

* 	[Java™ 11](https://www.oracle.com/java/technologies/downloads/)
* 	[Spring Boot](https://spring.io/projects/spring-boot)
* 	[Maven](https://maven.apache.org/)
* 	[github](https://github.com)
* 	[SpringDoc](https://springdoc.org)