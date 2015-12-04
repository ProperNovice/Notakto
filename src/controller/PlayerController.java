package controller;

import enums.GameStateEnum;
import enums.PlayerType;

public class PlayerController {

	private PlayerType playerI = null;
	private PlayerType playerII = null;
	private PlayerType currentPlayer = null;

	public PlayerController() {

	}

	public void setPlayers(PlayerType playerTypeI, PlayerType playerTypeII) {

		this.playerI = playerTypeI;
		this.playerII = playerTypeII;
		this.currentPlayer = this.playerI;

	}

	public void changeCurrentPlayer() {

		if (this.currentPlayer.equals(this.playerI))
			this.currentPlayer = this.playerII;
		else if (this.currentPlayer.equals(this.playerII))
			this.currentPlayer = this.playerI;

	}

	public GameStateEnum getCurrentPlayerType() {

		switch (this.currentPlayer) {

		case AI:
			return GameStateEnum.TURN_AI;

		case HUMAN:
			return GameStateEnum.TURN_HUMAN;

		}

		return null;

	}
}
