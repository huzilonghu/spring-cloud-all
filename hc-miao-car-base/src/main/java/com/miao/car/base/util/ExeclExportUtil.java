package com.miao.car.base.util;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class ExeclExportUtil {


	private static String excelPath = "productdata.xlsx";

	public static void main(String[] args) throws Exception{
		/*ExeclExportUtil excel = new ExeclExportUtil();
		List<String>   titleList= new ArrayList<>();
		titleList.add("产品名称");
		titleList.add("产品编码");
		titleList.add("产品类型");
		titleList.add("产品说明");
		titleList.add("产品锁定期");
		titleList.add("产品利率");
		titleList.add("产品状态");

		List<List<String>> dataObject= new ArrayList<List<String>>();

		for (int j=0;j<10;j++){
			List<String>   rowData= new ArrayList<>();
			rowData.add("季季宝");
			rowData.add("DATA1");
			rowData.add("定期");
			rowData.add("定期产品到期自动赎回");
			rowData.add("60");
			rowData.add("0.9");
			rowData.add("上线");
			dataObject.add(rowData);
		}

		if(excel.createExcelFile(excelPath,"产品数据",titleList,dataObject)) {
			System.out.println("data.xlsx is created successfully.");
		}*/
	}

	public static boolean createExcelFile(String savePath,String sheetName, List<String>  titleList,List<List<String>> dataObject) {
		boolean isCreateSuccess = false;
		Workbook workbook = null;
		try {
			// XSSFWork used for .xslx (>= 2007), HSSWorkbook for 03 .xsl
			workbook = new XSSFWorkbook();//HSSFWorkbook();//WorkbookFactory.create(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(workbook != null) {
			Sheet sheet = workbook.createSheet(sheetName);

			Row row0 = sheet.createRow(0);
			for(int i = 0; i < titleList.size(); i++) {
				Cell cell_1 = row0.createCell(i, Cell.CELL_TYPE_STRING);
				CellStyle style = getStyle(workbook);
				style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
				cell_1.setCellStyle(style);

				cell_1.setCellValue(titleList.get(i));
				sheet.setColumnWidth(i, 4000);
				//sheet.autoSizeColumn(i);
			}
			for (int rowNum = 1; rowNum < dataObject.size(); rowNum++) {
				Row row = sheet.createRow(rowNum);
				List<String> rowData= dataObject.get(rowNum);
				for(int i = 0; i <titleList.size(); i++) {
					Cell cell = row.createCell(i, Cell.CELL_TYPE_STRING);
					CellStyle style = getStyle(workbook);
					cell.setCellStyle(style);
					cell.setCellValue(rowData.get(i));
				}
			}
			try {
				FileOutputStream outputStream = new FileOutputStream(savePath);
				workbook.write(outputStream);
				if (outputStream!=null) {
					outputStream.flush();
					outputStream.close();
				}
				isCreateSuccess = true;
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		File sss = new File(savePath);
		System.out.println(sss.getAbsolutePath());
		return isCreateSuccess;
	}

	private  static CellStyle getStyle(Workbook workbook){
		CellStyle style = workbook.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		// 设置单元格字体
	//	Font headerFont = workbook.createFont(); // 字体
		//headerFont.setFontHeightInPoints((short)14);
	//	headerFont.setColor(HSSFColor.RED.index);
	//	headerFont.setFontName("宋体");
	//	style.setFont(headerFont);
	//	style.setWrapText(true);

		// 设置单元格边框及颜色
		style.setBorderBottom((short)1);
		style.setBorderLeft((short)1);
		style.setBorderRight((short)1);
		style.setBorderTop((short)1);
		style.setWrapText(true);
		return style;
	}
	public String getExcelPath() {
		return this.excelPath;
	}

	public void setExcelPath(String excelPath) {
		this.excelPath = excelPath;
	}

}
