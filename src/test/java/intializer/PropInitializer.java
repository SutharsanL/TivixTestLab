package intializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropInitializer {
public static	Properties prop;

	public static void initialize() throws IOException{

	File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\data.properties");

FileInputStream fis = new FileInputStream(file);

 	prop = new Properties();
	prop.load(fis);
	
	
	}

}
