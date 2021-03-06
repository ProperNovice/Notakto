package board;

import gui.PanelGame;
import instances.Instances;
import utils.EventHandler.EventHandlerAble;
import utils.Image;
import utils.ImageView;
import controller.Controller;
import controller.GameStateController;
import enums.BoxColor;
import enums.Dimensions;

public class Box implements EventHandlerAble {

	private boolean isEmpty = true;
	private ImageView imageView = null;
	private Image previouslyPlayed = new Image(
			BoxColor.PREVIOUSLY_PLAYED.boxColor());
	private Image empty = new Image("empty.png");
	private Image winningGroup = new Image(BoxColor.WINNING_GROUP.boxColor());
	private Image justPlayed = new Image(BoxColor.JUST_PLAYED.boxColor());
	private Image suggested = new Image(BoxColor.SUGGESTED.boxColor());
	private Board board = null;

	public Box() {

	}

	public Box(double x, double y, Board board) {

		this.board = board;

		this.imageView = new ImageView(this.empty);
		this.imageView.setWidth(Dimensions.BOX.x());
		this.imageView.relocate(x, y);
		this.imageView.setEventHandler(this);

	}

	private Box(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public void setNonEmpty() {
		this.isEmpty = false;
	}

	public void setEmpty() {
		this.isEmpty = true;
	}

	public void setColorPreviouslyPlayed() {
		this.imageView.setImage(this.previouslyPlayed);
	}

	public void setColorWinningGroup() {
		this.imageView.setImage(this.winningGroup);
	}

	public void setColorJustPlayed() {
		this.imageView.setImage(this.justPlayed);
	}

	public void setColorSuggested() {
		this.imageView.setImage(this.suggested);
	}

	public void setColorEmpty() {
		this.imageView.setImage(this.empty);
	}

	public boolean isEmpty() {
		return this.isEmpty;
	}

	@Override
	public Box clone() {
		return new Box(this.isEmpty);
	}

	@Override
	public void handleMouseButtonPressedPrimary() {

		Controller controller = Instances.getControllerInstance();
		GameStateController gameStateController = controller
				.gameStateController();

		gameStateController.handleBoxPressedPrimary(this, this.board);

	}

	@Override
	public void handleMouseButtonPressedSecondary() {

		PanelGame panelGame = Instances.getPanelGameInstance();
		panelGame.restartGame();

	}

	public void setVisibleFalse() {
		this.imageView.setVisible(false);
	}

	public Board getBoard() {
		return this.board;
	}

}
