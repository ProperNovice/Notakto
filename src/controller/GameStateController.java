package controller;

import enums.GameStateEnum;
import enums.TextEnum;
import gameState.Animating;
import gameState.GameState;
import gameState.StartGame;
import utils.Logger;

public class GameStateController {

	private GameState currentGameState = new GameState();
	private GameState startGame = new StartGame();
	private GameState animating = new Animating();

	public GameStateController() {

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		switch (gameStateEnum) {

		case START_GAME:
			this.currentGameState = this.startGame;
			break;

		case ANIMATING:
			this.currentGameState = this.animating;
			break;

		}

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum.text());

		this.currentGameState.handleGameStateChange();

	}

	public void handleTextOptionPressed(TextEnum textEnum) {
		this.currentGameState.handleTextOptionPressed(textEnum);
	}

}
