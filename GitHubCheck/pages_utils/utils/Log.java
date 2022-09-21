/**
 * 
 */
package utils;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @author ragesh
 *
 */
public class Log {

	// Initialize Log4j logs

	private static Logger Log = Logger.getLogger(Log.class.getName());//

	static {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	public static void configure() {
		PropertyConfigurator.configure("log4j.properties");
	}

	public static void info(String message) {
		configure();
		Log.info(message);

	}

	public static void warn(String message) {
		configure();
		Log.warn(message);

	}

	public static void error(String message) {
		configure();
		Log.error(message);

	}

	public static void fatal(String message) {
		configure();
		Log.fatal(message);

	}

	public static void debug(String message) {
		configure();
		Log.debug(message);

	}
}
