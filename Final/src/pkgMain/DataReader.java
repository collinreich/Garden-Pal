package pkgMain;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class DataReader {

	/**
	 * Reads in each line from a given file
	 * @param filename - file to be read in
	 * @return records - list of strings that where each string is a
	 * 		line from the file that indicates a record of a plant
	 */
	public static List<String> readFile(File filename) {
		List < String > records = new ArrayList < String > ();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				records.add(line);
				}
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
		}
		return records;
	}
	
	/**
	 * Takes in the light level string from the record and converts it
	 * to an int that can be used to create a plant object
	 * @param lightLevel
	 * @return
	 */
	public static int convertLight(String lightLevel) {
		int light = 0;
		switch(lightLevel) {
		case "F":
			light = 5;
			break;
		case "P":
			light = 3;
			break;
		case "S":
			light = 1;
			break;
		case "F-P":
			light = 4;
			break;
		case "F-S":
			light = 3;
			break;
		case "P-S":
			light = 2;
			break;
		case "P-F":
			light = 4;
			break;
		case "S-P":
			light = 2;
			break;
		case "S-F":
			light =3;
			break;
		default:
			throw new IllegalArgumentException("Error: convertLight was given an invalid lightLevel");
		}
		return light;
	}
	
	
	/**
	 * Takes in the water level string from the record and converts it
	 * to an int that can be used to create a plant object
	 * @param waterLevel
	 * @return
	 */
	public static int convertWater(String waterLevel) {
		int water = 0;
		switch(waterLevel) {
		case "W":
			water = 5;
			break;
		case "A":
			water = 3;
			break;
		case "D":
			water = 1;
			break;
		case "W-A":
			water = 4;
			break;
		case "W-D":
			water = 3;
			break;
		case "A-W":
			water = 4;
			break;
		case "A-D":
			water = 2;
			break;
		case "D-W":
			water = 3;
			break;
		case "D-A":
			water = 2;
			break;
		default:
			throw new IllegalArgumentException("Error: convertWater was given an invalid waterLevel");
		}
		return water;
	}
	
	
	
	/**
	 * Takes in the height string from the record and converts it to a float that can
	 * be used to create a plant object
	 * @param height - string representing the height range of the plant
	 * @return maxHeight - float representing the maximum height of the plant in feet
	 */
	public static float convertHeight(String height) {
		char feet = '\'';
		char inches = '\"';
		float maxHeight = 0;
		int value = 0;
		
		//Case for when the height is given with a plus sign
		if(height.contains("+")) {
			value = Integer.parseInt(height.substring(1, height.indexOf("+")));
			if(height.charAt(height.length()-2) == feet) {
				maxHeight = (float)value;
			}
			else if(height.charAt(height.length()-2) == inches) {
				maxHeight = value/12;
			}
		}
		//All other instances
		else {
			String subString = height.substring(height.length()-4, height.length()-2);
			subString = subString.replaceAll("[^a-zA-Z0-9]", "");
			value = Integer.parseInt(subString);
			if(height.charAt(height.length()-2) == feet) {
				maxHeight = (float)value;
			}
			else if(height.charAt(height.length()-2) == inches) {
				maxHeight = value/12;
			}
		}
		return maxHeight;
	}
	
	public static ArrayList<Plant> getDataFromReader() {
		File filename = new File("database.txt");
		List<String> records = readFile(filename);
		ArrayList<Plant> plantList = new ArrayList<Plant>();
		
		for(int i = 0; i < records.size(); i++) {
			records.set(i, records.get(i).replaceAll("[()]", ""));
			String[] record = records.get(i).split(",");
			record[3] = record[3].replaceAll("[']", "");
			record[4] = record[4].replaceAll("[']", "");
			Plant p = new Plant(record[0], record[1], record[2], convertLight(record[3].trim()), convertWater(record[4].trim()), convertHeight(record[5].trim()), i+1);
			plantList.add(p);
		}
		return plantList;
		
	}

	public static String convertWaterInt(int x) {
		String ret="";
		switch(x)
		{
		case(1):
			ret= "Dry";
		break;
		case(2):
			ret= "Mostly Dry";
		break;
		case(3):
			ret="Average";
		break;
		case(4):
			ret= "Mostly Wet";
		break;
		case(5):
			ret= "Wet";
		break;
		}
		return ret;
	}
	
	public static String convertLightInt(int x) {
		String ret="";
		switch(x)
		{
		case(1):
			ret= "Full Shade";
		break;
		case(2):
			ret= "Partial Shade";
		break;
		case(3):
			ret="Average";
		break;
		case(4):
			ret= "Partial Sun";
		break;
		case(5):
			ret= "Full Sun";
		break;
		}
		return ret;
	}
}
