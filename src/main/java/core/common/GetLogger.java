package core.common;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GetLogger {
	
	public static Logger logger=LogManager.getLogger(GetLogger.class);
	public static Logger getLogger()
	{
		return logger;		
	}
}

