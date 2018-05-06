package test.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import cn.jxc.pojo.Dept;

public class StudentExportService {

	String[] excelHeader = { "Sno", "Name", "Age" };

	public HSSFWorkbook export(List<Dept> list) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Student");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(excelHeader[i]);
			cell.setCellStyle(style);
			sheet.autoSizeColumn(i);
			// sheet.SetColumnWidth(i, 100 * 256);
		}
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			Dept student = list.get(i);
			row.createCell(0).setCellValue(student.getDeptId());
			row.createCell(1).setCellValue(student.getDeptName());
			row.createCell(2).setCellValue(student.getDeptDes());
		}
		return wb;
	}

	@Test
	public void a() {
		try {
			List<Dept> list = new ArrayList<Dept>();
			list.add(new Dept(1000, "zhangsan", "20"));
			list.add(new Dept(1001, "lisi", "23"));
			list.add(new Dept(1002, "wangwu", "25"));
			HSSFWorkbook wb = this.export(list);
			// response.setContentType("application/vnd.ms-excel");
			// response.setHeader("Content-disposition", "attachment;filename=student.xls");
			OutputStream ouputStream = new OutputStream() {
				@Override
				public void write(int b) throws IOException {
					
				}
			};
			wb.write(ouputStream);
			ouputStream.flush();
			ouputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
