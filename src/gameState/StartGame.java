package gameState;

import utils.ArrayList;
import enums.Element;
import enums.GameStateEnum;

public class StartGame extends GameState {

	public StartGame(GameStateEnum gameStateEnum) {
		super(gameStateEnum);
	}

	@Override
	public void handleGameStateChange() {

		ArrayList<Element> list = new ArrayList<>();

		list.add(Element.C);
		list.add(Element.D);
		list.add(Element.D);

		list.printList();
		list = super.controller.elementController().trimElements(list);

		System.out.println("final list");
		list.printList();
		System.out.println();

		System.out.println(super.controller.elementController()
				.isPerfectPosition(list));

	}
}
