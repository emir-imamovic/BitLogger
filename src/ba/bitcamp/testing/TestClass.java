package ba.bitcamp.testing;

import java.io.FileNotFoundException;
import java.util.HashMap;

import ba.bitcamp.logger.Logger;

public class TestClass {
	public static void main(String[] args) {

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("Application", "Application");
		map.put("Warning", "Warning");
		map.put("Error", "Error");
		try {
			new Logger(map);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Logger.log("Application", "Application");
		Logger.log("Warning", "Warning");
		Logger.log("Error", "Error");
	}
}
