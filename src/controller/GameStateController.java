package controller;

import enums.GameStateEnum;
import enums.TextEnum;
import gameState.ChangePlayer;
import gameState.CheckIfGameEnded;
import gameState.GameState;
import gameState.Options;
import gameState.StartGame;
import gameState.SuggestMove;
import gameState.TurnAI;
import gameState.TurnHuman;
import javafx.scene.input.KeyCode;
import utils.ArrayList;
import utils.Logger;
import board.Board;
import board.Box;

public class GameStateController {

	private GameState currentGameState = null;
	private ArrayList<GameState> gameStates = new ArrayList<>();

	public GameStateController() {

		this.gameStates.add(new StartGame(GameStateEnum.START_GAME));
		this.gameStates.add(new TurnHuman(GameStateEnum.TURN_HUMAN));
		this.gameStates.add(new TurnAI(GameStateEnum.TURN_AI));
		this.gameStates.add(new ChangePlayer(GameStateEnum.CHANGE_PLAYER));
		this.gameStates.add(new CheckIfGameEnded(
				GameStateEnum.CHECK_IF_GAME_ENDED));
		this.gameStates.add(new Options(GameStateEnum.OPTIONS));
		this.gameStates.add(new SuggestMove(GameStateEnum.SUGGEST_MOVE));

	}

	public void setGameState(GameStateEnum gameStateEnum) {

		for (GameState gameState : this.gameStates) {

			GameStateEnum gameStateEnumTemp = gameState.getGameStateEnum();

			if (!gameStateEnumTemp.equals(gameStateEnum))
				continue;

			this.currentGameState = gameState;
			break;

		}

		Logger.log("changing gameState");
		Logger.logNewLine(gameStateEnum);

		this.currentGameState.handleGameStateChange();

	}

	public void handleTextOptionPressed(TextEnum textEnum) {
		this.currentGameState.handleTextOptionPressed(textEnum);
	}

	public void handleKeyPressed(KeyCode keyCode) {
		this.currentGameState.handleKeyPressed(keyCode);
	}

	public void handleBoxPressedPrimary(Box box, Board board) {
		this.currentGameState.handleBoxPressedPrimary(box, board);
	}

}
