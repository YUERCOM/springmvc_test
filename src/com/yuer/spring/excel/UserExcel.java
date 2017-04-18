package com.yuer.spring.excel;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.yuer.test.model.UserModel;

public class UserExcel extends AbstractExcelView {

	@Override
	@SuppressWarnings("unchecked")
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String fileName = "用户列表.xls";
		response.setHeader("Content-Disposition", 
				"inline;filename=" + URLEncoder.encode(fileName,"UTF8"));
		List<UserModel> list = (List<UserModel>) model.get("ums");
		HSSFSheet sheet = workbook.createSheet("用户信息");
		HSSFRow header = sheet.createRow(0);
		
		List<String> headers = getExcelHeader();
		for(int i=0;i<headers.size();i++){
			header.createCell(i).setCellValue(headers.get(i));
		}
		
		int rowNum = 1;
		
		for(UserModel um : list){
			HSSFRow row = sheet.createRow(rowNum++);
			for(int i=0;i<headers.size();i++){
				row.createCell(0).setCellValue(um.getId());
				row.createCell(1).setCellValue(um.getName());
				row.createCell(2).setCellValue(um.getEmail());
			}
		}
		
		
	}
	
	private List<String> getExcelHeader(){
		List<String> list = new ArrayList<>();
		list.add("ID");
		list.add("姓名");
		list.add("邮箱");
		return list;
	}
	
	

}
