//package cucumber.Options;
//
//import org.junit.AfterClass;
//import org.junit.runner.RunWith;
//
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//		features = "src\\test\\resources\\features",
//		glue = { "stepDefinitions" },
//		plugin = {"json:target/cucumber.json" },
//		stepNotifications = true)
//
//public class TestRunnerJUnit {
//
//	@AfterClass
//	public void teardown() {
//		System.out.println("hello after called..");
//	}
//}