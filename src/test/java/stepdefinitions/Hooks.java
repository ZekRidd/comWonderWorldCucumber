package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take Screenshot
            File srcFile = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);

            // Unique name for screenshot
            String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + timeStamp + ".png";

            try {
                FileUtils.copyFile(srcFile, new File("target/screenshots/" + screenshotName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Add screenshot to report
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        Driver.closeDriver();
    }
}
