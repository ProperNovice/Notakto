package gameState;

import utils.Serialization;
import controller.LastSettingsController;
import enums.GameStateEnum;
import enums.TextEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		lastSettingsReadFromFile();

		super.controller.flow().addGameStateFirst(GameStateEnum.OPTIONS);
		super.controller.flow().proceedToNextPhase();

	}

	private void lastSettingsReadFromFile() {

		if (!Serialization.fileExists())
			return;

		Object object = Serialization.readFromFile();

		if (!(object instanceof LastSettingsController))
			return;

		LastSettingsController lastSettingsController = (LastSettingsController) object;

		int totalBoards = lastSettingsController.getTotalBoards();
		TextEnum playersEnum = lastSettingsController.getPlayersEnum();

		super.controller.lastSettingsController().setLastSettings(totalBoards,
				playersEnum);

	}

}
