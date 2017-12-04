#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

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
 
        result = prop.getProperty(key);
 
        } catch (IOException e) {
			e.printStackTrace();
		}
        
        return result;
    }
}
