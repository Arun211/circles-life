package org.circles.automation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// TODO: Auto-generated Javadoc
/**
 * The Class ReadProperty.
 */
public class ReadProperty {
	
	/** The properties. */
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
			System.out.println("Properties file load failed - "+ ioException.getMessage());
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
