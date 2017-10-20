package lessons;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import au.com.bytecode.opencsv.CSVReader;

public class ReadPropertiesFile {
	public static String browser_name;
	public static String server_url;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		InputStream input = new FileInputStream(".\\DataFiles\\config.properties");
		p.load(input);
		
		browser_name = p.getProperty("browserName");
		server_url = p.getProperty("serverUrl");
		System.out.println(browser_name);
		System.out.println(server_url);
		input.close();
	}
}
