package com.zjl.study.poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.util.CellRangeAddress;

public class MergedCells {
	/**
	 * 测试使用的POI版本是3.9
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");
		
		sheet.setColumnWidth(0, (int)(100 * 35.7));//设置列宽：第几列，列的宽度
		
		
		HSSFRow row0 = sheet.createRow(0);
		HSSFCell row0_cell0 = row0.createCell(0, HSSFCell.CELL_TYPE_NUMERIC);// 单元格类型为：数字类型（0）
		row0_cell0.setCellValue(1.004d);
		
		
		
		

		HSSFRow row1 = sheet.createRow(1);
		HSSFCell row1_cell0 = row1.createCell(0, HSSFCell.CELL_TYPE_NUMERIC);
		row1_cell0.setCellValue(1.5d);
		row1_cell0.setCellStyle(getCustomStyle(wb));// 给单元格应用样式
		
		
		HSSFCell row1_cell1 = row1.createCell(1);
		row1_cell1.setCellType(HSSFCell.CELL_TYPE_STRING);//单元格类型为：字符串类型(1)
		row1_cell1.setCellValue("This is a test of merging");// 给单元格设置内容数据
		row1_cell1.setCellStyle(getCustomStyle(wb));// 给单元格应用样式
		

		// 新版用法 3.8版
		// sheet.addMergedRegion(new CellRangeAddress(
		// 1, //first row (0-based) from 行
		// 2, //last row (0-based) to 行
		// 1, //first column (0-based) from 列
		// 1 //last column (0-based) to 列
		// ));
		
		// 表示合并B2,B3
		sheet.addMergedRegion(new Region(1, // first row (0-based)
				(short) 1, // first column (0-based)
				2, // last row (0-based)
				(short) 1 // last column (0-based)
		));

		// 合并叠加 表示合并B3 B4。但是B3已经和B2合并了，所以，变成B2:B4合并了
		sheet.addMergedRegion(new Region(2, // first row (0-based)
				(short) 1, // first column (0-based)
				3, // last row (0-based)
				(short) 1 // last column (0-based)
		));

		// 一下代码表示在D4 cell 插入一段字符串
		HSSFRow row2 = sheet.createRow(3);
		HSSFCell cell2 = row2.createCell(3);
		cell2.setCellValue("this is a very very very long string , please check me out.");
		
		
		// A5
		HSSFRow row4 = sheet.createRow(4);
		HSSFCell row4_cell0 = row4.createCell(0, HSSFCell.CELL_TYPE_STRING);
		row4_cell0.setCellValue(new HSSFRichTextString("我是单元格！"));
		
		
		// 合并单元格B6至B8
		sheet.addMergedRegion(new Region(5, // first row (0-based)
				(short) 0, // first column (0-based)
				7, // last row (0-based)
				(short) 15 // last column (0-based)
		));
		HSSFRow row5 = sheet.createRow(5);
		HSSFCell row5_cell1 = row5.createCell(0, HSSFCell.CELL_TYPE_STRING);
		row5_cell1.setCellValue("合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容合并单元格内的内容!");
		row5_cell1.setCellStyle(getCustomStyle(wb));// 给单元格应用样式
		
		HSSFRow row8 = sheet.createRow(8);
		
		// firstRow, lastRow, firstCol, lastCol
		CellRangeAddress cellRangeAddress = new CellRangeAddress(9, 12, 0, 15);
		sheet.addMergedRegion(cellRangeAddress);
		HSSFRow row9 = sheet.createRow(9);
		HSSFCell row9_cell0 = row9.createCell(0, HSSFCell.CELL_TYPE_STRING);
		row9_cell0.setCellStyle(getCustomStyle(wb));
		row9_cell0.setCellValue("5.3 LENOVO MAKES NO WARRANTIES FOR SOFTWARE, SERVICE, SUPPORT OR THIRD PARTY PRODUCTS. SUCH SOFTWARE, SERVICE, SUPPORT AND PRODUCTS ARE PROVIDED “AS IS”, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND. SOME STATES DO NOT ALLOW LIMITATIONS OF WARRANTIES, SO THESE LIMITATIONS MAY NOT APPLY TO CUSTOMER. THIRD PARTY PROVIDERS OF SOFTWARE, SERVICES, PRODUCTS AND SUPPORT MAY PROVIDE WARRANTIES TO CUSTOMER. ");
		
		

		
		outputExcelFile(wb);
	}

	/**
	 * 输出导出文件
	 * @param wb
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void outputExcelFile(HSSFWorkbook wb)
			throws FileNotFoundException, IOException {
		// Write the output to a file
		FileOutputStream fileOut = new FileOutputStream("workbook.xls");
		wb.write(fileOut);
		fileOut.close();
		
		System.out.println("********************    <h1>EXCEL 导出成功!</h1>  ************************");
	}

	/**
	 * 获取单元格自定义样式 HSSFCellStyle对象
	 * @param HSSFWorkbook
	 * @return HSSFCellStyle
	 */
	private static HSSFCellStyle getCustomStyle(HSSFWorkbook wb) {
		// 1.生成字体对象
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints((short) 10);
		font.setFontName("新宋体");
		font.setColor(HSSFColor.BLUE.index);
//		font.setBoldweight((short) 0.8);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		
		// 2.生成样式对象
		HSSFCellStyle style = wb.createCellStyle();
//		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平居中对齐
//		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER); // 垂直居中对齐
		style.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
		
		style.setFont(font); // 调用字体样式对象
		style.setWrapText(true);// 自动换行
		// 增加表格边框的样式 例子
		style.setBorderTop(HSSFCellStyle.BORDER_DOUBLE);
		style.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);
		style.setTopBorderColor(HSSFColor.GOLD.index);
		style.setLeftBorderColor(HSSFColor.PLUM.index);
		return style;
	}
}
