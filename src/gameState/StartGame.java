package gameState;

import utils.Serialization;
import enums.GameStateEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {
		
		System.out.println(Serialization.readFromFile());

		super.controller.flow().addGameStateFirst(GameStateEnum.OPTIONS);
		super.controller.flow().proceedToNextPhase();

	}

}
