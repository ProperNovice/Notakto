package enums;

import controller.TextController.TextTypeEnum;

public enum TextEnum {
	
	HELLO("hello", TextTypeEnum.INDICATOR),
	TWO_LINES_OPTION("first line\nsecond line", TextTypeEnum.OPTION),
	TWO_LINES_INDICATOR("first line\nsecond line", TextTypeEnum.INDICATOR),
	
	;

	private String string = null;
	private TextTypeEnum textTypeEnum = null;

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
