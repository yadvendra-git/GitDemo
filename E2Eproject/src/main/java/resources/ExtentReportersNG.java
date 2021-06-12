package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportersNG {
	public static ExtentReports extReport;
public static ExtentReports getExtentObject()
{
//ExtentReports, ExtentSparkReporter
//Setting the configuration using helper class ExtentSparkReporter
String path=System.getProperty("user.dir")+"\\reports\\index.html"; //"user.dir" gives path till project in this case till mavenjava after that we need to give the path for report
ExtentSparkReporter report=new ExtentSparkReporter(path); 
report.config().setReportName("Web automation Results"); //Setting the report name
report.config().setDocumentTitle("Test Results");   //Setting the page title

//ExtentReports is main class and takes care of consolidating all the data and generating report
extReport = new ExtentReports();
extReport.attachReporter(report);
extReport.setSystemInfo("Tester", "Verma");
return extReport;
}
}
