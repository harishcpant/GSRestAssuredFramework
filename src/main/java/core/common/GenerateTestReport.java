package core.common;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class GenerateTestReport {

	public void generateCucumberReport() {
		String fileName = System.getProperty("user.dir")+"1001";
		long build = readLong(fileName, 1L);
		String buildNumber = Long.toString(build);
		try {
			writeLong(fileName, readLong(fileName, 1L)+1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//String buildNumber = "1001";
		File reportOutputDirectory = new File("target/build"+buildNumber);
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add(System.getProperty("user.dir") + "\\target\\cucumber.json");

		String projectName = "GSRestAssuredFramework";
		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		configuration.setBuildNumber(buildNumber);

//		configuration.addClassifications("Browser", "Chrome");
//		configuration.addClassifications("Branch", "release/1.0");
//		configuration.addClassifications("Server", BaseTestStepDef.server);
//		configuration.setSortingMethod(SortingMethod.NATURAL);
//		configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
//		configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);
//		configuration.setTrendsStatsFile(new File("target/test-classes/demo-trends.json"));

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
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