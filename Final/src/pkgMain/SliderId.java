package pkgMain;

public enum SliderId {
	
	SURVEY_LIGHT("surveyLight"), SURVEY_WATER("surveyWater"), SURVEY_SOIL("surveySoil"), SURVEY_BLOOM("surveryBloom");
	private String name = null;

	private SliderId(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}
	
}