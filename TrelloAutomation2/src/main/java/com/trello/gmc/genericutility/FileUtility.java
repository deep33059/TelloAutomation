package com.trello.gmc.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @authorCodeRoverAbhay
 */
public class FileUtility {
	/**
	 * readPropertyFileData method is used to retrieve the data of specified 'key' form Properties file
	 * @param key
	 * @return value of specified key
	 * @throws IOException
	 */
	public String readPropertyFileData(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/trellocommondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}