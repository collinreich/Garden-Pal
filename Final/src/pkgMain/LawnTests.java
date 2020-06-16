package pkgMain;

// beta
// partners: Olivia Caponigro, Talia Feldman, Collin Reich, Paul Traumiller, Camryn Isaksen

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;


public class LawnTests {

	@Test
	public void labelLawnTest() {
		Lawn lawn = new Lawn();
		Label poolLabel = new Label("pool");
		lawn.labelLawn("pool");
		assertEquals(lawn.labelList.contains(poolLabel), true);
	}

	@Test
	public void addPlantsTest() {
		Lawn lawn = new Lawn(); 
		Plant myPlant = new Plant("rose");
		lawn.addPlants(myPlant);
		assertEquals(lawn.plantList.contains(myPlant), true);
	}

	@Test
	public void lawnShapeTest() {
		Lawn lawn = new Lawn();
		Rectangle rectangle = new Rectangle(200, 200, 300, 100);
		lawn.lawnShape(rectangle);
		assertEquals(lawn.shapeList.contains(rectangle), true);
	}

	@Test
	public void updateSeason() {
		Lawn lawn = new Lawn();
		Season winter = Season.WINTER;
		lawn.updateSeason("winter", Season.WINTER);
		assertEquals(lawn.currentSeason, winter);
	}

}