package co.com.pragma.certification.abilities;

import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadSpreadsheet implements Ability {
    private String filePath;
    private String sheetName;
    private static XSSFSheet xssfSheet;

    public ReadSpreadsheet(String filePath, String sheetName) {
        this.filePath = filePath;
        this.sheetName = sheetName;
        setFile(filePath, sheetName);
    }

    public static ReadSpreadsheet as(Actor actor){
        return actor.abilityTo(ReadSpreadsheet.class);
    }

    public static ReadSpreadsheet by(String filePath, String sheetName){
        return new ReadSpreadsheet(filePath, sheetName);
    }

    public void setFile(String filePath, String sheetName){
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            xssfSheet = xssfWorkbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getCellData(int rowNumber, int columnNumber){
        XSSFRow xssfRow = xssfSheet.getRow(rowNumber);
        XSSFCell xssfCell = xssfRow.getCell(columnNumber);
        return xssfCell.getStringCellValue();
    }
}
