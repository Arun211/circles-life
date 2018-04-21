package org.circles.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author arunkumar 
 * 
 * The Class ReadProperty - Enables to read from properties file.
 */
public class ReadProperty {

	private static final Logger LOGGER = Logger.getLogger(ReadProperty.class);
	
	private Properties properties = null;
	
	/**
	 * Instantiates a new read property.
	 */
	public ReadProperty() {
		createPropertyObject();
	}
	
	/**
	 * Creates the property object.
	 */
	private void createPropertyObject() {
		properties = new Properties();
		try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream("AUT_Conf.properties")) {
			properties.load(inputStream);
		}
		catch (IOException ioException) {
			LOGGER.fatal("Unable to load properties file - "+ioException.getMessage());
		}
	}
	
	/**
	 * Gets the value.
	 *
	 * @param key the key
	 * @return the value
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}
}
