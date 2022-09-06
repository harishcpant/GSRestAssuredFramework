package core.api;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetProperties {
	public static Properties getConfig()
	{
		FileReader reader;
		Properties p = null;
		try {
			reader=new FileReader("src/test/resources/Properties/apiURL.properties");
			p=new Properties();			
			p.load(reader);		
			
		} catch (IOException e) {
			
		}
		
		return p;			
	}
}
