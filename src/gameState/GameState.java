package gameState;

import instances.Instances;
import javafx.scene.input.KeyCode;
import board.Board;
import board.Box;
import controller.Controller;
import enums.GameStateEnum;
import enums.TextEnum;

public abstract class GameState {

	protected Controller controller = Instances.getControllerInstance();
	private GameStateEnum gameStateEnum = null;

	public GameState(GameStateEnum gameStateEnum) {
		this.gameStateEnum = gameStateEnum;
	}

	public abstract void handleGameStateChange();

	public void handleTextOptionPressed(TextEnum textEnum) {

	}

	public void handleKeyPressed(KeyCode keyCode) {

	}

	public void handleBoxPressedPrimary(Box box, Board board) {

		if (!box.isEmpty())
			return;

		handleBoxNonEmptyPressed(box, board);

	}

	protected void handleBoxNonEmptyPressed(Box box, Board board) {

	}

	public final GameStateEnum getGameStateEnum() {
		return this.gameStateEnum;
	}

}
