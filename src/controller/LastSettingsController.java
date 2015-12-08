package controller;

import java.io.Serializable;

import utils.Serialization;
import enums.TextEnum;

@SuppressWarnings("serial")
public class LastSettingsController implements Serializable {

	private int totalBoards = -1;
	private TextEnum playersEnum = null;
	private boolean hasLastSettings = false;

	public void setLastSettings(int totalBoards, TextEnum playersEnums) {

		this.hasLastSettings = true;
		this.totalBoards = totalBoards;
		this.playersEnum = playersEnums;

	}

	public void writeToFile() {
		Serialization.writeToFile(this);
	}

	public int getTotalBoards() {
		return totalBoards;
	}

	public TextEnum getPlayersEnum() {
		return playersEnum;
	}

	public boolean hasLastSettings() {
		return hasLastSettings;
	}

}
