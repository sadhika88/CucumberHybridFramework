package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	public   Properties initializeProperties() throws FileNotFoundException {
		Properties prop=new Properties();
		File proFile=new File(System.getProperty("user.dir") +"\\src\\test\\resources\\config\\config.properties");
		try {
		FileInputStream fis=new FileInputStream(proFile);
		prop.load(fis);
		}catch (Throwable e) {
			e.printStackTrace();
		}
		return prop;
		
	}
}
