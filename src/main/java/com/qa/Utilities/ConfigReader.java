package com.qa.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	 private static Properties prop;

	    static {
	        try {
	        	//FileInputStream is used when you want to read a file as raw data (binary or text).
	            FileInputStream fp = new FileInputStream("src/main/java/com/qa/config/config.properties");
	            prop = new Properties();
	            //It loads the contents of the file into the prop object.
//It parses the file line-by-line and extracts key-value pairs.
	            prop.load(fp);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Could not load config.properties file");
	        }
	    }

	    public static String getProperty(String key) {
	        return prop.getProperty(key);
	    }
}
