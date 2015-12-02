package board;

public class Box {

	private boolean isEmpty = true;

	public Box() {

	}

	private Box(boolean isEmpty) {
		this.isEmpty = isEmpty;
	}

	public void setNonEmpty() {
		this.isEmpty = false;
	}

	public boolean isEmpty() {
		return this.isEmpty;
	}

	public Box clone() {
		return new Box(this.isEmpty);
	}

}
