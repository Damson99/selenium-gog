package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShooter
{
    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss'.png'");

    public static void takeScreenshot(WebDriver webDriver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) webDriver;
        File ssFile = screenshot.getScreenshotAs(OutputType.FILE);
        File path = new File("src/main/resources/screenshots/" + date.format(new Date()));
        FileUtils.copyFile(ssFile, path);
    }
}
