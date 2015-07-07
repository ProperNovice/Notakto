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

	public Coordinate removeFirst() {
		return this.coordinates.removeFirst();
	}

}
