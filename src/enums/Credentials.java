package enums;

public enum Credentials {

	TEXT_HEIGHT(50),
	TOTAL_BOARDS(1),

	;

	private int credential;

	private Credentials(int credential) {
		this.credential = credential;
	}

	public int credential() {
		return this.credential;
	}

}
