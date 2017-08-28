package com.cache.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;


public class PropertiesUtil {

	protected static Logger logger = Logger.getLogger(PropertiesUtil.class);
	
	public static String getProperty(String srcPropertiesName, String key) {
		Properties properties = getPropertiesMap(srcPropertiesName);
		String value = properties.getProperty(key);
		return value;
	}
	
	public static Properties getPropertiesMap(String srcProperiesName) {
		InputStream is = null;
		Properties properties = new Properties();
		is = PropertiesUtil.class.getClassLoader().getResourceAsStream(srcProperiesName);
		try {
			properties.load(is);
		} catch (IOException e) {
			logger.error("load property file failed", e);
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties;
	}
	
	
	public static void main(String[] args) {
		Properties p = PropertiesUtil.getPropertiesMap("cache.properties");
		String value = p.getProperty("enable");
		System.out.println(value);
	}
}
