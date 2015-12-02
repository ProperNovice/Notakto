package controller;

import instances.Instances;

public class Controller {

	private GameStateController gameStateController = null;
	private TextController textController = null;
	private Flow flow = null;
	private ElementController elementController = null;
	private BoardController boardController = null;

	public Controller() {
		createInstances();
	}

	private void createInstances() {

		Instances.setControllerInstance(this);

		this.gameStateController = new GameStateController();
		this.textController = new TextController();
		this.flow = new Flow();
		this.elementController = new ElementController();
		this.boardController = new BoardController();

	}

	public GameStateController gameStateController() {
		return this.gameStateController;
	}

	public TextController textController() {
		return this.textController;
	}

	public Flow flow() {
		return this.flow;
	}

	public ElementController elementController() {
		return this.elementController;
	}

	public BoardController boardController() {
		return this.boardController;
	}

}
