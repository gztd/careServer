/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.report 
 * @author: Casper   
 * @date: 2018年11月18日 下午3:39:37 
 */
package org.r.system.cs.serviceimpl.report;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.r.system.cs.dto.report.SalaryCellDTO;
import org.r.system.cs.dto.report.SalaryUnitDTO;
import org.r.system.cs.exception.report.FileExportException;
import org.r.system.cs.service.report.ExportFileService;
import org.r.system.cs.util.tool.UtilTool;

import java.util.List;

/**
 * @author Casper
 *
 */
public class SalaryExcelFileExportService implements ExportFileService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.r.system.cs.service.report.ExportFileService#ExportFile()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object exportFile(Object param1) {

		if (!(param1 instanceof List<?>))
			throw new FileExportException("参数类型错误");
		
		List<SalaryUnitDTO> salary = (List<SalaryUnitDTO>) param1;
		
		SXSSFWorkbook wb = this.createEmptyWorkbookWithHeader();
		SXSSFSheet sheet = wb.getSheetAt(0);

		Font font2 = wb.createFont();
		font2.setFontName("宋体");
		font2.setFontHeightInPoints((short) 12);
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setFont(font2);
		cellStyle.setWrapText(true);
		int i = sheet.getLastRowNum() + 1;
		int index = 1;
		
		for(SalaryUnitDTO unit : salary) {
			
			List<SalaryCellDTO> cells = unit.getCareworkers();
			for(SalaryCellDTO target : cells) {
				SXSSFRow row = sheet.createRow(i++);
				row.setHeightInPoints(18);
				SXSSFCell cell = row.createCell(0);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(String.valueOf(index++));
				row.createCell(1).setCellStyle(cellStyle);
				cell = row.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(target.getName());// 陪护人员姓名
				cell = row.createCell(3);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(target.getJobName());// 职务
				cell = row.createCell(4);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(target.getCountDay());// 计发天数
				cell = row.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(target.getSalary());// 应发工资
				row.createCell(6).setCellStyle(cellStyle);
				cell = row.createCell(7);
				cell.setCellStyle(cellStyle);
				cell.setCellType(CellType.FORMULA);
				cell.setCellFormula("=F" + String.valueOf(i) + "+G" + String.valueOf(i));
			}
			System.out.println("org name is " + unit.getOrgName() + " and the region is "
					+ String.valueOf(i - cells.size()) + " to " + String.valueOf(i));
			sheet.getRow(i - cells.size()).getCell(1).setCellValue(unit.getOrgName());
			if(cells.size() == 1)continue;
			sheet.addMergedRegion(new CellRangeAddress(i - cells.size(), i - 1, 1, 1));
			
		}
		SXSSFRow row = sheet.createRow(i++);
		row.setHeightInPoints(18);
		SXSSFCell cell = row.createCell(0);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("合计");
		row.createCell(1).setCellStyle(cellStyle);
		row.createCell(2).setCellStyle(cellStyle);
		row.createCell(3).setCellStyle(cellStyle);
		row.createCell(4).setCellStyle(cellStyle);
		row.createCell(5).setCellStyle(cellStyle);
		row.createCell(6).setCellStyle(cellStyle);
		cell = row.createCell(7);
		cell.setCellStyle(cellStyle);
		cell.setCellType(CellType.FORMULA);
		cell.setCellFormula("sum(H6:H" + String.valueOf(i - 1) + ")");
		sheet.addMergedRegion(new CellRangeAddress(i - 1, i - 1, 0, 1));

		return wb;
	}

	
	private SXSSFWorkbook createEmptyWorkbookWithHeader() {

		// 创建并初始化一个工作簿对象
		SXSSFWorkbook wb = initWorkBook();
		// 获取一个工作表
		SXSSFSheet sheet = wb.getSheetAt(0);

		// 设置表得第一行：广州安裕物业管理有限公司驻 沙井项目 员工xxxx年xx月考勤统计表
		SXSSFRow row = sheet.getRow(0);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));// 合并单元格
		row.setHeightInPoints(42);
		CellStyle cellStyleAtRow1 = wb.createCellStyle();
		cellStyleAtRow1.setAlignment(HorizontalAlignment.CENTER);
		cellStyleAtRow1.setVerticalAlignment(VerticalAlignment.BOTTOM);
		Font font = wb.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 14);
		cellStyleAtRow1.setFont(font);
		SXSSFCell cellAtRow1 = row.createCell(0);
		cellAtRow1.setCellStyle(cellStyleAtRow1);
		// 转换日期
		String[] dates = UtilTool.getSystemCurrentDate().split("-");
		String[] suffixs = { "年", "月" };
		StringBuffer date = new StringBuffer();
		for (int i = 0; i < 2; i++) {
			date.append(dates[i]);
			date.append(suffixs[i]);
		}
		String cell1String = "广州安裕物业管理有限公司驻   沙井项目   员工" + date + "考勤统计表";
		cellAtRow1.setCellValue(cell1String);

		// 设置第二行
		SXSSFRow row2 = sheet.getRow(1);
		row2.setHeightInPoints(18);
		SXSSFCell cellAtRow2 = row2.createCell(0);
		Font font2 = wb.createFont();
		font2.setFontName("宋体");
		font2.setFontHeightInPoints((short) 12);
		cellAtRow2.setCellValue("陪护部：");
		CellStyle cellStyleAtRow2 = wb.createCellStyle();
		cellStyleAtRow2.setAlignment(HorizontalAlignment.CENTER);
		cellStyleAtRow2.setVerticalAlignment(VerticalAlignment.BOTTOM);
		cellStyleAtRow2.setFont(font2);
		cellAtRow2.setCellStyle(cellStyleAtRow2);
		sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 2));

		// 设置第三行，合并3、4、5行
		SXSSFRow row3 = sheet.getRow(2);
		SXSSFRow row4 = sheet.getRow(3);
		SXSSFRow row5 = sheet.getRow(4);

		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setFont(font2);
		cellStyle.setWrapText(true);

		String[] titles = { "序号", "科室", "姓  名", "职务", "计\r\n发\r\n天\r\n数", "应\r\n发\r\n工\r\n资", "奖励", "工资合计" };
		for (int i = 0; i < titles.length; i++) {
			SXSSFCell cell1AtRow3 = row3.createCell(i);
			cell1AtRow3.setCellStyle(cellStyle);
			cell1AtRow3.setCellValue(titles[i]);
			row4.createCell(i).setCellStyle(cellStyle);
			row5.createCell(i).setCellStyle(cellStyle);
			sheet.addMergedRegion(new CellRangeAddress(2, 4, i, i));
		}

		return wb;
	}
	
	private SXSSFWorkbook initWorkBook() {

		// 创建一个工作簿对象
		SXSSFWorkbook wb = new SXSSFWorkbook();
		// 创建一个工作表
		SXSSFSheet sheet = wb.createSheet("陪护部");
		// 设置工作表得冻结区
		sheet.createFreezePane(8, 5);

		// 定义列得宽度
		int[] columnWidths = { 5, 10, 11, 9, 8, 11, 10, 14 };
		for (int i = 0; i < 8; i++) {
			sheet.setColumnWidth(i, columnWidths[i] * 256);
		}

		sheet.createRow(0);
		sheet.createRow(1);

		// 设置第三行，合并3、4、5行
		SXSSFRow row3 = sheet.createRow(2);
		SXSSFRow row4 = sheet.createRow(3);
		SXSSFRow row5 = sheet.createRow(4);
		row3.setHeightInPoints((float) 16.5);
		row4.setHeightInPoints((float) 18.75);
		row5.setHeightInPoints((float) 39);

		return wb;
	}
	
	
}
