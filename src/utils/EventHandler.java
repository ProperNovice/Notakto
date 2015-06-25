package utils;

import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class EventHandler implements javafx.event.EventHandler<MouseEvent> {

	private EventHandlerAble eventHandlerAble = null;
	private MouseEvent mouseEvent = null;

	public interface EventHandlerAble {
		public void handleMouseButtonPrimary();
	}

	public EventHandler(EventHandlerAble eventHandlerAble) {
		this.eventHandlerAble = eventHandlerAble;
	}

	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED))
			if (!event.getButton().equals(MouseButton.PRIMARY))
				return;

		this.mouseEvent = event;

		Executor.runLater(() -> this.eventHandlerAble
				.handleMouseButtonPrimary());

	}

	public double getX() {
		return this.mouseEvent.getX();
	}

	public double getY() {
		return this.mouseEvent.getY();
	}

}
