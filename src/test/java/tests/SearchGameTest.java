package tests;

import listeners.TestListeners;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.ExcelReader;

import java.io.IOException;


@Listeners(TestListeners.class)
public class SearchGameTest
{
    @Test
    void searchGameTest()
    {

    }

    @DataProvider
    public Object[][] getData()
    {
        Object[][] data = null;
        try
        {
            data = ExcelReader.readExcelFile("src/test/resources/filesDane.xlsx");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return data;
    }
}
