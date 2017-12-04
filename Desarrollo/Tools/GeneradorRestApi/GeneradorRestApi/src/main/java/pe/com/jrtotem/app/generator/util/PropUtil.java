package pe.com.jrtotem.app.generator.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {

	public static PropUtil getInstance() {
		return new PropUtil();
	}

	@SuppressWarnings("unused")
	public String getPropVal(String propFile, String key) {

		String result = null;
		Properties prop = new Properties();
		String propFileName = propFile;

		try {
			InputStream inputStream = new FileInputStream(propFileName);// getClass().getClassLoader().getResourceAsStream(propFileName);

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
