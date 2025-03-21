package org.krishnaIT.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static ExtentReports getInstance() {
        if (extent == null) {
            try {
                ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
                spark.loadXMLConfig("src/test/resources/extent-config.xml"); // Load custom config
                extent = new ExtentReports();
                extent.attachReporter(spark);
            } catch (IOException e) {
                e.printStackTrace(); // Logs the error
            }
        }
        return extent;
    }


    public static ExtentTest startTest(String testName) {
        ExtentTest extentTest = getInstance().createTest(testName);
        test.set(extentTest);
        return extentTest;
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void endTest() {
        getInstance().flush();
    }
}
