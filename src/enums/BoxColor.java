package enums;

public enum BoxColor {
	
	JUST_PLAYED(Color.BLUE),
	PREVIOUSLY_PLAYED(Color.RED),
	SUGGESTED(Color.LIGHT_BLUE),
	WINNING_GROUP(Color.GREEN);
	
	private Color color = null;
	
	private BoxColor(Color color) {
		this.color = color;
	}
	
	public String boxColor() {
		return this.color.color();
	}
	
	private enum Color {
		
		BLUE("blueX.png"),
		GREEN("greenX.png"),
		LIGHT_BLUE("lightBlueX.png"),
		RED("redX.png");
		
		private String color = null;
		
		private Color(String color) {
			this.color = color;
		}
		
		public String color() {
			return this.color;
		}
		
	}

}
