package core.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class GenerateTestReport {
	Logger logger=GetLogger.getLogger();
	public void generateCucumberReport() {
		logger.info("Report Generation Started.");
		String fileName = System.getProperty("user.dir")+"1001";
		long build = readLong(fileName, 1L);
		String buildNumber = Long.toString(build);
		try {
			writeLong(fileName, readLong(fileName, 1L)+1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File reportOutputDirectory = new File("target/build"+buildNumber);
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add(System.getProperty("user.dir") + "\\target\\cucumber.json");

		String projectName = "GSRestAssuredFramework";
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setBuildNumber(buildNumber);

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
		logger.info("Report Generation Done.");
	}

	public static void writeLong(String filename, long number) throws IOException {
		try (DataOutputStream dos = new DataOutputStream(
				new FileOutputStream(filename))) {
			dos.writeLong(number);
		}
	}

	public static long readLong(String filename, long valueIfNotFound) {
		if (!new File(filename).canRead())
			return valueIfNotFound;
		try (DataInputStream dis = new DataInputStream(
				new FileInputStream(filename))) {
			return dis.readLong();
		} catch (IOException ignored) {
			return valueIfNotFound;
		}
	}

}