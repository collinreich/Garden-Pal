package pkgMain;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

import java.util.ArrayList;

public class Rating {
	
	public Rating() {
	}


	public static int calculateTotalPlants(ArrayList<Plant> centerWorkspacePlantList) {
		return centerWorkspacePlantList.size();
	}


	public static float calculateLightConsumption(ArrayList<Plant> centerWorkspacePlantList) {
		int lightTotal = 0;
		for (Plant p: centerWorkspacePlantList){
			lightTotal += p.getLightIntake();
		}
		if(centerWorkspacePlantList.size() == 0) {
			return 0;
		}
		else {
			return lightTotal/centerWorkspacePlantList.size();
		}
	}


	public static float calculateWaterConsumption(ArrayList<Plant> centerWorkspacePlantList) {
		int waterTotal = 0;
		for (Plant p: centerWorkspacePlantList){
			waterTotal += p.getWaterIntake();
		}
		if(centerWorkspacePlantList.size() == 0) {
			return 0;
		}
		else {
			return waterTotal/centerWorkspacePlantList.size();
		}
	}


	public static int getTotalTrees(ArrayList<Plant> centerWorkspacePlantList) {
		int total = 0;
		for(Plant p: centerWorkspacePlantList) {
			if(p.plantType.equals("tree")) {
				total += 1;
			}
		}
		return total;
	}
	
	public static int getTotalShrubs(ArrayList<Plant> centerWorkspacePlantList) {
		int total = 0;
		for(Plant p: centerWorkspacePlantList) {
			if(p.plantType.equals("shrub")) {
				total += 1;
			}
		}
		return total;
	}
	
	public static int getTotalVines(ArrayList<Plant> centerWorkspacePlantList) {
		int total = 0;
		for(Plant p: centerWorkspacePlantList) {
			if(p.plantType.equals("vine")) {
				total += 1;
			}
		}
		return total;
	}
	
	public static int getTotalFlower(ArrayList<Plant> centerWorkspacePlantList) {
		int total = 0;
		for(Plant p: centerWorkspacePlantList) {
			if(p.plantType.equals("flower")) {
				total += 1;
			}
		}
		return total;
	}
	
	public static int getTotalFern(ArrayList<Plant> centerWorkspacePlantList) {
		int total = 0;
		for(Plant p: centerWorkspacePlantList) {
			if(p.plantType.equals("fern")) {
				total += 1;
			}
		}
		return total;
	}
	
	public static int getTotalGrass(ArrayList<Plant> centerWorkspacePlantList) {
		int total = 0;
		for(Plant p: centerWorkspacePlantList) {
			if(p.plantType.equals("grass")) {
				total += 1;
			}
		}
		return total;
	}



}