package gameState;

import instances.Instances;
import javafx.scene.input.KeyCode;
import controller.Controller;
import enums.GameStateEnum;
import enums.TextEnum;

public class GameState {

	protected Controller controller = Instances.getControllerInstance();
	private GameStateEnum gameStateEnum = null;

	public GameState(GameStateEnum gameStateEnum) {
		this.gameStateEnum = gameStateEnum;
	}

	public void handleGameStateChange() {

	}

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleKeyPressed(KeyCode keyCode) {

	}

	public GameStateEnum getGameStateEnum() {
		return this.gameStateEnum;
	}

}
