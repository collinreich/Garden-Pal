package pkgMain;

public enum ToggleId {
	
	BT_TOGGLE("btToggle"), SOIL_TOGGLE("soilToggle");
	
	private String name = null;

	private ToggleId(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}
}