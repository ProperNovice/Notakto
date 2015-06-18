package controller;

import instances.Instances;
import utils.Executor;
import enums.GameStateEnum;

public class Controller {

	private GameStateController gameStateController = null;
	private TextController textController = null;

	public Controller() {

		createInstances();
		Executor.runLater(() -> this.gameStateController
				.setGameState(GameStateEnum.START_GAME));

	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateController = new GameStateController();
		this.textController = new TextController();

	}

	public GameStateController gameStateController() {
		return this.gameStateController;
	}

	public TextController textController() {
		return this.textController;
	}

}
