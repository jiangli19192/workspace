package com.zjl.study.poi;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
 
/**
 * Excel导出
 * @author Administrator
 *
 */ 
public class POIExcelExportTest { 
 
    public static void main(String[] args) throws Exception { 
        //创建一个Excel  
        Workbook wb = new HSSFWorkbook(); 
        //创建一个输出流对象,以便将创建好的Excel写入文件  
        FileOutputStream fileOut = new FileOutputStream("WORKBOOK.xls"); 
        //  
        CreationHelper createHelper = wb.getCreationHelper(); 
        //创建一个sheet  
        Sheet sheet = wb.createSheet("附表"); 
        //合并一个单元格,这个地方会在下面用图介绍  
        sheet.addMergedRegion(new CellRangeAddress( 
                0, //first row (0-based)  
                10, //last row  (0-based)  
                0, //first column (0-based)  
                1  //last column  (0-based)  
        )); 
         
        //创建一个行对象,下标从0开始  
        Row row1=sheet.createRow(0); 
        //创建一个样式  
        CellStyle cellStyle1 = wb.createCellStyle(); 
        //设置左右对齐居中  
        cellStyle1.setAlignment(CellStyle.ALIGN_CENTER); 
        //垂直对其居中  
        cellStyle1.setVerticalAlignment(CellStyle.VERTICAL_CENTER); 
        //设置true让Cell中的内容以多行显示  
        cellStyle1.setWrapText(true); 
        //创建一个单元格,单元格下标从0开始  
        Cell c1=row1.createCell(0); 
        //创建富文本,如果你想每一行显示一个字体那么就按照我下面的写,如果想  
        //多个显示在一行,那么去掉他们之间的\r\n就好了  
        c1.setCellValue( 
                createHelper.createRichTextString 
                  ("合\r\n并\r\n后\r\n选\r\n择\r\n我\r\n" + 
                        "，\r\n这\r\n只\r\n值\r\n！" 
                        )); 
        //设置样式  
        c1.setCellStyle(cellStyle1); 
        //写入文件  
        wb.write(fileOut); 
        //关闭输出流  
        fileOut.close(); 
    } 
}