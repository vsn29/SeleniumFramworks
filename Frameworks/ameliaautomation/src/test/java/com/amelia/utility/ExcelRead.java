package com.amelia.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public String readTestCaseData(String filePath, String fileName, String sheetName, String testCaseID, int columnID)
			throws IOException {

		int rowCount;

		int columnCount;

		String cellData;

		String testData = null;

		// Create an object of File class to open xlsx file

		File file = new File(filePath + "\\" + fileName);

		// Create an object of FileInputStream class to read excel file

		FileInputStream fis = new FileInputStream(file);

		Workbook wb = null;

		// Find the file extension by splitting file name in substring and getting only
		// extension name

		String fileExtension = fileName.substring(fileName.indexOf("."));

		if (fileExtension.equals(".xlsx")) {

			wb = new XSSFWorkbook(fis);

		}

		// Read sheet inside the workbook by its name

		Sheet sheet = wb.getSheet(sheetName);

		// Find number of rows in excel file

		rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

		System.out.println("Number of rows.........................: " + rowCount);

		// Create a loop over all the rows of excel file to read it

		for (int i = 0; i <= rowCount; i++) {

			Row row = sheet.getRow(i);

			// Create a loop to print cell values in a row

			columnCount = row.getLastCellNum();

			for (int j = 0; j < columnCount; j++) {

				cellData = row.getCell(j).getStringCellValue();

				if (cellData.contains(testCaseID)) {

					testData = row.getCell(j + columnID).getStringCellValue();

					System.out.println("Inside if statement................");

				}

				// System.out.println("Row: " + i + " ------Column :" + j + "------CellData: " +
				// cellData);

				// System.out.println("Cell Data: " + cellData);

			}
		}
		return testData;

	}

}
