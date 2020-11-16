package tests;

import exceptions.NoSuchDriverException;
import factory.DriverFactory;
import factory.DriverTypeEnum;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;


public class BaseTest
{
    protected WebDriver webDriver;
    Logger log = Logger.getLogger(BaseTest.class);

    @AfterMethod
    public void setUp() throws NoSuchDriverException
    {
        log.debug("Before Test");
        webDriver = DriverFactory.getDriver(DriverTypeEnum.CHROME);
    }

    @AfterMethod
    public void tearDown()
    {
        log.debug("After Test");
        webDriver.quit();
        DriverFactory.resetDriver();
    }
}
