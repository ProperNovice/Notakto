package enums;

public enum TextEnum {

	CONTINUE("Continue", TextTypeEnum.OPTION),
	MAKE_A_MOVE("Make a move", TextTypeEnum.INDICATOR),
	PROCEED("Proceed", TextTypeEnum.OPTION),
	RESTART("Restart", TextTypeEnum.OPTION),
	BOARDS("Boards", TextTypeEnum.INDICATOR),
	ONE("1", TextTypeEnum.OPTION),
	TWO("2", TextTypeEnum.OPTION),
	THREE("3", TextTypeEnum.OPTION),
	PLAYERS("Players", TextTypeEnum.INDICATOR),
	HUMAN_VS_AI("Human vs AI", TextTypeEnum.OPTION),
	AI_VS_AI("AI vs AI", TextTypeEnum.OPTION),
	AI_VS_HUMAN("AI vs Human", TextTypeEnum.OPTION),
	HUMAN_VS_HUMAN("Human vs Human", TextTypeEnum.OPTION),
	RESTART_WITH_LAST_SETTINGS("Restart with last settings", TextTypeEnum.OPTION),
	
	;

	private String string = null;
	private TextTypeEnum textTypeEnum = null;

	public enum TextTypeEnum {
		INDICATOR, OPTION
	}

	private TextEnum(String string, TextTypeEnum textTypeEnum) {
		this.string = string;
		this.textTypeEnum = textTypeEnum;
	}

	public String string() {
		return this.string;
	}

	public TextTypeEnum textTypeEnum() {
		return this.textTypeEnum;
	}

}
