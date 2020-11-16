package listeners;


import exceptions.NoSuchDriverException;
import factory.DriverFactory;
import factory.DriverTypeEnum;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenShooter;

import java.io.IOException;

public class TestListeners implements ITestListener
{
    Logger log = Logger.getLogger(ITestListener.class);

    @Override
    public void onTestStart(ITestResult result)
    {
        log.debug("test started");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        log.debug("test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.debug("test failed");
        try
        {
            ScreenShooter.takeScreenshot(DriverFactory.getDriver(DriverTypeEnum.CHROME));
        }
        catch (IOException | NoSuchDriverException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        log.debug("test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        log.debug("test failed but within success percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result)
    {
        log.debug("test failed with timeout");
    }

    @Override
    public void onStart(ITestContext context)
    {
        log.debug("test started");
    }

    @Override
    public void onFinish(ITestContext context)
    {
        log.debug("test finished");
    }
}
