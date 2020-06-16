package pkgMain;

import javafx.scene.Node;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen


import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pkgMain.RatingScreen;
import pkgMain.LawnScreen;
import pkgMain.StartScreen;
import pkgMain.SurveyScreen;

import java.util.Hashtable;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

public class Controller{
	
	View view;
	Model model;
	LawnScreen lawn;
	
	public Controller(View view) {
		this.view = view;
		model = new Model(this);
	}
	
	
	public void tutorialBtnClick(MouseEvent event) {
		System.out.println("tutorial button Clicked");
		view.changeSceneTo(SceneName.TUTORIAL_SCREEN);
	}
	
	
	public void createNewBtnClick(MouseEvent event) {
		System.out.println("Create new garden clicked.");
		view.changeSceneTo(SceneName.SURVEY_SCREEN);
	}
	
	
	public void continueBtnClick(MouseEvent event) {
		System.out.println("View saved gardens Clicked");
		view.changeSceneTo(SceneName.LAWN_SCREEN);
	}
	
	
	public void ratingBtnClick(MouseEvent event) {
		System.out.println("Rating button Clicked");
		view.changeSceneTo(SceneName.RATING_SCREEN);
	}
	
	
	
	public void ratingBackBtnClick(MouseEvent event) {
		System.out.println("Rating back button Clicked");
		view.changeSceneTo(SceneName.LAWN_SCREEN);
	}
	
	
	public void tutorialBackBtnClick(MouseEvent event) {
		System.out.println("Tutorial back button Clicked");
		view.changeSceneTo(SceneName.SURVEY_SCREEN);
	}
	
	
	
	public void winterBtnClick(MouseEvent event) {
		System.out.println("winter button pressed");
		model.theLawn.setSurveyBloomTimePlaceHolder("Winter");
		view.changeSaturation(Season.WINTER);
	}
	
	public void springBtnClick(MouseEvent event) {
		System.out.println("spring button pressed");
		model.theLawn.setSurveyBloomTimePlaceHolder("Spring");
		view.changeSaturation(Season.SPRING);
	}
	
	public void summerBtnClick(MouseEvent event) {
		System.out.println("summer button pressed");
		model.theLawn.setSurveyBloomTimePlaceHolder("Summer");
		view.changeSaturation(Season.SUMMER);
	}
	
	public void fallBtnClick(MouseEvent event) {
		System.out.println("fall button pressed");
		model.theLawn.setSurveyBloomTimePlaceHolder("Fall");
		view.changeSaturation(Season.FALL);
	}

	
	/**
	 * setBtnHandler() takes in a button object and a button id;
	 * assigns the appropriate event method to the button object
	 * based on the button id
	 * @param btn - button object to be assigned a click method
	 * @param id - given id used to determine button assignment
	 */
	public void setBtnHandler(Button btn, ButtonId id) { 
		switch(id) {
		case TUTORIAL:
			btn.setOnMouseClicked(event -> tutorialBtnClick(event));
			break;
		case CREATE_NEW:
			btn.setOnMouseClicked(event -> createNewBtnClick(event));
			break;
		case CONTINUE:
			btn.setOnMouseClicked(event -> continueBtnClick(event));
			break;
		case RATING:
			btn.setOnMouseClicked(event -> ratingBtnClick(event));
			break;
		case RATING_BACK:
			btn.setOnMouseClicked(event -> ratingBackBtnClick(event));
			break;
		case TUTORIAL_BACK:
			btn.setOnMouseClicked(event -> tutorialBackBtnClick(event));
			break;
		case ADD_PLANT:
			btn.setOnMouseClicked(event-> addPlantBtnClick(event));
			break;
		case ADD_WOODS:
			btn.setOnMouseClicked(event-> addWoodsBtnClick(event));
			break;
		case ADD_POND:
			btn.setOnMouseClicked(event-> addPondBtnClick(event));
			break;
		case ADD_LAWN:
			btn.setOnMouseClicked(event-> addLawnBtnClick(event));
			break;
		case WINTER:
			btn.setOnMouseClicked(event-> winterBtnClick(event));
			break;
		case SUMMER:
			btn.setOnMouseClicked(event-> summerBtnClick(event));
			break;
		case SPRING:
			btn.setOnMouseClicked(event-> springBtnClick(event));
			break;
		case FALL:
			btn.setOnMouseClicked(event-> fallBtnClick(event));
			break;
		case SORT_LIGHT:
			btn.setOnAction(event-> sortLightBtnClick(event));
			break;
		case SORT_WATER:
			btn.setOnAction(event-> sortWaterBtnClick(event));
			break;
		case ADD_YEAR:
			btn.setOnAction(event-> addYearBtnClick(event));
		default:
			System.out.println("Not given a valid button ID");
			break;
		}
	}
	

	public void addYearBtnClick(ActionEvent event) 
	{
		System.out.println("adding year...");
		view.addYear();
	}


	public void sortLightBtnClick(ActionEvent event) 
	{
		System.out.println("sort light clicked");
		view.lawnScreen.sortNameList("light",view.lawnScreen.sortedPlantList);
		view.updateMenu("light");
	}


	public void sortWaterBtnClick(ActionEvent event) {
		view.lawnScreen.sortNameList("water",view.lawnScreen.sortedPlantList);
		view.updateMenu("water");
	}


	public void surveyLightSlider(int newValue) {
		view.updateSurveySliderLabels(SliderId.SURVEY_LIGHT, newValue);
		model.updateLawnLightLevel(newValue);
		
	}
	
	public void surveyWaterSlider(int newValue) {
		view.updateSurveySliderLabels(SliderId.SURVEY_WATER, newValue);
		model.updateLawnWaterLevel(newValue);
	}
	

	/*
	 * takes in a slider and its id, creates a listener for the slider and calls the appropriate method for each slider
	 */
	public void setSliderHandler(Slider slider, SliderId id) {
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				switch(id) {
				case SURVEY_LIGHT:
					surveyLightSlider(newValue.intValue());
					break;
				case SURVEY_WATER:
					surveyWaterSlider(newValue.intValue());
					break;
				default:
					System.out.println("Not given a valid slider ID");
					break;
				}
			}
		});
	}

	
	public void btToggle(RadioButton rb) {
		view.updateRadioValues(ToggleId.BT_TOGGLE, rb);
		model.updateLawnSeason(rb.getText());
	}
	
	
	public void soilToggle(RadioButton rb) {
		view.updateRadioValues(ToggleId.SOIL_TOGGLE, rb);
		model.updateLawnSoilType(rb.getText());
	}
	
	
	public void setRadioHandler(ToggleGroup tg, ToggleId id) {
		tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> observable, Toggle old_toggle, Toggle new_toggle) {
				RadioButton rb = (RadioButton)tg.getSelectedToggle();
				if(rb != null) {
					switch(id) {
					case BT_TOGGLE:
						btToggle(rb);
						break;
					case SOIL_TOGGLE:
						soilToggle(rb);
						break;
					default:
						System.out.println("Not given a valid Toggle ID");
						break;
					}
				}
			}
		});
	}
	
	
	//Menu
	public void setListHandler(ListView<Plant> menu) {
		menu.setOnMouseClicked(e->{
			System.out.println(menu.getFocusModel().getFocusedItem());
			view.updateSelection(menu.getFocusModel().getFocusedItem());
		});
	}
	
	
	public void addPlantBtnClick(MouseEvent event) {
	    Image sourceImg = view.getLawnScreen().getIvSelection().getImage();
	    ImageView newIv= new ImageView(sourceImg);
	    view.getLawnScreen().generateFlower(newIv);
		handleFlowerDrag(newIv);
		model.addPlantData(view.getLawnScreen().getMenu());
	}
	
	public void addWoodsBtnClick(MouseEvent event) {
	    Image sourceImg = view.getLawnScreen().getIvWoods().getImage();
	    ImageView newIv= new ImageView(sourceImg);
	    view.getLawnScreen().generateWoods(newIv);
		handleFlowerDrag(newIv);
	}
	
	public void addPondBtnClick(MouseEvent event) {
	    Image sourceImg = view.getLawnScreen().getIvPond().getImage();
	    ImageView newIv= new ImageView(sourceImg);
	    view.getLawnScreen().generatePond(newIv);
		handleFlowerDrag(newIv);
	}
	
	public void addLawnBtnClick(MouseEvent event) {
	    Image sourceImg = view.getLawnScreen().getIvLawn().getImage();
	    ImageView newIv= new ImageView(sourceImg);
	    view.getLawnScreen().generateLawn(newIv);
		handleFlowerDrag(newIv);
	}
	
	
	public void handleFlowerDrag(ImageView iv) {
		iv.setOnMouseDragged(event -> dragFlower(event));
	}
	
	
	public void dragFlower(MouseEvent event) {
	    System.out.println("ic mouse");
	    Node n = (Node)event.getSource();
	    n.setTranslateX(n.getTranslateX() + event.getX());
	    n.setTranslateY(n.getTranslateY() + event.getY());
	}
	
	public Hashtable<String, Integer> getRating(){
		return model.getRatingHashtable();
	}

}


