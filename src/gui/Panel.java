package gui;

import instances.Instances;
import javafx.scene.image.ImageView;
import utils.EventHandler;
import utils.EventHandler.EventHandlerAble;
import utils.Executor;
import utils.Parent;
import enums.GameStateEnum;

public class Panel extends Parent implements EventHandlerAble {

	private ImageView background = new ImageView("/images/background.png");
	private PanelGame panelGame = null;

	public Panel() {

		this.background.toBack();
		this.background.setOnMousePressed(new EventHandler(this));

		this.getChildren().add(this.background);

		createNewPanelGame();

	}

	public void removeCurrentPanelGame() {

		this.panelGame.setVisible(false);
		this.getChildren().remove(this.panelGame);

	}

	public void createNewPanelGame() {

		this.panelGame = new PanelGame(this);
		this.getChildren().add(this.panelGame);

	}

	public void startGame() {

		Executor.runLater(() -> Instances.getControllerInstance()
				.gameStateController().setGameState(GameStateEnum.START_GAME));

	}

	@Override
	public void handleMouseButtonPressedSecondary() {
		this.panelGame.restartGame();
	}

}
