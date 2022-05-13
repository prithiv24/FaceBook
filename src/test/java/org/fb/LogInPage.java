package org.fb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.openqa.selenium.WebElement;

public class LogInPage extends BaseClassFb{

	public static void main(String[] args) throws IOException  {

		launchromeDriver();
		maximize();
		implicitwait();
		URL("https://www.facebook.com/");
		PojoFbLogIn p= new PojoFbLogIn();
		sendText(p.getEmail(), readTheExcell("prithiv", 1, 0));
		sendText(p.getPassword(), readTheExcell("prithiv", 1, 1));		
		click(p.getLogIn());
		String text = p.getGetText().getText();
		System.out.println(text);

		HSSFWorkbook book = new HSSFWorkbook();
		HSSFSheet sheetAt = book.createSheet();
		HSSFRow createRow2 = sheetAt.createRow(0);
		sheetAt.getRow(0).createCell(0).setCellValue("FB Error Message");
		sheetAt.createRow(1);
		sheetAt.getRow(1).createCell(0).setCellValue(text);
		File file = new File("C:\\Users\\Prithiv\\eclipse-workspace\\FaceBook\\TestData\\fbmessage.xlsx");
		book.write(file);
		book.close();

	}

}
