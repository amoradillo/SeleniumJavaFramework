package ave4testing.resources;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
     String path = System.getProperty("user.dir")+"//reports//index.html";
     ExtentSparkReporter report = new ExtentSparkReporter(path);

}
