package enums;

public enum TextEnum {

	CONTINUE("Continue", TextTypeEnum.OPTION),
	MAKE_A_MOVE("Make a move", TextTypeEnum.INDICATOR),
	PROCEED("Proceed", TextTypeEnum.OPTION),
	
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
