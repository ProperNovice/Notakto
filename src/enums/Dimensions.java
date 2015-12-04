package enums;

public enum Dimensions {

	INSETS(7, 29),
	GAP_BETWEEN_BORDERS(50, 50),
	GAP_BETWEEN_BOXES(3, 3),
	GAP_BETWEEN_TABLES(20, 20),
	BOX(100, 100),
	FRAME(9 * BOX.x() + 6 * GAP_BETWEEN_BOXES.x() + 2 * GAP_BETWEEN_TABLES.x() + 2 * GAP_BETWEEN_BORDERS.x(), 768),

	;

	private double x = -1, y = -1;

	private Dimensions(double x, double y) {
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
