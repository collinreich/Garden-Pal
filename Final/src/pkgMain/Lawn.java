package pkgMain;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Shape;

public class Lawn {
	int surveyLightLevel;
	int surveyWaterLevel;
	Season currentSeason = Season.SPRING;
	String surveySoilLevel;
	int currentYear;
	Season surveyBloomTime;
	String surveyBloomTimePlaceHolder;
	
	public Lawn(int l, int w, String s, Season bt) 
	{
		surveyLightLevel = l;
		surveyWaterLevel = w;
		surveySoilLevel = s;
		surveyBloomTime = bt;
	}
	
	public Lawn() {
		
	}

	ArrayList<Plant> plantList;
	ArrayList<Shape> shapeList;
	ArrayList<Label> labelList;
	
	

	

	public int getSurveyLightLevel() {
		return surveyLightLevel;
	}

	public void setSurveyLightLevel(int surveyLightLevel) {
		System.out.println("Attempting to update lawn from controller.");
		this.surveyLightLevel = surveyLightLevel;
	}

	public int getSurveyWaterLevel() {
		return surveyWaterLevel;
	}

	public void setSurveyWaterLevel(int n) {
		this.surveyWaterLevel = n;
	}

	public String getSurveySoilLevel() {
		return surveySoilLevel;
	}

	public void setSurveySoilLevel(String surveySoilLevel) {
		this.surveySoilLevel = surveySoilLevel;
	}

	public String getSurveyBloomTimePlaceHolder() {
		return surveyBloomTimePlaceHolder;
	}

	public void setSurveyBloomTimePlaceHolder(String string) {
		this.surveyBloomTimePlaceHolder = string;
	}

	
	/*
	 * labelLawn takes in a string and adds a label with the string to the list of
	 * labels
	 */
	public void labelLawn(String label) {
		Label l = new Label(label);
		labelList.add(l);
	}

	/*
	 * lawnShape takes in a shape object and adds it to the array list of shapes in
	 * the lawn
	 */
	public void lawnShape(Shape shape) {
		shapeList.add(shape);
	}

	/*
	 * addPlants takes in a plant object and adds it to the array list of plant
	 * objects in the lawn.
	 */
	public void addPlants(Plant plant) {
		plantList.add(plant);
	}

	/*
	 * updateSeason takes in a string and changes the current season.
	 */
	public void updateSeason(String season, Season id) {
		switch(id) {
		case WINTER:
			currentSeason = Season.WINTER;
			surveyBloomTimePlaceHolder = "Winter";
		case SPRING:
			currentSeason = Season.SPRING;
			surveyBloomTimePlaceHolder = "Spring";
		case SUMMER:
			currentSeason = Season.SUMMER;
			surveyBloomTimePlaceHolder = "Summer";
		case FALL:
			currentSeason = Season.FALL;
			surveyBloomTimePlaceHolder = "Fall";
		default:
			break;
		}
	}
	
	public String toString()
	{
		return "Lawn with: \n"+surveyLightLevel+" Light Level\n "+surveyWaterLevel+" Water Level\n"+
				surveySoilLevel + " Soil Type \n" + surveyBloomTimePlaceHolder + " Bloom Time\n";
	}
}
