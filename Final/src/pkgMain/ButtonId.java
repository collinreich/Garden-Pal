package pkgMain;

public enum ButtonId {

	CREATE_NEW("createNew"), CONTINUE("continue"), RATING("rating"), EXPORT("export"), RATING_BACK("ratingBack"), 
	WINDOW_BACK("windowBack"), EXIT("exit"), TUTORIAL("tutorial"), TUTORIAL_BACK("tutorialBack"), BLOOM("bloom"), 
	NON_BLOOM("nonBloom"), ADD_PLANT("addPlant"), ADD_WOODS("addWoods"), ADD_POND("addPond"), ADD_LAWN("addLawn"), WINTER("winter"), SUMMER("summer"), SPRING("spring"), 
	FALL("fall"),SORT_LIGHT("sortByLight"),SORT_WATER("sortByWater"),SHOW_PLANT("showPlant"),ADD_YEAR("addYear");
	
	private String name = null;

	private ButtonId(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}
}