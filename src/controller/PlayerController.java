package controller;

import player.Player;
import enums.GameStateEnum;
import enums.PlayerOrder;
import enums.PlayerType;

public class PlayerController {

	private Player playerI = null;
	private Player playerII = null;
	private Player currentPlayer = null;

	public PlayerController() {

	}

	public void setPlayers(PlayerType playerTypeI, PlayerType playerTypeII) {

		this.playerI = new Player(playerTypeI, PlayerOrder.I);
		this.playerII = new Player(playerTypeII, PlayerOrder.II);
		this.currentPlayer = this.playerI;

	}

	public void changePlayer() {

		if (this.currentPlayer.equals(this.playerI))
			this.currentPlayer = this.playerII;
		else if (this.currentPlayer.equals(this.playerII))
			this.currentPlayer = this.playerI;

	}

	public GameStateEnum getCurrentPlayerType() {

		switch (this.currentPlayer.getPlayerType()) {

		case AI:
			return GameStateEnum.TURN_AI;

		case HUMAN:
			return GameStateEnum.TURN_HUMAN;

		}

		return null;

	}

	public void setCurrentPlayerTextVisible(boolean value) {

		if (this.currentPlayer.equals(this.playerI))
			this.playerII.textSetVisible(false);
		else if (this.currentPlayer.equals(this.playerII))
			this.playerI.textSetVisible(false);

		this.currentPlayer.textSetVisible(value);

	}

}
