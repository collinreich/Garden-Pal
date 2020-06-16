package pkgMain;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import javafx.application.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import pkgMain.Model.*;

public class SurveyScreen {

	final int WINDOW_WIDTH = 1380;
	final int WINDOW_HEIGHT = 800;

	Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
	GraphicsContext gc = canvas.getGraphicsContext2D();

	VBox root = new VBox();

	GridPane sldrGroup = new GridPane();
	GridPane radioBtns = new GridPane();
	FlowPane questions = new FlowPane(Orientation.VERTICAL);
	ToggleGroup btToggle = new ToggleGroup();
	ToggleGroup soilToggle = new ToggleGroup();
	FlowPane btnGroup = new FlowPane();
	FlowPane screenName = new FlowPane();
	Scene theScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

	BackgroundImage surveyScreenBackground;
	public Button continueButton = new Button("Continue ->");
	Label screenNameLabel;
	Label lightLabel = createNewLabel("Light ⓘ");
	Label waterLabel = createNewLabel("Water ⓘ");
	Label bloomLabel1 = createNewLabel("Bloom");
	Label bloomLabel2 = createNewLabel("Time ⓘ");
	Label soilLabel = createNewLabel("Soil ⓘ");
	Label spacerLabel = createNewLabel("	");
	Label l = createNewSubLabel();
	Label s = createNewSubLabel();
	Label w = createNewSubLabel();
	Label b = createNewSubLabel();
	int sliderMin = 0;
	int sliderMax = 10;
	int sliderStartVal = 5;
	int sliderWidth = 500;

	// SLIDERS
	public Slider lightSlider = createNewSlider(SliderId.SURVEY_LIGHT);
	public Slider waterSlider = createNewSlider(SliderId.SURVEY_WATER);

	// Added for radio buttons
	public RadioButton btWinterRadio = new RadioButton("Winter");
	public RadioButton btSpringRadio = new RadioButton("Spring");
	public RadioButton btSummerRadio = new RadioButton("Summer");
	public RadioButton btFallRadio = new RadioButton("Fall");
		
	public RadioButton soilClayRadio = new RadioButton("Clay");
	public RadioButton soilSandyRadio = new RadioButton("Sandy");
	public RadioButton soilSiltyRadio = new RadioButton("Silty");
	public RadioButton soilPeatyRadio = new RadioButton("Peaty");
	public RadioButton soilChalkyRadio = new RadioButton("Chalky");
	public RadioButton soilLoamyRadio = new RadioButton("Loamy");
	//
	
	public void background() {
		surveyScreenBackground = new BackgroundImage(new Image("images/surveyBG.png",1380,800,false,true),
		BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);
		root.setBackground(new Background(surveyScreenBackground));
	}
	
	
	// getters for toggle groups
	public ToggleGroup getBtToggle() {
		System.out.println("getBtToggle");
		return btToggle;
	}
		
	public ToggleGroup getSoilToggle() {
		System.out.println("getSoilToggle");
		return soilToggle;
	}

	// setters for toggle groups
	public void setBT(RadioButton rb) { 
		btToggle.setUserData(rb);
	}
			
	public void setSoil(RadioButton rb) { 
		btToggle.setUserData(rb);
	}

	public Button getContinueButton() {
		return continueButton;
	}
	
	
	public Slider getLightSlider() {
		return lightSlider;
	}


	public Slider getWaterSlider() {
		return waterSlider;
	}


	public void setL(Number newValue) {
		l.setText("(value: " + newValue.intValue() + " hrs.)");
	}


	public void setS(Number newValue) {
		s.setText("(value: " + newValue + ")");
	}


	public void setW(Number newValue) {
		w.setText("(value: " + newValue + " in.)");
	}


	public void setB(Number newValue) {
		b.setText("(value: " + newValue + ")");
	}


	// creates a new slider
	public Slider createNewSlider(SliderId id) {
		Slider slider = new Slider();
		switch(id) {
		case SURVEY_LIGHT:
			slider.setMax(5);
			slider.setMin(1);
			slider.setMajorTickUnit(1);
			slider.setMinorTickCount(0);
			slider.setBlockIncrement(1);
			slider.setPrefWidth(sliderWidth);
			slider.setShowTickLabels(true);
			slider.setShowTickMarks(true);
			slider.setSnapToTicks(true);
		    slider.setLabelFormatter(new StringConverter<Double>() {
	            @Override
	            public String toString(Double n) {
	                if (n==1) return "Full Shade";
	                if (n==2) return "Mostly Shade";
	                if (n==3) return "Average";
	                if (n==4) return "Mostly Sun";
	                if (n==5) return "Full Sun";
	                return "Select Type";
	            }
	            @Override
	            public Double fromString(String s) {
	                switch (s) {
	                	case "Full Shade":
	                		return 0d;
	                    case "Mostly Shade":
	                        return 1d;
	                    case "Average":
	                        return 2d;
	                    case "Mostly Sun":
	                        return 3d;
	                    case "Full Sun":
	                        return 4d;
	                    default:
	                        return 5d;
	                }
	            }
	        });
			break;
		case SURVEY_WATER:
			slider.setMax(5);
			slider.setMin(1);			
			slider.setMajorTickUnit(1);
			slider.setMinorTickCount(0);
			slider.setBlockIncrement(1);
			slider.setPrefWidth(sliderWidth);
			slider.setShowTickLabels(true);
			slider.setShowTickMarks(true);
			slider.setSnapToTicks(true);
		    slider.setLabelFormatter(new StringConverter<Double>() {
	            @Override
	            public String toString(Double n) {
	                if (n==1) return "Dry";
	                if (n==2) return "Mostly Dry";
	                if (n==3) return "Average";
	                if (n==4) return "Mostly Wet";
	                if (n==5) return "Wet";
	                return "Select Type";
	            }
	            @Override
	            public Double fromString(String s) {
	                switch (s) {
	                    case "Dry":
	                        return 1d;
	                    case "Mostly Dry":
	                        return 2d;
	                    case "Average":
	                        return 3d;
	                    case "Mostly Wet":
	                        return 4d;
	                    default:
	                        return 5d;
	                }
	            }
	        });
			break;
		default:
			break;
		}
		return slider;
	}

	// creates a new slider label
	public Label createNewLabel(String name) {
		Label l = new Label(name);
		l.setStyle(
				"-fx-border-color: #ffffff00; -fx-border-width: 1px; -fx-background-color: #ffffff00; -fx-font-size: 2.5em; -fx-text-fill: #000000");
		return l;
	}

	// creates a new slider sublabel
	public Label createNewSubLabel() {
		Label subLabel = new Label("(value:   )");
		subLabel.setStyle(
				"-fx-border-color: #ffffff00; -fx-border-width: 1px; -fx-background-color: #ffffff00; -fx-font-size: 2em; -fx-text-fill: #000000");
		return subLabel;
	}
	
	
	public Scene buildSurveyScreen() {
		
		background();
		
		screenNameLabel = new Label("Please fill out the survey according your existing garden");
		screenNameLabel.setStyle(
				"-fx-text-fill: #ffffff");
		screenName.getChildren().add(screenNameLabel);
		screenName.setAlignment(Pos.CENTER);
		screenName.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #006400; -fx-font-size: 3em; -fx-text-fill: #ffffff");

		sldrGroup.setAlignment(Pos.CENTER);
		sldrGroup.setHgap(40);
		sldrGroup.setVgap(40);
		sldrGroup.setMaxWidth(1000);
		sldrGroup.setMaxHeight(2000);
		sldrGroup.setMinHeight(200);
		sldrGroup.setStyle("-fx-background-color: #daf5dc;");
		GridPane.setColumnSpan(root, 3);

		// FORMAT SLIDERS:
		sldrGroup.getChildren().addAll(lightLabel, lightSlider);
		GridPane.setConstraints(lightLabel, 0, 0);
		GridPane.setConstraints(lightSlider, 1, 0);
		GridPane.setConstraints(l, 2, 0);

		sldrGroup.getChildren().addAll(waterLabel, waterSlider);
		GridPane.setConstraints(waterLabel, 0, 1);
		GridPane.setConstraints(waterSlider, 1, 1);
		GridPane.setConstraints(w, 2, 1);
		// END OF SLIDERS

		
		// FORMAT RADIO BUTTONS
		radioBtns.setHgap(20);
		radioBtns.setVgap(40);
		radioBtns.setMinHeight(200);
		radioBtns.setMaxWidth(1000);
		radioBtns.setStyle("-fx-background-color: #daf5dc;");
		GridPane.setColumnSpan(radioBtns, 5);
		
		// FORMAT RADIO BUTTONS:
		radioBtns.setConstraints(bloomLabel1, 0, 0);
		radioBtns.setConstraints(bloomLabel2, 1, 0);
		radioBtns.setConstraints(btWinterRadio, 0, 1);
		radioBtns.setConstraints(btSpringRadio, 0, 2);
		radioBtns.setConstraints(btSummerRadio, 1, 1);
		radioBtns.setConstraints(btFallRadio, 1, 2);
		
		radioBtns.setConstraints(spacerLabel, 2, 0);
		
		radioBtns.setConstraints(soilLabel, 4, 0);
		radioBtns.setConstraints(soilClayRadio, 3, 1);
		radioBtns.setConstraints(soilSandyRadio, 3, 2);
		radioBtns.setConstraints(soilSiltyRadio, 4, 1);
		radioBtns.setConstraints(soilPeatyRadio, 4, 2);
		radioBtns.setConstraints(soilChalkyRadio, 5, 1);
		radioBtns.setConstraints(soilLoamyRadio, 5, 2);
		
		radioBtns.setAlignment(Pos.CENTER);
		radioBtns.getChildren().addAll(bloomLabel1, bloomLabel2, spacerLabel, btWinterRadio, btSpringRadio, btSummerRadio, btFallRadio, soilLabel, soilClayRadio, soilSandyRadio, soilSiltyRadio, soilPeatyRadio, soilChalkyRadio, soilLoamyRadio);

		// ASSIGN RADIO BUTTONS:
		btWinterRadio.setToggleGroup(btToggle);
		btWinterRadio.setSelected(true);
				
		btSpringRadio.setToggleGroup(btToggle);
		btSpringRadio.setSelected(false);
				
		btSummerRadio.setToggleGroup(btToggle);
		btSummerRadio.setSelected(false);
				
		btFallRadio.setToggleGroup(btToggle);
		btFallRadio.setSelected(false);
			
		soilClayRadio.setToggleGroup(soilToggle);
		soilClayRadio.setSelected(true);

		soilSandyRadio.setToggleGroup(soilToggle);
		soilSandyRadio.setSelected(true);

		soilSiltyRadio.setToggleGroup(soilToggle);
		soilSiltyRadio.setSelected(true);

		soilPeatyRadio.setToggleGroup(soilToggle);
		soilPeatyRadio.setSelected(true);

		soilChalkyRadio.setToggleGroup(soilToggle);
		soilChalkyRadio.setSelected(true);
				
		soilLoamyRadio.setToggleGroup(soilToggle);
		soilLoamyRadio.setSelected(true);
		
		// TOOLTIPS:
		lightLabel.setTooltip(new Tooltip("Select the amount of sunlight your yard gets on an average day."));
				
		waterLabel.setTooltip(new Tooltip("Select how wet or dry your yard typically is."
				+ ""));
				
		bloomLabel2.setTooltip(new Tooltip("Select the season in which the greatest number \n"
										 + "of plants in your yard are in bloom."));
				
		soilLabel.setTooltip(new Tooltip(  "Clay: made up of smaller particles and feels sticky.\n\n"
										 + "Sandy: made up of larger particles and feels gritty.\n\n"
										 + "Silty: made up of moderately sized particles and has a\n"
										 + "	   smooth or floury texture.\n\n"
										 + "Peaty: consists of spongy material formed by the partial\n"
										 + "	    decomposition of organic matter.\n\n"
										 + "Chalky: if soil froths when placed in a jar of vinegar,\n"
										 + "		then it contains calcium carbonate (chalk) or limestone.\n\n"
										 + "Loamy: dark, loose and crumbly"));
		
		
		questions.setStyle("-fx-background-color: #daf5dc;");
		questions.getChildren().addAll(sldrGroup, radioBtns);
		questions.setMaxWidth(1000);
		questions.setAlignment(Pos.CENTER);
		
		
		// Continue Button
		btnGroup.getChildren().add(continueButton);
		continueButton.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #006400; -fx-font-size: 3em; -fx-text-fill: #ffffff");
		btnGroup.setVgap(40);
		btnGroup.setAlignment(Pos.BOTTOM_CENTER);

		root.setSpacing(70);
		root.getChildren().addAll(screenName, questions, btnGroup);
		root.setAlignment(Pos.CENTER);
		
		return theScene;
	}
	
	public SurveyScreen() {
	}

}
