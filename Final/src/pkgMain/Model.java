package pkgMain;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen


import java.util.ArrayList;
import java.util.Hashtable;

import javafx.scene.control.ListView;


public class Model {
	
	static Lawn theLawn = new Lawn();
	ArrayList<Plant> modelPlantList = DataReader.getDataFromReader();
	ArrayList<Plant> centerWorkspacePlantList = new ArrayList<Plant>();
	private Controller controller;
	
	static Lawn getTheLawn()
	{
		return theLawn;
	}
	
	public Model(Controller controller){
		this.controller = controller;
	}

	public void updateLawnLightLevel(int n) {
		System.out.println("Updating lawn light to: "+n);
		theLawn.setSurveyLightLevel(n);
	}
	
	public void updateLawnWaterLevel(int n) {
		theLawn.setSurveyWaterLevel(n);
	}
	public void updateLawnSeason(String text)
	{
		System.out.println("Updating Lawn Season...");
		theLawn.setSurveyBloomTimePlaceHolder(text);
		
	}

	public void updateLawnSoilType(String text) 
	{
		theLawn.setSurveySoilLevel(text);
		
	}
	
	public Hashtable<String, Integer> getRatingHashtable(){
		Hashtable<String, Integer> h = new Hashtable<String,Integer>();
		h.put("totalPlants", (int)Rating.calculateTotalPlants(centerWorkspacePlantList));
		h.put("lightConsumption", (int)Rating.calculateLightConsumption(centerWorkspacePlantList));
		h.put("waterConsumption", (int)Rating.calculateWaterConsumption(centerWorkspacePlantList));
		h.put("totalTrees", (int)Rating.getTotalTrees(centerWorkspacePlantList));
		h.put("totalShrubs", (int)Rating.getTotalShrubs(centerWorkspacePlantList));
		h.put("totalVines", (int)Rating.getTotalVines(centerWorkspacePlantList));
		h.put("totalFlowers", (int)Rating.getTotalFlower(centerWorkspacePlantList));
		h.put("totalFerns", (int)Rating.getTotalFern(centerWorkspacePlantList));
		h.put("totalGrass", (int)Rating.getTotalGrass(centerWorkspacePlantList));
		return h;
	}
	
	public void addPlantData(ListView<Plant> menu) {
		Plant currentSelection = menu.getSelectionModel().getSelectedItem();
		for (Plant p: modelPlantList) {
			if(p.getScientificName().equals(currentSelection.getScientificName())) {
				centerWorkspacePlantList.add(p);
				System.out.println("Adding: " + p);
			}
		}
		System.out.println("Here is the current list:");
		for (Plant p: centerWorkspacePlantList) {
			System.out.println(p);
		}
	}


	
}





