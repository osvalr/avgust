package sernanp.app.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
	
	public static PropUtil getInstance(){
		return new PropUtil();
	}
	
    public String getPropVal(String propFile, String key) {
    	 
        String result = null;
        Properties prop = new Properties();
        String propFileName = propFile;
        
        try {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			prop.load(inputStream);
		
        if (inputStream == null) {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
 
        // get the property value and print it out
        result = prop.getProperty(key);
 
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return result;
    }
}
