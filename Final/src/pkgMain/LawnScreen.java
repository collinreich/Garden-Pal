package pkgMain;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

import javafx.scene.*;
import javafx.scene.control.ListCell;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import javax.imageio.ImageIO;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class LawnScreen {

	final int WINDOW_WIDTH = 1380;
	final int WINDOW_HEIGHT = 800;

	Scene theScene;

	// Layouts
	BorderPane root = new BorderPane();
	VBox leftMenu;
	VBox rightMenu;
	HBox topMenu;
	HBox bottomMenu;
	FlowPane centerWorkspace;

	// Buttons
	Button ratingButton;
	Button exportButton;
	Button bloomBtn;
	Button notBloomBtn;
	Button winterBtn;
	Button springBtn;
	Button summerBtn;
	Button fallBtn;
	Button addPlantBtn;
	Button addWoodsBtn;
	Button addPondBtn;
	Button addLawnBtn;
	Button sortByWaterBtn;
	Button sortByLightBtn;
	Button displayPlantBtn;
	
	// Images and imageviews

	Image woods;
	ImageView ivWoods;
	Image lawn;
	ImageView ivLawn;
	Image pond;
	ImageView ivPond;

	// Menu
	final Label menuLabel = new Label("Native Plant Menu");
	int currentID;
	ArrayList<Plant> modelPlantList = DataReader.getDataFromReader();
	ObservableList<String> nameList = FXCollections.observableArrayList();
	
	//sorting
	ObservableList<Plant> sortedPlantList=FXCollections.observableArrayList();
	Lawn theLawn;
	
	Image selectionImg;
	ImageView ivSelection;
	ListView<Plant> menu = new ListView<Plant>();

	// Centerworkspace
	ArrayList<ImageView> centerWorkspaceIvList = new ArrayList<ImageView>();
	ArrayList<Plant> centerWorkspacePlantList = new ArrayList<Plant>();

	// right menu
	ArrayList<ImageView> rightMenuIvList = new ArrayList<ImageView>();
	ArrayList<Image> rightMenuFeatList = new ArrayList<Image>();
	Button addYearBtn;

	public LawnScreen() {
		theScene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// Buttons
		ratingButton = new Button("Garden Statistics");
		ratingButton.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #ffffff; -fx-font-size: 1.5em; -fx-text-fill: #006400");

		exportButton = new Button("Export");
		exportButton.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #ffffff; -fx-font-size: 1.5em; -fx-text-fill: #006400");

		//bloomBtn = new Button("Bloom");
		//notBloomBtn = new Button("No bloom");
		winterBtn = new Button("Winter");
		springBtn = new Button("Spring");
		summerBtn = new Button("Summer");
		fallBtn = new Button("Fall");
		addYearBtn = new Button("Add Year to Plants");
		
		// Labels
		woods = new Image("images/garden-images/woods.png");
		ivWoods = new ImageView(woods);
		lawn = new Image("images/garden-images/lawn.png");
		ivLawn = new ImageView(lawn);
		pond = new Image("images/garden-images/pond.png");
		ivPond = new ImageView(pond);

		// menu stuff
		selectionImg = new Image("images/selection_icon.png");
		ivSelection = new ImageView(selectionImg);
		addPlantBtn = new Button("Add Plant To Workspace");
		addPlantBtn.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #006400; -fx-font-size: 1.5em; -fx-text-fill: #ffffff");

		addWoodsBtn = new Button("Add Woods To Workspace");
		addWoodsBtn.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #ffffff; -fx-font-size: 1.5em; -fx-text-fill: #006400");

		addPondBtn = new Button("Add Pond To Workspace");
		addPondBtn.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #ffffff; -fx-font-size: 1.5em; -fx-text-fill: #006400");

		addLawnBtn = new Button("Add Lawn To Workspace");
		addLawnBtn.setStyle(
				"-fx-border-color: #000000; -fx-border-width: 1px; -fx-background-color: #ffffff; -fx-font-size: 1.5em; -fx-text-fill: #006400");

		//Sorting buttons
		sortByWaterBtn = new Button("Show My Water Type First In Menu");
		sortByLightBtn = new Button("Show My Light Type First In Menu");
		
		displayPlantBtn = new Button("Show Data About Selected Plant");
		
		exportButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alert;
				System.out.println("exported!");
				takeSnapShot(theScene);
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("GARDEN EXPORTED");
				alert.setHeaderText(null);
				alert.setContentText("A screenshot of your garden is located as a png in the same file as GardenPal!");
				alert.showAndWait();

			}
		});
		displayPlantBtn.setOnAction(new EventHandler<ActionEvent>() 
		{
			public void handle(ActionEvent event) 
			{
				Plant select = new Plant(null);
				for (Plant p: modelPlantList)
				{
					if (p.getID()==currentID)
						select = p;
				}
				Alert alert;
				alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("PLANT DATA");
				alert.setHeaderText(null);
				String msg =
						("Plant Type: " + select.getPlantType()+
					   "\nPlant Name: " + select.getName()+
					   "\nPlant Scientific Name: " + select.getScientificName()+
					   "\nIdeal Light: " + DataReader.convertLightInt(select.getWaterIntake())+
					   "\nIdeal Water: " + DataReader.convertWaterInt(select.getLightIntake())+
					   "\nMax Height: " +  select.getHeight() + " feet"
						);
				alert.setContentText(msg);
				alert.showAndWait();

			}
		});
	}

	// Getters:
	public Button getRatingButton() {
		return ratingButton;
	}
	
	public Button getAddYearBtn() {
		return addYearBtn;
	}

	public Button displayPlantBtn() {
		return displayPlantBtn;
	}
	
	public Button getExportButton() {
		return exportButton;
	}
	public ListView<Plant> getMenu() {
		return menu;
	}

	public Button getAddPlantBtn() {
		return addPlantBtn;
	}

	public Button getAddWoodsBtn() {
		return addWoodsBtn;
	}

	public Button getAddPondBtn() {
		return addPondBtn;
	}

	public Button getAddLawnBtn() {
		return addLawnBtn;
	}

	public ImageView getIvSelection() {
		return ivSelection;
	}
	
	public ArrayList<ImageView> getCenterWorkspaceIvList(){
		return centerWorkspaceIvList;
	}

	public ImageView getIvWoods() {
		return ivWoods;
	}

	public ImageView getIvLawn() {
		return ivLawn;
	}

	public ImageView getIvPond() {
		return ivPond;
	}

	public Button getWinterBtn() {
		return winterBtn;
	}

	public Button getSpringBtn() {
		return springBtn;
	}

	public Button getSummerBtn() {
		return summerBtn;
	}

	public Button getFallBtn() {
		return fallBtn;
	}
	
	public Button getSortByWaterBtn()
	{
		return sortByWaterBtn;
	}
	public Button getSortByLightBtn()
	{
		return sortByLightBtn;
	}

	public void generateFlower(ImageView newIv) 
	{
		newIv.setPreserveRatio(true);
		String type = "";
		for (Plant p: modelPlantList)
		{
			if (p.getID()==currentID)
			{
				type = p.getPlantType();
			}
		}
		switch(type)
		{
			case("tree"):
				newIv.setFitHeight(200);
				break;
			case("shrub"):
				newIv.setFitHeight(100);	
				break;
			case("flower"):
				newIv.setFitHeight(50);
				break;
			case("fern"):
				newIv.setFitHeight(75);
				break;
			case("grass"):
				newIv.setFitHeight(50);
				break;
		}
		centerWorkspace.getChildren().add(newIv);
		centerWorkspaceIvList.add(newIv);
		String currentSeason = theLawn.getSurveyBloomTimePlaceHolder();
		
		//changes the saturation to user selected season
		if (currentSeason.equals("Fall"))
			View.changeSaturation(Season.FALL);
		else if (currentSeason.equals("Spring"))
			View.changeSaturation(Season.SPRING);
		else if (currentSeason.equals("Summer"))
			View.changeSaturation(Season.SUMMER);
		else
			View.changeSaturation(Season.WINTER);
	}

	public void generateWoods(ImageView newIv) {
		newIv.setPreserveRatio(true);
		newIv.setFitHeight(200);
		centerWorkspace.getChildren().add(newIv);
		centerWorkspaceIvList.add(newIv);
	}

	public void generatePond(ImageView newIv) {
		newIv.setPreserveRatio(true);
		newIv.setFitHeight(100);
		centerWorkspace.getChildren().add(newIv);
		centerWorkspaceIvList.add(newIv);
	}

	public void generateLawn(ImageView newIv) {
		newIv.setPreserveRatio(true);
		newIv.setFitHeight(80);
		centerWorkspace.getChildren().add(newIv);
		centerWorkspaceIvList.add(newIv);
	}

	public void addPlantData() {
		System.out.println("addPlantData was called");
		Plant currentSelection = menu.getSelectionModel().getSelectedItem();
		for (Plant p : modelPlantList) {
			if (p.getScientificName().equals(currentSelection.getScientificName())) {
				centerWorkspacePlantList.add(p);
				System.out.println("Adding: " + p);
			}
		}
		System.out.println("Here is the current list:");
		for (Plant p : centerWorkspacePlantList) {
			System.out.println(p);
		}
	}

	public void buildNameList(ObservableList<String> nameList) {
		for (Plant p : modelPlantList) {
			nameList.add(p.getScientificName() + " (" + p.getName() + ")");
		}
	}

	// Methods for building the different sections of the lawn screen:
	public Scene buildLawnScreen(Lawn l) 
	{
		theLawn = l;
		buildNameList(nameList);
		leftMenu = buildLeftMenu("water");
		rightMenu = buildRightMenu();
		topMenu = buildTopMenu();
		bottomMenu = buildBottomMenu();
		centerWorkspace = buildCenterWorkspace();

		root.setLeft(leftMenu);
		root.setTop(topMenu);
		root.setRight(rightMenu);
		root.setBottom(bottomMenu);
		root.setCenter(centerWorkspace);

		return theScene;
	}

	// Sorts 
	public ObservableList<Plant> sortNameList(String x, ObservableList<Plant> sortedPlantList2) 
	{
		int length = sortedPlantList2.size();
		for (int i =length-1;i>=0;i--)
		{
			sortedPlantList2.remove(i);
		}
		System.out.println(sortedPlantList2);
		System.out.println("Resorting List...");
		ArrayList<Plant> endNames = new ArrayList<>();
		switch(x)
		{
			case("water"):	
				System.out.println("Placing water matches first...");
				for (Plant p: modelPlantList)
				{
					if (p.getWaterIntake()==theLawn.getSurveyWaterLevel())
					{
						sortedPlantList2.add(p);
					}
					else
						endNames.add(p);
				}
				System.out.println("Placed!");
			break;
			case("light"):
				System.out.println("Placing light matches first...");
				for (Plant p: modelPlantList)
				{
					if (p.getLightIntake()==theLawn.getSurveyLightLevel())
					{
						sortedPlantList2.add(p);
					}
					else
						endNames.add(p);
				}
				System.out.println("Placed!");
				break;
		default:
			System.out.println("invalid sort variable");}
		for (Plant s: endNames)
		{
			sortedPlantList2.add(s);
		}
		System.out.println("Resorting complete.");
		System.out.println(sortedPlantList2);
		return sortedPlantList2;
	}

	public HBox buildBottomMenu() {
		HBox hbox = new HBox();
		hbox.setStyle("-fx-background-color: #336699;");
		hbox.getChildren().addAll(sortByWaterBtn,sortByLightBtn,ratingButton, exportButton);
		hbox.setPadding(new Insets(10, 5, 10, 5));
		hbox.setSpacing(20);
		hbox.setAlignment(Pos.CENTER);
		return hbox;
	}

	public VBox buildLeftMenu(String var) {
		
		sortedPlantList = sortNameList(var,sortedPlantList);
		VBox vbox = new VBox();
		vbox.setStyle("-fx-background-color: #D5D5D5");
		ivSelection.setPreserveRatio(true);
		ivSelection.setFitHeight(200);
		
		menu.setItems(sortedPlantList);
	
		vbox.getChildren().addAll(displayPlantBtn,ivSelection, menuLabel, menu, addPlantBtn);
		vbox.setAlignment(Pos.TOP_CENTER);

		return vbox;
	}

	public VBox buildRightMenu() {
		VBox vbox = new VBox();
		vbox.setStyle("-fx-background-color: #D5D5D5");
		// labels
		ivWoods.setPreserveRatio(true);
		ivWoods.setFitHeight(70);
		ivLawn.setPreserveRatio(true);
		ivLawn.setFitHeight(70);
		ivPond.setPreserveRatio(true);
		ivPond.setFitHeight(70);
		// formatting labels
		vbox.getChildren().addAll(ivWoods, ivLawn, ivPond, addLawnBtn, addWoodsBtn, addPondBtn);
		vbox.setPadding(new Insets(10, 5, 10, 5));
		vbox.setSpacing(40);
		vbox.setAlignment(Pos.TOP_CENTER);

		return vbox;
	}

	public HBox buildTopMenu() {
		HBox hbox = new HBox();
		hbox.setStyle("-fx-background-color: #AFECFF;");

	
		HBox seasonBtnGroup = new HBox();
		seasonBtnGroup.getChildren().addAll(winterBtn, springBtn, summerBtn, fallBtn);

		hbox.getChildren().addAll(seasonBtnGroup, addYearBtn);
		hbox.setPadding(new Insets(25));
		hbox.setSpacing(50);
		hbox.setAlignment(Pos.CENTER_RIGHT);
		return hbox;
	}

	public FlowPane buildCenterWorkspace() {
		FlowPane fp = new FlowPane();
		String soil = theLawn.getSurveySoilLevel();
		
		//background color based on soil type
		switch(soil) {
			case("Clay"):
				fp.setStyle("-fx-border-color: black; -fx-background-color: #9BB69B;");
				break;
			case("Silty"):
				fp.setStyle("-fx-border-color: black; -fx-background-color: #6DA968;");
				break;
			case("Sandy"):
				fp.setStyle("-fx-border-color: black; -fx-background-color: #FED99B;");
				break;
			case("Chalky"):
				fp.setStyle("-fx-border-color: black; -fx-background-color: #6DA968;");
				break;
			case("Loamy"):
				fp.setStyle("-fx-border-color: black; -fx-background-color: #234F1F;");
				break;
			case("Peaty"):
				fp.setStyle("-fx-border-color: black; -fx-background-color: #45341D;");
				break;
		}
		
		
		fp.setAlignment(Pos.TOP_LEFT);
		if (centerWorkspaceIvList.size() != 0) {
			for (int i = 0; i < centerWorkspaceIvList.size(); i++) {
				fp.getChildren().add(centerWorkspaceIvList.get(i));
			}
		}
		return fp;
	}

	private void takeSnapShot(Scene scene) {
		WritableImage writableImage = new WritableImage(WINDOW_WIDTH, WINDOW_HEIGHT);
		scene.snapshot(writableImage);

		File file = new File("snapshot.png");
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(writableImage, null), "png", file);
			System.out.println("snapshot saved: " + file.getAbsolutePath());
		} catch (IOException ex) {
			Logger.getLogger(LawnScreen.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/*
	 * updateSelection(): Changes the image of the top left "select plant" icon
	 * 
	 * parameter: "selectedID"[int] this will represent the ID of the current plant
	 * selected from the menu side effect: uses the parameter to adjust the image of
	 * the selected plant (right now it is random 1-4 since we don't have all the
	 * images) returns: nothing
	 */
	public void updateSelection(Plant plant) {
		for (Plant p : modelPlantList) {
			
			if (p.equals(plant)) {
				currentID = p.getID();
			}
		}
		ivSelection.setImage(ImageConverter.getImageFromID(currentID));
	}
	/*
	public Scene updateLabel(Plant p)
	{
		
	}*/

	public Scene updateMenu(String var) 
	{
		leftMenu = buildLeftMenu(var);
		root.setLeft(leftMenu);
		root.setTop(topMenu);
		root.setRight(rightMenu);
		root.setBottom(bottomMenu);
		root.setCenter(centerWorkspace);
		System.out.println("Menu updated!");
		return theScene;

	}
}
