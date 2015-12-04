package board;

import instances.Instances;
import utils.EventHandler.EventHandlerAble;
import utils.Image;
import utils.ImageView;
import controller.Controller;
import controller.GameStateController;

public class Box implements EventHandlerAble {

	private boolean isEmpty = true;
	private ImageView imageView = null;
	private Image redX = new Image("redX.png");
	private Image greenX = new Image("greenX.png");
	private Image blueX = new Image("blueX.png");
	private Board board = null;

	public Box() {

	}

	public Box(double x, double y, Board board) {

		this.board = board;

		this.imageView = new ImageView("empty.png");
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

	public void setRedX() {
		this.imageView.setImage(this.redX);
	}

	public void setGreenX() {
		this.imageView.setImage(this.greenX);
	}

	public void setBlueX() {
		this.imageView.setImage(this.blueX);
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

		gameStateController.handleBoxPressed(this, this.board);

	}

}
