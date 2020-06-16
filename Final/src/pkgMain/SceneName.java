package pkgMain;

public enum SceneName {

	START_SCREEN("startScreen"), SURVEY_SCREEN("surveyScreen"), LAWN_SCREEN("lawnScreen"), RATING_SCREEN("ratingScreen"), WINDOW_VIEW_SCREEN("windowView"),TUTORIAL_SCREEN("tutorialScreen");

	private String name = null;

	private SceneName(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}
}