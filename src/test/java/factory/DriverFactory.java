package factory;

import exceptions.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

import java.io.File;

public class DriverFactory
{
    private static WebDriver driverInstance;


    public static WebDriver getDriver(DriverTypeEnum driverType) throws NoSuchDriverException
    {
        if(driverInstance == null)
        {
            getDriverByBrowser(driverType);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }

    private static void getDriverByBrowser(DriverTypeEnum driverType) throws NoSuchDriverException
    {
        switch (driverType)
        {
            case CHROME:
                File chrome = new File("src/test/resources/driver/chromedriver.exe");
                ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chrome)
                        .usingAnyFreePort()
                        .build();
                driverInstance = new ChromeDriver(chromeDriverService);
                break;
            case IE:
                File exe = new File("src/test/resources/driver/IEDriverServer.exe");
                InternetExplorerDriverService IEDriverService = new InternetExplorerDriverService.Builder()
                        .usingDriverExecutable(exe)
                        .usingAnyFreePort()
                        .build();
                driverInstance = new InternetExplorerDriver(IEDriverService);
                break;
            case FIREFOX:
                File firefox = new File("src/test/resources/driver/geckodriver.exe");
                GeckoDriverService firefoxDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(firefox)
                        .usingAnyFreePort()
                        .build();
                driverInstance = new FirefoxDriver(firefoxDriverService);
                break;
            default:
                throw new NoSuchDriverException();
        }
    }
}
