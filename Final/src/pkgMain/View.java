package pkgMain;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

import javafx.application.Platform;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Test;

public class View extends Application{
	
	GraphicsContext gc;
	
	Scene currentScene;
	StartScreen startScreen = new StartScreen();
	SurveyScreen surveyScreen = new SurveyScreen();
	static LawnScreen lawnScreen = new LawnScreen();
	RatingScreen ratingScreen = new RatingScreen();
	Tutorial tutorialScreen = new Tutorial();
	
	private Controller controller;
	
	public View(){
		controller = new Controller(this);
	}
	
	public LawnScreen getLawnScreen() {
		return lawnScreen;
	}
	
	@Override
	public void start(Stage theStage) { 
		currentScene = startScreen.buildStartScreen();
		
		controller.setBtnHandler(startScreen.getTutorialBtn(), ButtonId.TUTORIAL);
		controller.setBtnHandler(startScreen.getCreateNewBtn(),ButtonId.CREATE_NEW);
		controller.setBtnHandler(surveyScreen.getContinueButton(), ButtonId.CONTINUE);
		controller.setBtnHandler(lawnScreen.getRatingButton(), ButtonId.RATING);
		controller.setBtnHandler(lawnScreen.getExportButton(), ButtonId.EXPORT);
		controller.setBtnHandler(ratingScreen.getRatingBackButton(), ButtonId.RATING_BACK);
		controller.setBtnHandler(tutorialScreen.getTutorialBackButton(), ButtonId.TUTORIAL_BACK);
		controller.setListHandler(lawnScreen.getMenu());
		controller.setBtnHandler(lawnScreen.getAddPlantBtn(), ButtonId.ADD_PLANT);
		controller.setBtnHandler(lawnScreen.getAddWoodsBtn(), ButtonId.ADD_WOODS);
		controller.setBtnHandler(lawnScreen.getAddPondBtn(), ButtonId.ADD_POND);
		controller.setBtnHandler(lawnScreen.getAddLawnBtn(), ButtonId.ADD_LAWN);
		controller.setSliderHandler(surveyScreen.lightSlider, SliderId.SURVEY_LIGHT);
		controller.setSliderHandler(surveyScreen.waterSlider, SliderId.SURVEY_WATER);
		controller.setRadioHandler(surveyScreen.btToggle, ToggleId.BT_TOGGLE);
		controller.setRadioHandler(surveyScreen.soilToggle, ToggleId.SOIL_TOGGLE);
		controller.setBtnHandler(lawnScreen.getWinterBtn(), ButtonId.WINTER);
		controller.setBtnHandler(lawnScreen.getSummerBtn(), ButtonId.SUMMER);
		controller.setBtnHandler(lawnScreen.getSpringBtn(), ButtonId.SPRING);
		controller.setBtnHandler(lawnScreen.getFallBtn(), ButtonId.FALL);
		controller.setBtnHandler(lawnScreen.getAddYearBtn(), ButtonId.ADD_YEAR);
		
		controller.setBtnHandler(lawnScreen.getSortByLightBtn(),ButtonId.SORT_LIGHT);
		controller.setBtnHandler(lawnScreen.getSortByWaterBtn(),ButtonId.SORT_WATER);	

		        Thread thread = new Thread(new Runnable() {

		            @Override
		            public void run() {
		                Runnable updater = new Runnable() {

		                    @Override
		                    public void run() {
		                    	theStage.setScene(currentScene);
		                    }
		                };

		                while (true) {
		                    try {
		                        Thread.sleep(1000);
		                    } catch (InterruptedException ex) {
		                    }
		                    Platform.runLater(updater);
		                }
		            }

		        });
		        thread.setDaemon(true);
		        thread.start();
		        theStage.show();
	}
				
	
	public void updateSelection(Plant plantName)
	{
		System.out.println("Passing selection to lawnScreen View...");
		lawnScreen.updateSelection(plantName);
	}
	
	
	public void changeSceneTo(SceneName name) {
		switch(name) {
		case START_SCREEN:
			currentScene = startScreen.buildStartScreen();
			break;
		case SURVEY_SCREEN:
			currentScene = surveyScreen.buildSurveyScreen();
			break;
		case LAWN_SCREEN:
			System.out.println(controller.model.theLawn);
			currentScene = lawnScreen.buildLawnScreen(controller.model.theLawn);
			break;
		case RATING_SCREEN:
			Hashtable<String, Integer> h = controller.getRating();
			currentScene = ratingScreen.buildRatingScreen(h.get("totalPlants"), h.get("lightConsumption"), h.get("waterConsumption"), 
					h.get("totalTrees"), h.get("totalShrubs"), h.get("totalVines"), h.get("totalFlowers"), h.get("totalFerns"),h.get("totalGrass"));
			break;
		case TUTORIAL_SCREEN:
			currentScene = tutorialScreen.buildTutorialScreen();
			break;
		default:
			break;
		}
	}
	
	public void updateSurveySliderLabels(SliderId id, Number newValue) {
		switch(id) {
		case SURVEY_LIGHT:
			surveyScreen.setL(newValue);
			break;
		case SURVEY_WATER:
			surveyScreen.setW(newValue);
			break;
		default:
			break;
		}
	}
	
	public void updateRadioValues(ToggleId id, RadioButton rb) {
		switch(id) {
		case BT_TOGGLE:
			surveyScreen.setBT(rb);
			break;
		case SOIL_TOGGLE:
			surveyScreen.setSoil(rb);
			break;
		}
	}
	
	public static void changeSaturation(Season id) {
		ArrayList<ImageView> workSpacePlants = lawnScreen.getCenterWorkspaceIvList();
		ColorAdjust winterFilter = new ColorAdjust();
		winterFilter.setSaturation(-1.0);
		ColorAdjust springFilter = new ColorAdjust();
		springFilter.setHue(0.3);
		springFilter.setSaturation(-0.5);
		ColorAdjust summerFilter = new ColorAdjust();
		summerFilter.setHue(0);
		ColorAdjust fallFilter = new ColorAdjust();
		fallFilter.setHue(-0.3);
		
		switch(id) {
		case WINTER:
			for(ImageView img : workSpacePlants) {
				img.setEffect(winterFilter);
			}
			break;
		case SPRING:
			for(ImageView img : workSpacePlants) {
				img.setEffect(springFilter);
			}
			break;
		case SUMMER:
			for(ImageView img : workSpacePlants) {
				img.setEffect(summerFilter);
			}
			break;
		case FALL:
			for(ImageView img : workSpacePlants) {
				img.setEffect(fallFilter);
			}
			break;
		default:
			break;
		}
	}

		public void addYear() {
			ArrayList<ImageView> workSpacePlants = lawnScreen.getCenterWorkspaceIvList();
			for(ImageView img : workSpacePlants) {
				double height = img.getFitHeight();
				img.setFitHeight(height+10);
				System.out.println("Height Added!");
			}
			
		}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void updateMenu(String var) 
	{
		System.out.println("Updating menu...");
		currentScene = lawnScreen.updateMenu(var);
	}

}