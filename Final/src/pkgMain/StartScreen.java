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

public class StartScreen {

	final int WINDOW_WIDTH = 1380;
	final int WINDOW_HEIGHT = 800;
	
	Canvas canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
	GraphicsContext gc = canvas.getGraphicsContext2D();
	BackgroundImage startScreenBackground;
	VBox root = new VBox();
	FlowPane btnGroup = new FlowPane();
	FlowPane screenName = new FlowPane();
	Scene theScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
	//public Button viewSavedBtn;
	public Button createNewBtn;
	public Button tutorialBtn;
	Label screenNameLabel;
	SurveyScreen surveyScreen;

//	public Button getViewSavedBtn() {
//		System.out.println("getting view saved button");
//		return viewSavedBtn;
//	}

	public Button getCreateNewBtn() {
		System.out.println("getting create new button");
		return createNewBtn;
	}
	
	public Button getTutorialBtn() {
		System.out.println("getting tutorial button");
		return tutorialBtn;
	}

	public StartScreen() {
		tutorialBtn = new Button("View Tutorial");
		btnGroup.getChildren().add(tutorialBtn);
		tutorialBtn.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #006400; -fx-font-size: 3em; -fx-text-fill: #ffffff");

		
//		viewSavedBtn = new Button("View Saved Gardens");
//		btnGroup.getChildren().add(viewSavedBtn);
//		viewSavedBtn.setStyle(
//				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #006400; -fx-font-size: 3em; -fx-text-fill: #ffffff");

		createNewBtn = new Button("Create New Garden");
		btnGroup.getChildren().add(createNewBtn);
		createNewBtn.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #006400; -fx-font-size: 3em; -fx-text-fill: #ffffff");
		
		btnGroup.setHgap(10);
		btnGroup.setVgap(10);
		btnGroup.setAlignment(Pos.BOTTOM_CENTER);
	}
	
	public Scene buildStartScreen() {

		background();

		screenNameLabel = new Label("");
		screenName.getChildren().add(screenNameLabel);
		screenName.setAlignment(Pos.CENTER);

		root.setSpacing(100);
		root.getChildren().addAll(btnGroup, screenName);
		root.setAlignment(Pos.BOTTOM_CENTER);
		update();

		return theScene;
	}


	public void background() {
		startScreenBackground = new BackgroundImage(new Image("images/logo.png",1380,800,false,true),
		BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		BackgroundSize.DEFAULT);
		//then you set to your node
		root.setBackground(new Background(startScreenBackground));
	}

	public void update() {
		gc.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
	}

}