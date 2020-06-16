package pkgMain;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.ArrayList;
import javafx.application.*;
import javafx.geometry.Pos;
import pkgMain.Model.*;

public class Tutorial {

	final int WINDOW_WIDTH = 1380;
	final int WINDOW_HEIGHT = 800;

	Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	BackgroundImage startScreenBackground;
	VBox root = new VBox();
	FlowPane btnGroup = new FlowPane();
	FlowPane screenName = new FlowPane();
	FlowPane tutorialPane = new FlowPane();
	Scene theScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
	Label screenNameLabel;
	StartScreen startScreen;
	Button tutorialBack;
	Label tutorial;

	public Tutorial() {

		tutorialBack = new Button("Create A New Garden");
		btnGroup.getChildren().add(tutorialBack);
		btnGroup.setAlignment(Pos.CENTER);

		tutorialBack.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #006400; -fx-font-size: 3em; -fx-text-fill: #ffffff");

	}
	
	public void background() {
		startScreenBackground = new BackgroundImage(new Image("images/surveyBG.png",1380,800,false,true),
		BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);
		root.setBackground(new Background(startScreenBackground));
	}

	public Scene buildTutorialScreen() {
		
		background();

		screenNameLabel = new Label("Welcome to the Tutorial.");
		screenNameLabel.setStyle("-fx-text-fill: #ffffff");
		
		screenName.getChildren().add(screenNameLabel);
		screenName.setStyle("-fx-border-color: #000000; -fx-border-width: 2px; -fx-background-color: #006400; -fx-font-size: 3em; -fx-text-fill: #ffffff");
		screenName.setAlignment(Pos.CENTER);

		tutorial = new Label("1. Fill out the survey based on the different characteristics of your garden. \n\n"
				+ "2. Use the add pond/woods/lawn to add them to your garden the drag them where they are located. \n\n"
				+ "3. Use the add plant to workspace button to add a plant then drag the plants where you would \n"
				+ "like in your garden. All of the plants you are shown are native plants! \n\n"
				+ "4. When you are satisfied with your garden select the rating button to see how we rated your garden. \n\n"
				+ "We hope you enjoy creating your garden and that you will use GardenPal again in the future :) \n\n"
				+ "Thank you for choosing to plant native plants in your garden. We encourage you to continue\n"
				+ "to support Delaware’s Nature Society. We look forward to serving you, seeing your garden grow,\n"
				+ "and encourage you to support local growers and nurseries.\n");
		
		tutorialPane.getChildren().add(tutorial);
		tutorialPane.setStyle("-fx-background-color: #daf5dc;");
		tutorialPane.setStyle("-fx-background-color: #daf5dc; -fx-font-size: 2em; -fx-text-fill: #ffffff");
		tutorialPane.setMinHeight(400);
		tutorialPane.setMinWidth(500);
		tutorialPane.setMaxWidth(1300);
		tutorialPane.setAlignment(Pos.CENTER);

		root.setSpacing(100);
		root.getChildren().addAll(screenName, tutorialPane, btnGroup);
		root.setAlignment(Pos.CENTER);

		return theScene;
	}

	public Button getTutorialBackButton() {
		return tutorialBack;
	}

}