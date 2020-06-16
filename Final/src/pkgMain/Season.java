package pkgMain;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

public enum Season {

	WINTER("winter"), SPRING("spring"), SUMMER("summer"), FALL("fall");

	private String name = null;

	private Season(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}
}