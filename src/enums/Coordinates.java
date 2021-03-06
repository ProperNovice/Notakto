package enums;

public enum Coordinates {

	GAME_FIRST(Dimensions.GAP_BETWEEN_BORDERS.x(), Dimensions.GAP_BETWEEN_BORDERS.y()),
	TEXT_PLAYER(GAME_FIRST.x(), GAME_FIRST.y() + 3 * Dimensions.BOX.y() + 2 * Dimensions.GAP_BETWEEN_BOXES.y() + Dimensions.GAP_BETWEEN_TABLES.y()),
	TEXT_PANEL(TEXT_PLAYER.x(), TEXT_PLAYER.y + Credentials.TEXT_HEIGHT.credential()),
	
	;

	private double x = -1, y = -1;

	private Coordinates(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double x() {
		return x;
	}

	public double y() {
		return y;
	}

}
