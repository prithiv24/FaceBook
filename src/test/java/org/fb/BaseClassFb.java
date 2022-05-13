package org.fb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassFb {
	public static WebDriver driver;
	public static HSSFWorkbook workbook;;
	public static HSSFSheet createSheet;
	public static HSSFRow createRow;
	public static void launchromeDriver() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public static void implicitwait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static void URL(String url) {
		driver.get(url);
	}

	public static  void sendText(WebElement element, String text) {
		element.sendKeys(text);
	}
	public static void click(WebElement element) {
		element.click();

	}
	public static String readTheExcell(String name1, int rownum, int column) throws IOException {
		File file = new File("C:\\Users\\Prithiv\\eclipse-workspace\\FaceBook\\TestData\\FaceBook.xlsx");
		FileInputStream read = new FileInputStream(file);

		Workbook book = new XSSFWorkbook(read);
		Sheet sheet = book.getSheet(name1);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(column);
		int type = cell.getCellType();
		String name ="";
		if (type==1) {
			name=cell.getStringCellValue();

		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat d= new SimpleDateFormat("dd,MMMM,yyyy");
			name = d.format(date);
		}
		else {
			double CellValue = cell.getNumericCellValue();
			long l = (long)CellValue;
			name= String.valueOf(l);
		}
		return name;
	}

	public static void writeInExcel( String value) throws IOException {
		HSSFWorkbook book = new HSSFWorkbook();
		HSSFSheet sheet = book.getSheet("prithiv");		
		sheet.createRow(0);
		sheet.getRow(0).createCell(0).setCellValue(value);

		File file = new File("C:\\Users\\Prithiv\\eclipse-workspace\\FaceBook\\TestData\\FaceBook.xlsx");
		book.write(file);
		book.close();








	}

}
