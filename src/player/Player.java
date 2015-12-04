package player;

import utils.Text;
import enums.Coordinates;
import enums.Credentials;
import enums.PlayerOrder;
import enums.PlayerType;

public class Player {

	private PlayerType playerType = null;
	private PlayerOrder playerOrder = null;
	private Text textTurn = null;
	private Text textEndGame = null;

	public Player(PlayerType playerType, PlayerOrder playerOrder) {

		this.playerType = playerType;
		this.playerOrder = playerOrder;

		createTextTurn();
		createTextEndGame();

	}

	private void createTextTurn() {

		String text = "";

		text += "Player ";
		text += this.playerOrder.playerOrder();
		text += " - ";
		text += this.playerType.playerType();

		this.textTurn = new Text(text);
		this.textTurn.setHeight(Credentials.TEXT_HEIGHT.credential());

		double x = Coordinates.TEXT_PLAYER.x();
		double y = Coordinates.TEXT_PLAYER.y();

		this.textTurn.relocate(x, y);
		this.textTurn.setVisible(false);

	}

	private void createTextEndGame() {

		String text = "";

		text += "Player ";
		text += this.playerOrder.playerOrder();
		text += " lost";

		this.textEndGame = new Text(text);
		this.textEndGame.setHeight(Credentials.TEXT_HEIGHT.credential());

		double x = Coordinates.TEXT_PLAYER.x();
		double y = Coordinates.TEXT_PLAYER.y();

		this.textEndGame.relocate(x, y);
		this.textEndGame.setVisible(false);

	}

	public void textTurnSetVisible(boolean value) {
		this.textTurn.setVisible(value);
	}

	public void textEndGameSetVisibleTrue() {
		this.textEndGame.setVisible(true);
	}

	public PlayerType getPlayerType() {
		return this.playerType;
	}

	public PlayerOrder playerOrder() {
		return this.playerOrder;
	}

}
