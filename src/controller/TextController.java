package controller;

import enums.Coordinates;
import enums.Credentials;
import enums.TextEnum;
import gui.TextGame;
import utils.ArrayList;

public class TextController {

	private ArrayList<TextGame> texts = new ArrayList<>();
	private ArrayList<TextGame> textsShowing = new ArrayList<>();

	public TextController() {
		createTexts();
	}

	public enum TextTypeEnum {
		INDICATOR, OPTION
	}

	private void createTexts() {

		for (TextEnum textEnum : TextEnum.values())
			this.texts.add(new TextGame(textEnum));

	}

	public void showText(TextEnum textEnum) {

		ArrayList<TextEnum> arrayList = new ArrayList<>();
		arrayList.add(textEnum);
		showText(arrayList);

	}

	public void showText(ArrayList<TextEnum> arrayList) {

		double x = Coordinates.TEXT_PANEL.x();
		double y = Coordinates.TEXT_PANEL.y();

		while (!arrayList.isEmpty()) {

			TextEnum textEnum = arrayList.removeFirst();

			for (TextGame textGame : this.texts) {

				if (!textGame.getTextEnum().equals(textEnum))
					continue;

				textGame.toFront();

				this.textsShowing.add(textGame);
				textGame.setVisible(true);
				textGame.relocate(x, y);

				y += Credentials.TEXT_HEIGHT.credential();

				if (textGame.getTextEnum().string().contains("\n"))
					y += y;

			}
		}
	}

	public void concealText() {

		for (TextGame textGame : this.textsShowing)
			textGame.setVisible(false);

		this.textsShowing.clear();

	}

}
