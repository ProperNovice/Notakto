package enums;

public enum PlayerType {

	HUMAN("Human"), AI("AI");

	private String playerType = null;

	private PlayerType(String playerType) {
		this.playerType = playerType;
	}

	public String playerType() {
		return this.playerType;
	}

}
