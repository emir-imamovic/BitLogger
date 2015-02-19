package ba.bitcamp.logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Creating logs and saving into the file
 * @warning needed "logs" folder
 * @author emirimamovic
 *
 */
public class Logger {
	public static HashMap<String, FileOutputStream> logs = new HashMap<String, FileOutputStream>();
/**
 * Initializing FileOutputStream-s for that log types
 * @param logType - HashMap - Key(LogType), Value(FileName)
 * @throws FileNotFoundException
 */
	public Logger(HashMap<String, String> logType) throws FileNotFoundException {
		String basePath = "." + File.separator + "logs" + File.separator; // univerzalni path
																			
		Set<String> keys = logType.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String value = logType.get(key);
			File file = new File(basePath + value + ".txt");
			FileOutputStream fos = new FileOutputStream(file, true);
			logs.put(key, fos);
		}
	}
/** 
 * This method take message, add Date and save into the file
 * @param type - log type
 * @param message - message 
 * @warning - if type is not initialized, logs is not saved
 */
	public static void log(String type, String message) {
		if(!logs.containsKey(type)) {
			return;
		}
		Date date = new Date();
		message = date.toString() + " " + message + "\n";

		FileOutputStream fos = logs.get(type);
		try {
			fos.write(message.getBytes());
			fos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
