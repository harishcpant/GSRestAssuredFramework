package perf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class logTest {

	static Logger log=LogManager.getLogger(logTest.class);
	public static void main(String[] args) {
		System.out.println("This is logTest file..");
		log.debug("This is a Debug2 Statement..");
		log.info("This is a Info2 Statement..");
	}

}
