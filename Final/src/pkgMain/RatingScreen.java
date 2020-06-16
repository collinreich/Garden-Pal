package pkgMain;

import java.util.Random;

import javafx.geometry.Orientation;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RatingScreen {

	final int WINDOW_WIDTH = 1380;
	final int WINDOW_HEIGHT = 800;

	
	//Layouts
	HBox rating = new HBox();
	VBox column1 = new VBox();
	VBox column2 = new VBox();
	VBox overallBox = new VBox();
	
	VBox root = new VBox();
	Scene theScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
	FlowPane btnGroup = new FlowPane();
	FlowPane screenName = new FlowPane();
	//FlowPane rating = new FlowPane(Orientation.VERTICAL);

	BackgroundImage ratingBackground;
	
	Button ratingBack;
	
	//Labels
	Label screenNameLabel;
	Label plantNumber;
	Label totalTrees;
	Label totalShrubs;
	Label totalVines;
	Label totalFlowers;
	Label totalFerns;
	Label totalGrass;
	Label averageLight;
	Label averageWater;
	
	
	int min = 5;
	int max = 10;

	Random rand = new Random();

	public RatingScreen() {
		ratingBack = new Button("Back to lawn screen.");
		ratingBack.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #006400; -fx-font-size: 1.5em; -fx-text-fill: #ffffff");

		btnGroup.getChildren().add(ratingBack);
		btnGroup.setHgap(10);
		btnGroup.setVgap(10);
		btnGroup.setAlignment(Pos.BOTTOM_CENTER);

	}

	public Button getRatingBackButton() {
		return ratingBack;
	}
	
	public void background() {
		ratingBackground = new BackgroundImage(new Image("images/surveyBG.png",1380,800,false,true),
		BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);
		root.setBackground(new Background(ratingBackground));
	}

	public Scene buildRatingScreen(int numPlants, float light, float water, int trees, int shrubs, int vines, int flowers, int ferns, int grass) {		
		background();

		screenNameLabel = new Label("Here are your garden statistics:");
		screenNameLabel.setStyle("-fx-text-fill: #ffffff");
		screenName.getChildren().add(screenNameLabel);
		screenName.setAlignment(Pos.CENTER);
		screenName.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #006400; -fx-font-size: 3em; -fx-text-fill: #ffffff");

		plantNumber = new Label("Number of Plants:  " + numPlants);
		column1.getChildren().add(plantNumber);
		plantNumber.setStyle(
				"-fx-font-size: 3em; -fx-text-fill: #000000");
		
		averageLight = new Label("Light Consumption:  " + light + " /5");
		column1.getChildren().add(averageLight);
		averageLight.setStyle(
				"-fx-font-size: 3em; -fx-text-fill: #000000");

		averageWater = new Label("Water Consumption:  " + water + " /5");
		column1.getChildren().add(averageWater);
		averageWater.setStyle(
				"-fx-font-size: 3em; -fx-text-fill: #000000");
		
		totalTrees = new Label("Total trees:  " + trees);
		column1.getChildren().add(totalTrees);
		totalTrees.setStyle(
				"-fx-font-size: 3em; -fx-text-fill: #000000");

		totalShrubs = new Label("Total shrubs:  " + shrubs);
		column2.getChildren().add(totalShrubs);
		totalShrubs.setStyle(
				"-fx-font-size: 3em; -fx-text-fill: #000000");
		
		totalVines = new Label("Total vines:  " + vines);
		column2.getChildren().add(totalVines);
		totalVines.setStyle(
				"-fx-font-size: 3em; -fx-text-fill: #000000");
		
		totalFlowers = new Label("Total flowers:  " + flowers);
		column2.getChildren().add(totalFlowers);
		totalFlowers.setStyle(
				"-fx-font-size: 3em; -fx-text-fill: #000000");
		
		totalFerns = new Label("Total ferns:  " + ferns);
		column2.getChildren().add(totalFerns);
		totalFerns.setStyle(
				"-fx-font-size: 3em; -fx-text-fill: #000000");
		
		totalGrass = new Label("Total grasses:  " + grass);
		column2.getChildren().add(totalGrass);
		totalGrass.setStyle(
				"-fx-font-size: 3em; -fx-text-fill: #000000");

		column1.setAlignment(Pos.CENTER);
		column2.setAlignment(Pos.CENTER);
		column1.setSpacing(50);
		column2.setSpacing(50);

		
		rating.getChildren().addAll(column1, column2);
		rating.setAlignment(Pos.CENTER);
		
		rating.setSpacing(100);

		overallBox.setAlignment(Pos.CENTER);

		
		rating.setAlignment(Pos.CENTER);
		rating.setMinHeight(500);
		rating.setMaxWidth(1000);
		rating.setStyle("-fx-background-color: #daf5dc;");

		root.setAlignment(Pos.CENTER);
		root.setSpacing(60);
		root.getChildren().addAll(screenName, rating, btnGroup);

		return theScene;
	}
	

}
