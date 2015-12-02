package controller;

import instances.Instances;
import utils.ArrayList;
import enums.GameStateEnum;

public class Flow {

	private ArrayList<GameStateEnum> gameStateNormalTurn = new ArrayList<>();
	private ArrayList<GameStateEnum> gameStateResolving = new ArrayList<>();

	public Flow() {

		createGameStateNormalTurn();

	}

	public void proceedToNextPhase() {

		if (this.gameStateResolving.isEmpty())
			this.gameStateResolving.addAll(this.gameStateNormalTurn);

		Controller controller = Instances.getControllerInstance();

		GameStateEnum gameStateEnum = this.gameStateResolving.removeFirst();
		controller.gameStateController().setGameState(gameStateEnum);

	}

	public void addGameStateFirst(GameStateEnum gameStateEnum) {
		this.gameStateResolving.addFirst(gameStateEnum);
	}

	public void createGameStateNormalTurn() {

	}

}
