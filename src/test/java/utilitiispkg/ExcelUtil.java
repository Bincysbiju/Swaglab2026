package utilitiispkg;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static Object[][] getTestData(String excelPath, String sheetName) throws IOException {
        FileInputStream fis = new FileInputStream(excelPath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];
        DataFormatter formatter = new DataFormatter();

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = formatter.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }
        workbook.close();
        fis.close();
        return data;
    }

}
