package utils;

public class CoordinatesRelocateBuilder {

	private double topLeftX, topLeftY, width, height, gapBetweenNodes;
	private int nodesPerRow;
	private int dataTotal = 6, dataInput = 0;

	public CoordinatesRelocateBuilder() {

	}

	public CoordinatesRelocateBuilder topLeftX(double topLeftX) {
		this.topLeftX = topLeftX;
		this.dataInput++;
		return this;
	}

	public CoordinatesRelocateBuilder topLeftY(double topLeftY) {
		this.topLeftY = topLeftY;
		this.dataInput++;
		return this;
	}

	public CoordinatesRelocateBuilder width(double width) {
		this.width = width;
		this.dataInput++;
		return this;
	}

	public CoordinatesRelocateBuilder height(double height) {
		this.height = height;
		this.dataInput++;
		return this;
	}

	public CoordinatesRelocateBuilder gapBetweenNodes(double gapBetweenNodes) {
		this.gapBetweenNodes = gapBetweenNodes;
		this.dataInput++;
		return this;
	}

	public CoordinatesRelocateBuilder nodesPerRow(int nodesPerRow) {
		this.nodesPerRow = nodesPerRow;
		this.dataInput++;
		return this;
	}

	public CoordinatesRelocate create() {

		if (this.dataInput != this.dataTotal) {

			Logger.log("need more input data");
			ShutDown.execute();

		}

		return new CoordinatesRelocate(this.topLeftX, this.topLeftY,
				this.width, this.height, this.gapBetweenNodes, this.nodesPerRow);
	}

}