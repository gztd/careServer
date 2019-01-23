/**
 * Copyright © 2018 CSTeam, All rights reserved.
 * 
 * @Package: org.r.system.cs.serviceimpl.report 
 * @author: Casper   
 * @date: 2018年11月18日 下午11:33:22 
 */
package org.r.system.cs.serviceimpl.report;

import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.r.system.cs.entity.report.RequestDetailEntity;
import org.r.system.cs.exception.report.FileExportException;
import org.r.system.cs.service.report.ExportFileService;

import java.util.List;

/**
 * @author Casper
 *
 */
public class PatientReportExcelExportService implements ExportFileService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.r.system.cs.service.report.ExportFileService#exportFile(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object exportFile(Object param1) {
		
		if (!(param1 instanceof List<?>))
			throw new FileExportException("参数类型错误");
		
		List<RequestDetailEntity> requests = (List<RequestDetailEntity>) param1;
		
		SXSSFWorkbook wb = this.createEmptyWorkbookWithHeader();
		SXSSFSheet sheet = wb.getSheetAt(0);
		int i = 1;
		for(RequestDetailEntity request : requests) {
			SXSSFRow row = sheet.createRow(i++);
			row.createCell(0).setCellValue(request.getPatientCode()); //病人编号
			row.createCell(1).setCellValue(request.getHospitalDate()); //入院时间
			row.createCell(2).setCellValue(request.getPatientName()); //姓名
			row.createCell(3).setCellValue(request.getOrgName()); //科室
			row.createCell(4).setCellValue(request.getBedNum()); //床号
			row.createCell(5).setCellValue(request.getPay()); //预收款
			row.createCell(6).setCellValue(request.getCareTypeName()); //陪护类型
			row.createCell(7).setCellValue(request.getPrice()); //单价
			row.createCell(8).setCellValue(request.getStatus()); //服务状态
			row.createCell(9).setCellValue(request.getLeaveDate()); //出院日期
			row.createCell(10).setCellValue(request.getDays()); //天数
			row.createCell(11).setCellValue(request.getAmount()); //服务金额
		}
		return wb;
	}

	private SXSSFWorkbook createEmptyWorkbookWithHeader() {

		// 创建并初始化一个工作簿对象
		SXSSFWorkbook wb = initWorkBook();
		// 获取一个工作表
		SXSSFSheet sheet = wb.getSheetAt(0);

		// 设置表得第一行：广州安裕物业管理有限公司驻 沙井项目 员工xxxx年xx月考勤统计表
		SXSSFRow row = sheet.getRow(0);
		
		//定义表头
		String[] headers = {"病人编号","入院时间","姓名","科室","床号","预收款","陪护类型","单价","服务状态","出院日期","天数","服务金额"};
		//设置表头
		for(int i = 0;i<headers.length;i++) {
			row.createCell(i).setCellValue(headers[i]);
		}

		return wb;
	}
	
	private SXSSFWorkbook initWorkBook() {

		// 创建一个工作簿对象
		SXSSFWorkbook wb = new SXSSFWorkbook();
		// 创建一个工作表
		SXSSFSheet sheet = wb.createSheet("病人住院报表");
		sheet.createRow(0);
		return wb;
	}

}
