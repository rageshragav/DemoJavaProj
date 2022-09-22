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

	//private static Logger Log = Logger.getLogger(Log.class.getName());//
	private static Logger Log;
	static {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	public static void configure(String classNm) {
		Log = Logger.getLogger(classNm);//
		PropertyConfigurator.configure("log4j.properties");
	}

	public static void info(String message,String className) {
		configure(className);
		Log.info(message);

	}

	public static void warn(String message,String className) {
		configure(className);
		Log.warn(message);

	}

	public static void error(String message,String className) {
		configure(className);
		Log.error(message);

	}

	public static void fatal(String message,String className) {
		configure(className);
		Log.fatal(message);

	}

	public static void debug(String message,String className) {
		configure(className);
		Log.debug(message);

	}
}
