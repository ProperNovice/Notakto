package controller;

import enums.Coordinates;
import enums.Credentials;
import enums.TextEnum;
import gui.TextGame;
import utils.ArrayList;

public class TextController {

	private ArrayList<TextGame> textGame = new ArrayList<>();
	private ArrayList<TextGame> textGameShowing = new ArrayList<>();

	public TextController() {
		createTexts();
	}

	public enum TextTypeEnum {
		INDICATOR, OPTION
	}

	private void createTexts() {

		for (TextEnum textEnum : TextEnum.values())
			this.textGame.add(new TextGame(textEnum));

	}

	public void showText(TextEnum textEnum) {

		for (TextGame textGame : this.textGame) {

			if (!textGame.getTextEnum().equals(textEnum))
				continue;

			this.textGameShowing.add(textGame);
			break;

		}

		showText();

	}

	public void showText(ArrayList<TextEnum> arrayList) {

		for (TextEnum textEnum : arrayList)
			showText(textEnum);

	}

	private void showText() {

		double x = Coordinates.TEXT_PANEL.x();
		double y = Coordinates.TEXT_PANEL.y();

		for (TextGame textGame : this.textGameShowing) {

			textGame.toFront();

			textGame.setVisible(true);
			textGame.relocate(x, y);

			y += Credentials.TEXT_HEIGHT.credential();

			if (textGame.getTextEnum().string().contains("\n"))
				y += Credentials.TEXT_HEIGHT.credential();

		}

	}

	public void concealText() {

		for (TextGame textGame : this.textGameShowing)
			textGame.setVisible(false);

		this.textGameShowing.clear();

	}

}
