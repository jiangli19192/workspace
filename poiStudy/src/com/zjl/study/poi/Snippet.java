//package com.zjl.study.poi;
//
//public class Snippet {
//	/**
//	 * 导出设备信息Excel
//	 * @param form 	    和 HTTP 请求相关的表格对象
//	 * @param resources 信息资源对象
//	 * @param locale    本地化对象
//	 * @param session   HTTP 会话对象
//	 * @param request   HTTP 请求对象
//	 * @param response  HTTP 响应对象
//	 * @return
//	 */
//	public String exportExcel(DynaBean form, MessageResources resources,
//			Locale locale, HttpSession session, HttpServletRequest request,
//			HttpServletResponse response) throws Exception{
//		int iLanguage = (locale.getLanguage().indexOf("en")>=0)?0:1;
//		response.reset();
//		response.setContentType("application/vnd.ms-excel");
//		response.setHeader("Content-Disposition","attachment;filename="+java.net.URLEncoder.encode(resources.getMessage(locale, "device.details")+".xls","UTF-8"));
//		OutputStream sos = response.getOutputStream();
//		List<DeviceVO> deviceList = dao.getAllDevice();
//		HSSFWorkbook wb = new HSSFWorkbook();
//		Map<String, CellStyle> styles = createStyles(wb);
//		// 创建sheet页
//		Sheet sheet = wb.createSheet("Sheet");
//		PrintSetup printSetup = sheet.getPrintSetup();
//		printSetup.setLandscape(true);
//		sheet.setFitToPage(true);
//		sheet.setHorizontallyCenter(true);
//		/**
//		*合并单元格的行或者列
//		*/
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$F$1:$H$1"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$M$1:$P$1"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$Q$1:$S$1"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$A$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$B$1:$B$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$C$1:$C$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$D$1:$D$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$E$1:$E$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$I$1:$I$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$J$1:$J$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$K$1:$K$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$L$1:$L$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$T$1:$T$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$U$1:$U$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$V$1:$V$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$W$1:$W$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$X$1:$X$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$Y$1:$Y$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$Z$1:$Z$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$AA$1:$AA$2"));
//		sheet.addMergedRegion(CellRangeAddress.valueOf("$AB$1:$AB$2"));
//		
//	
//		
//		// 创建表头
//		Row headerRow = sheet.createRow(0);
//		headerRow.setHeightInPoints(30);
//		Cell headerCell;
//		
//		headerCell = headerRow.createCell(0);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.number")); //设备编号
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(1);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.qrcode")); //设备二维码
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(2);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.customerbase")); //客户群
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(3);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.customertype")); //客户类别
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(4);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.customername")); //客户名称
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(5);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.area")); //设备区域
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(8);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.itemname")); //所属项目名称
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(9);
//		headerCell.setCellValue(resources.getMessage(locale, "device.category")); //设备类别
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(10);
//		headerCell.setCellValue(resources.getMessage(locale, "device.name")); //设备名称
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(11);
//		headerCell.setCellValue(resources.getMessage(locale, "device.no")); //设备信息编号
//		headerCell.setCellStyle(styles.get("header"));
//	
//		headerCell = headerRow.createCell(12);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.baseinfomation")); //设备基本信息
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(16);
//		headerCell.setCellValue(resources.getMessage(locale, "device.location")); //设备位置
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(19);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.enabledate")); //设备启用日期
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(20);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.backendload")); //后端负载
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(21);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.operationtips")); //操作提示
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(22);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.maintenancepeople")); //维护责任人
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(23);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.usetime")); //巡检时间
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(24);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.intervaltime")); //巡检下台设备时间间隔
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(25);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.patrolpath")); //巡检路径
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(26);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.enable")); //是否启用巡检路径
//		headerCell.setCellStyle(styles.get("header"));
//		
//		headerCell = headerRow.createCell(27);
//		headerCell.setCellValue(resources.getMessage(locale, "device.export.excel.other")); //其他信息
//		headerCell.setCellStyle(styles.get("header"));
//		
//		
//		Row headerRowRegion = sheet.createRow(1);
//		headerRowRegion.setHeightInPoints(15);
//		Cell headerCellRegion;
//		headerCellRegion = headerRowRegion.createCell(5);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.export.excel.province")); //省份
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		headerCellRegion = headerRowRegion.createCell(6);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.export.excel.region")); //市
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		headerCellRegion = headerRowRegion.createCell(7);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.export.excel.county")); //县/区
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		headerCellRegion = headerRowRegion.createCell(12);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.export.excel.brand")); //品牌
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		headerCellRegion = headerRowRegion.createCell(13);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.export.excel.model")); //型号
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		headerCellRegion = headerRowRegion.createCell(14);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.export.excel.capacity")); //容量
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		headerCellRegion = headerRowRegion.createCell(15);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.export.excel.systemtype")); //系统类型
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		headerCellRegion = headerRowRegion.createCell(16);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.build")); //楼号
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		headerCellRegion = headerRowRegion.createCell(17);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.floor")); //楼层
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		headerCellRegion = headerRowRegion.createCell(18);
//		headerCellRegion.setCellValue(resources.getMessage(locale, "device.room")); //房间号
//		headerCellRegion.setCellStyle(styles.get("header"));
//		
//		for(int i=0;i<deviceList.size();i++){
//			DeviceVO device = deviceList.get(i);
//			Cell rowCell;
//			Row cellRow = sheet.createRow(i + 2);
//			
//			rowCell = cellRow.createCell(0);
//			rowCell.setCellValue(device.getDeviceId());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(1);
//			rowCell.setCellValue(device.getQrcode());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(2);
//			//判断是否是中文
//			if(iLanguage==1){
//				rowCell.setCellValue(device.getItemId().getCustomerBase().substring(device.getItemId().getCustomerBase().indexOf(":")+1,device.getItemId().getCustomerBase().length()));
//			}else if(iLanguage==0){ //判断是否是英文
//				rowCell.setCellValue(device.getItemId().getCustomerBase().substring(0,device.getItemId().getCustomerBase().indexOf(":")));
//			}
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(3);
//			//判断是否是中文
//			if(iLanguage==1){
//				rowCell.setCellValue(device.getItemId().getCustomerType().substring(device.getItemId().getCustomerType().indexOf(":")+1,device.getItemId().getCustomerType().length()));
//			}else if(iLanguage==0){ //判断是否是英文
//				rowCell.setCellValue(device.getItemId().getCustomerType().substring(0,device.getItemId().getCustomerType().indexOf(":")));
//			}
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(4);
//			rowCell.setCellValue(device.getItemId().getCustomerName());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(5);
//			rowCell.setCellValue(device.getItemId().getProvince());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(6);
//			rowCell.setCellValue(device.getItemId().getCity());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(7);
//			rowCell.setCellValue(device.getItemId().getCounty());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(8);
//			//判断是否是中文
//			if(iLanguage==1){
//				rowCell.setCellValue(device.getItemId().getItemName());
//			}else if(iLanguage==0){ //判断是否是英文
//				rowCell.setCellValue(device.getItemId().getForShort());
//			}
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(9);
//			//判断是否是中文
//			if(iLanguage==1){
//				rowCell.setCellValue(device.getZequipId().getZequipGroup().getNameLoc());
//			}else if(iLanguage==0){ //判断是否是英文
//				rowCell.setCellValue(device.getZequipId().getZequipGroup().getNameEn());
//			}
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(10);
//			rowCell.setCellValue(device.getDeviceName());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(11);
//			rowCell.setCellValue(device.getDeviceNo());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(12);
//			rowCell.setCellValue(device.getDeviceBrand());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(13);
//			rowCell.setCellValue(device.getEquipDriveId().getModel());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(14);
//			rowCell.setCellValue(device.getDeviceCapacity());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(15);
//			rowCell.setCellValue(device.getSystemType());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(16);
//			rowCell.setCellValue(device.getStairsNo());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(17);
//			rowCell.setCellValue(device.getFloor());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(18);
//			rowCell.setCellValue(device.getRoomNo());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(19);
//			rowCell.setCellValue(device.getEnableDate()!=null ? new SimpleDateFormat("yyyy-MM-dd").format(device.getEnableDate()) : "");
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(20);
//			rowCell.setCellValue(device.getBackendLoad());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(21);
//			rowCell.setCellValue(device.getOperationTips());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(22);
//			rowCell.setCellValue(device.getPersonId().getUserName());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(23);
//			rowCell.setCellValue(device.getInspecTime()+resources.getMessage(locale, "device.export.excel.minute"));
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(24);
//			rowCell.setCellValue(device.getIntervalTime()+resources.getMessage(locale, "device.export.excel.minute"));
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(25);
//			rowCell.setCellValue(device.getDevicePath());
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(26);
//			rowCell.setCellValue(device.getValidityNr() == 0 ? resources.getMessage(locale, "mmc.soft.person.disabled") : resources.getMessage(locale, "mmc.soft.person.enable"));
//			rowCell.setCellStyle(styles.get("cell"));
//			
//			rowCell = cellRow.createCell(27);
//			rowCell.setCellValue(device.getOtherInfo() != null ? device.getOtherInfo() : "");
//			rowCell.setCellStyle(styles.get("cell"));
//		}
//		wb.write(sos);
//		sos.flush();
//		sos.close();
//		return null;
//	}
//	
//	//excel样式
//	private Map<String, CellStyle> createStyles(Workbook wb)
//	{
//		Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
//		CellStyle style;
//		Font titleFont = wb.createFont();
//		titleFont.setFontHeightInPoints((short) 18);
//		titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
//		style = wb.createCellStyle();
//		style.setAlignment(CellStyle.ALIGN_CENTER);
//		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
//		style.setFont(titleFont);
//		styles.put("title", style);
//	
//		style = wb.createCellStyle();
//		style.setAlignment(CellStyle.ALIGN_CENTER);
//		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
//		style.setWrapText(true);
//		styles.put("header", style);
//	
//		style = wb.createCellStyle();
//		style.setAlignment(CellStyle.ALIGN_CENTER);
//		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
//		style.setWrapText(true);
//		styles.put("cell", style);
//	
//		style = wb.createCellStyle();
//		style.setAlignment(CellStyle.ALIGN_CENTER);
//		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
//		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//		style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
//		styles.put("formula", style);
//	
//		style = wb.createCellStyle();
//		style.setAlignment(CellStyle.ALIGN_CENTER);
//		style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
//		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
//		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
//		style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
//		styles.put("formula_2", style);
//	
//		return styles;
//	}
//	
//}
//
