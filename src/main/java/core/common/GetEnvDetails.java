package core.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class GetEnvDetails {
	public static Properties getEnvDetails()
	{
		FileReader reader;
		Properties p = null;
		try {
			reader=new FileReader("src/test/resources/Properties/env.properties");
			p=new Properties();			
			p.load(reader);		
			
		} catch (IOException e) {
			
		}
		
		return p;			
	}
}
