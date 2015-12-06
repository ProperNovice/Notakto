package gameState;

import enums.Credentials;
import enums.Dimensions;
import enums.GameStateEnum;
import enums.PlayerType;
import enums.TextEnum;
import gui.TextGame;
import utils.ArrayList;

public class Options extends GameState {

	private ArrayList<TextGame> boards = new ArrayList<>();
	private ArrayList<TextGame> players = new ArrayList<>();
	private int totalBoards = -1;
	private TextEnum playersEnum = null;

	public Options(GameStateEnum gameStateEnum) {

		super(gameStateEnum);

		this.boards.add(new TextGame(TextEnum.BOARDS));
		this.boards.add(new TextGame(TextEnum.ONE));
		this.boards.add(new TextGame(TextEnum.TWO));
		this.boards.add(new TextGame(TextEnum.THREE));

		this.players.add(new TextGame(TextEnum.PLAYERS));
		this.players.add(new TextGame(TextEnum.HUMAN_VS_AI));
		this.players.add(new TextGame(TextEnum.AI_VS_HUMAN));
		this.players.add(new TextGame(TextEnum.HUMAN_VS_HUMAN));
		this.players.add(new TextGame(TextEnum.AI_VS_AI));

		double x, y;

		x = Dimensions.GAP_BETWEEN_BORDERS.x();
		y = Dimensions.GAP_BETWEEN_BORDERS.y();

		for (TextGame textGame : this.boards) {

			textGame.relocate(x, y);
			textGame.setVisible(true);

			y += Credentials.TEXT_HEIGHT.credential();

		}

		x += this.boards.get(0).getWidth()
				+ Credentials.TEXT_HEIGHT.credential();
		y = Dimensions.GAP_BETWEEN_BORDERS.y();

		for (TextGame textGame : this.players) {

			textGame.relocate(x, y);
			textGame.setVisible(true);

			y += Credentials.TEXT_HEIGHT.credential();

		}

	}

	@Override
	public void handleGameStateChange() {

		this.totalBoards = -1;
		this.playersEnum = null;

		for (TextGame textGame : this.boards)
			textGame.setVisible(true);

		for (TextGame textGame : this.players)
			textGame.setVisible(true);

	}

	@Override
	public void handleTextOptionPressed(TextEnum textEnum) {

		switch (textEnum) {

		case ONE:
			setVisibleFalse(this.boards);
			this.totalBoards = 1;
			break;

		case TWO:
			setVisibleFalse(this.boards);
			this.totalBoards = 2;
			break;

		case THREE:
			setVisibleFalse(this.boards);
			this.totalBoards = 3;
			break;

		case HUMAN_VS_AI:
			setVisibleFalse(this.players);
			this.playersEnum = textEnum;
			break;

		case AI_VS_HUMAN:
			setVisibleFalse(this.players);
			this.playersEnum = textEnum;
			break;

		case HUMAN_VS_HUMAN:
			setVisibleFalse(this.players);
			this.playersEnum = textEnum;
			break;

		case AI_VS_AI:
			setVisibleFalse(this.players);
			this.playersEnum = textEnum;
			break;

		default:
			break;

		}

		if (this.totalBoards == -1)
			return;

		if (this.playersEnum == null)
			return;

		startGame();

	}

	private void setVisibleFalse(ArrayList<TextGame> list) {

		for (TextGame textGame : list)
			textGame.setVisible(false);

	}

	private void startGame() {

		super.controller.boardController().create(this.totalBoards);

		PlayerType playerTypeI = null;
		PlayerType playerTypeII = null;

		switch (this.playersEnum) {

		case HUMAN_VS_AI:
			playerTypeI = PlayerType.HUMAN;
			playerTypeII = PlayerType.AI;
			break;

		case AI_VS_HUMAN:
			playerTypeI = PlayerType.AI;
			playerTypeII = PlayerType.HUMAN;
			break;

		case HUMAN_VS_HUMAN:
			playerTypeI = PlayerType.HUMAN;
			playerTypeII = PlayerType.HUMAN;
			break;

		case AI_VS_AI:
			playerTypeI = PlayerType.AI;
			playerTypeII = PlayerType.AI;
			break;

		default:
			break;

		}
		super.controller.playerController().setPlayers(playerTypeI,
				playerTypeII);

		super.controller.flow().proceedToNextPhase();

	}

}
