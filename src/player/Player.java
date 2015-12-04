package player;

import utils.Text;
import enums.Coordinates;
import enums.Credentials;
import enums.PlayerOrder;
import enums.PlayerType;

public class Player {

	private PlayerType playerType = null;
	private PlayerOrder playerOrder = null;
	private Text text = null;

	public Player(PlayerType playerType, PlayerOrder playerOrder) {

		this.playerType = playerType;
		this.playerOrder = playerOrder;

		createText();

	}

	private void createText() {

		String text = "";

		text += "Player ";
		text += this.playerOrder.playerOrder();
		text += " - ";
		text += this.playerType.playerType();

		this.text = new Text(text);
		this.text.setHeight(Credentials.TEXT_HEIGHT.credential());

		double x = Coordinates.TEXT_PLAYER_TOP_RIGHT.x() - this.text.getWidth();
		double y = Coordinates.TEXT_PLAYER_TOP_RIGHT.y();

		this.text.relocate(x, y);
		this.text.setVisible(false);

	}

	public void textSetVisible(boolean value) {
		this.text.setVisible(value);
	}

	public PlayerType getPlayerType() {
		return this.playerType;
	}

	public PlayerOrder playerOrder() {
		return this.playerOrder;
	}

}
