package enums;

public enum PlayerOrder {

	I("I"), II("II");

	private String playerOrder = null;

	private PlayerOrder(String playerOrder) {
		this.playerOrder = playerOrder;
	}

	public String playerOrder() {
		return this.playerOrder;
	}

}
