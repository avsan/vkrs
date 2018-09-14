package com.avsan.spring.service;


import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.avsan.spring.pojo.DailyTripDetailsPojo;
@Service
public class ExcelOutputServiceImpl {
public XSSFWorkbook createExcelOutputFile(List<DailyTripDetailsPojo>  implementerTaskboardDTOs,
		HttpServletResponse response) throws IOException {

	//logger.debug("ExcelOutputServiceImpl - createExcelOutputFile");
	
	OutputStream os=null;
	XSSFWorkbook workbook=null;
	
	try {
		String fileName = "Excel_Output.xlsx";

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

		// Create blank workbook
		workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet spreadsheet = workbook.createSheet(" Implementer Taskboard Details");

		writeExcelOutputData(implementerTaskboardDTOs, spreadsheet, workbook);

		os = response.getOutputStream();
		workbook.write(os);
	} catch (IOException e) {
		//logger.error("IOException While Creating Excel  :", e);
	}finally {
		os.flush();
		os.close();
	}
	//logger.info("Writesheet.xlsx written successfully");

	return workbook;
}

private void writeExcelOutputData(List<DailyTripDetailsPojo>  implementerTaskboardDTOs, XSSFSheet spreadsheet,
		XSSFWorkbook worksheet) {

	// Create a Font for styling header cells
	Font headerFont = worksheet.createFont();
	headerFont.setBold(true);
	headerFont.setFontHeightInPoints((short) 12); 
	headerFont.setColor(IndexedColors.BLUE.getIndex());

	// Create a CellStyle with the font
	CellStyle headerCellStyle = worksheet.createCellStyle();
	headerCellStyle.setFont(headerFont);

	// Create row object
	XSSFRow row;
	int rowid = 0;
	row = spreadsheet.createRow(rowid++);
	int cellHeaderID = 0;
	XSSFCell createCell;
	
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Trip Id");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("vehicle Number");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Driver Name");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Date");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Loding Place");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Loding Metre Reading");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Loding Time");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Unloding Place");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Unloding Metre Reading");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Unloding Time");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Material");
	createCell = row.createCell(cellHeaderID++);
	createCell.setCellStyle(headerCellStyle);
	createCell.setCellValue("Refuiling At");
	for (DailyTripDetailsPojo dailyTripDetails : implementerTaskboardDTOs) {
		row = spreadsheet.createRow(rowid++);
		int cellid = 0;
		row.createCell(cellid++).setCellValue(dailyTripDetails.getTripId());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getVehicleId().getVehiclePrNumber());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getDriverId().getDriverName());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getDate());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getLodingPlace());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getLodingMetreReading());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getLodingTime());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getUnlodingPlace());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getUnlodingMetreReading());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getUnlodingTime());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getMaterial());
		row.createCell(cellid++).setCellValue(dailyTripDetails.getRefuilingAt());
		
		
	}
	}
}