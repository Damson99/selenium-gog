package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelReader
{

    public static Object[][] readExcelFile(String path) throws IOException
    {
        InputStream in = new FileInputStream(path);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        Sheet sheet = workbook.getSheetAt(0);
        int rowNumbers = sheet.getLastRowNum();
        int columnNumbers = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rowNumbers][columnNumbers];

        for(int i = 0; i < rowNumbers; i++)
        {
            Row row = sheet.getRow(i + 1);
            for(int j = 0; j < row.getLastCellNum(); j++)
                data[i][j] = row.getCell(j).getStringCellValue();
        }

        return data;
    }
}
