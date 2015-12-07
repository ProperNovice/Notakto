package controller;

import enums.TextEnum;

public class LastSettingsController {

	private static int totalBoards = -1;
	private static TextEnum playersEnum = null;
	private static boolean hasLastSettings = false;

	private LastSettingsController() {

	}

	public static void setLastSettings(int totalBoardsTemp,
			TextEnum playersEnumTemp) {

		hasLastSettings = true;
		totalBoards = totalBoardsTemp;
		playersEnum = playersEnumTemp;

	}

	public static int getTotalBoards() {
		return totalBoards;
	}

	public static TextEnum getPlayersEnum() {
		return playersEnum;
	}

	public static boolean hasLastSettings() {
		return hasLastSettings;
	}

}
