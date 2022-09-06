package core.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class GetEnvDetails extends GetLogger {
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
