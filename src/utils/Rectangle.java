package utils;

import gui.PanelGame;
import instances.Instances;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Rectangle implements Node {

	private javafx.scene.shape.Polyline rectangle = new javafx.scene.shape.Polyline();
	private double topLeftX = 0, topLeftY = 0;
	private double dimensionX, dimensionY;

	public Rectangle(double x) {

		this.dimensionX = x;
		this.dimensionY = x;

		createRectangle();

	}

	public Rectangle(double x, double y) {

		this.dimensionX = x;
		this.dimensionY = y;

		createRectangle();

	}

	private void createRectangle() {

		final PanelGame panelGame = Instances.getPanelGameInstance();

		PlatformFX.runLater(() -> {

			this.rectangle.getPoints().addAll(0.0, 0.0, this.dimensionX, 0.0,
					this.dimensionX, this.dimensionY, 0.0, this.dimensionY,
					0.0, 0.0);

			panelGame.addNode(this.rectangle);
			this.rectangle.setFill(null);
			this.rectangle.setStroke(Color.BLACK);

		});

	}

	public final ObservableList<Double> getPoints() {
		return this.rectangle.getPoints();
	}

	public boolean contains(double localX, double localY) {

		if (localX < this.topLeftX)
			return false;

		if (localX > this.topLeftX + this.dimensionX)
			return false;

		if (localY < this.topLeftY)
			return false;

		if (localY > this.topLeftY + this.dimensionY)
			return false;

		return true;

	}

	@Override
	public void relocate(double x, double y) {
		this.topLeftX = x;
		this.topLeftY = y;
		PlatformFX.runLater(() -> this.rectangle.relocate(x, y));
	}

	public final void setFill(Paint value) {
		PlatformFX.runLater(() -> this.rectangle.setFill(value));
	}

	public final void setStroke(Paint value) {
		PlatformFX.runLater(() -> this.rectangle.setStroke(value));
	}

	public final void setOnMouseEntered(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.rectangle.setOnMouseEntered(value));
	}

	public final void setOnMouseExited(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.rectangle.setOnMouseExited(value));
	}

	public final void setOnMousePressed(EventHandler<? super MouseEvent> value) {
		PlatformFX.runLater(() -> this.rectangle.setOnMousePressed(value));
	}

	public void toBack() {
		PlatformFX.runLater(() -> this.rectangle.toBack());
	}

	@Override
	public void toFront() {
		PlatformFX.runLater(() -> this.rectangle.toFront());
	}

	public final void setVisible(boolean visibility) {
		PlatformFX.runLater(() -> this.rectangle.setVisible(visibility));
	}

	@Override
	public double getLayoutX() {
		return this.rectangle.getLayoutX();
	}

	@Override
	public double getLayoutY() {
		return this.rectangle.getLayoutY();
	}

}
