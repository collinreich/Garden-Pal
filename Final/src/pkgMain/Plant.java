package pkgMain;

// Alpha
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

public class Plant {

	String plantType;
	String name;
	String scientificName;
	int lightIntake;
	int waterIntake;
	float height;
	int id;
	Season bloomTime;
	int animalsFed;
	boolean inList;
	int x;
	int y;

	public Plant(String name) {
		this.name = name;
	}
	
	public Plant(String plantType, String name, String scientificName, int lightIntake, int waterIntake, float height, int id) {
		this.plantType = plantType;
		this.name = name;
		this.scientificName = scientificName;
		this.lightIntake = lightIntake;
		this.waterIntake = waterIntake;
		this.height = height;
		this.id = id;
	}

	public int getID()
	{
		return id;
	}
	public String toString() {
		return name +" ("+ scientificName+")";
	}
	
	public String getPlantType() {
		return plantType;
	}
	
	public void setPlantType(String plantType) {
		this.plantType = plantType;
	}
	
	
	public Season getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(Season bloomTime) {
		this.bloomTime = bloomTime;
	}

	public int getWaterIntake() {
		return waterIntake;
	}

	public void setWaterIntake(int waterIntake) {
		this.waterIntake = waterIntake;
	}

	public int getLightIntake() {
		return lightIntake;
	}

	public void setLightIntake(int lightIntake) {
		this.lightIntake = lightIntake;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String name) {
		this.name = scientificName;
	}
	
	public float getHeight() {
		return height;
	}
	
	public void setHeight(float height) {
		this.height = height;
	}

	public int getAnimalsFed() {
		return animalsFed;
	}

	public void setAnimalsFed(int animalsFed) {
		this.animalsFed = animalsFed;
	}

	public boolean isInList() {
		return inList;
	}

	public void setInList(boolean inList) {
		this.inList = inList;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}