package utils;

public class CoordinatesRelocate {

	private ArrayList<Coordinate> coordinates = new ArrayList<>();
	private int coordinatesToCreate = 100;

	public CoordinatesRelocate(double topLeftX, double topLeftY, double width,
			double height, double gapBetweenNodes, int nodesPerRow) {

		double x = topLeftX;
		double y = topLeftY;

		for (int counter = 1; counter <= coordinatesToCreate; counter++) {

			this.coordinates.add(new Coordinate(x, y));

			if (counter % nodesPerRow > 0) {

				x += width + gapBetweenNodes;
				continue;

			} else if (counter % nodesPerRow == 0) {

				x = topLeftX;
				y += height + gapBetweenNodes;

			}

		}

	}

	public void proceedToNextCoordinates() {
		this.coordinates.removeFirst();
	}

	public double getX() {
		return this.coordinates.getFirst().getX();
	}

	public double getY() {
		return this.coordinates.getFirst().getY();
	}

	private class Coordinate {

		private double x, y;

		public Coordinate(double x, double y) {

			this.x = x;
			this.y = y;

		}

		public double getX() {
			return this.x;
		}

		public double getY() {
			return this.y;
		}

	}

}
