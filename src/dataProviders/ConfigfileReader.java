package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class ConfigfileReader {
	private static Properties properties;
	private final String configFilePath ="D:\\JavaPactice\\SelenuimPrac\\src\\config\\OR.properties";
	
	public ConfigfileReader() {
		
	try {

	BufferedReader reader=new BufferedReader(new FileReader(configFilePath));
	properties=new Properties();
	try {
	properties.load(reader);
	reader.close();
	} catch(IOException e){
		e.printStackTrace();
	}
	
	} catch (FileNotFoundException e)
	{
		e.printStackTrace();
		throw new RuntimeException ("Config file not found" +configFilePath);
	}
}

public static String getORProperties(String Object)
{
	String ob= properties.getProperty(Object);
	if (ob==null)
	{
		throw new RuntimeException("Property not mentioned in config file");
	} else 
	return ob;
	
	
}
}




