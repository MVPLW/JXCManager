package test.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

public class export {
	// ��ʾ�ĵ�����ı���
	private String title;
	// �����������
	private String[] rowName;

	private List<Object[]> dataList = new ArrayList<Object[]>();

	HttpServletResponse response;

	// ���췽��������Ҫ����������
	public export(String title, String[] rowName, List<Object[]> dataList) {
		this.dataList = dataList;
		this.rowName = rowName;
		this.title = title;
	}

	/*
	 * ��������
	 */
	public void export1(OutputStream out) throws Exception {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook(); // ��������������
			HSSFSheet sheet = workbook.createSheet(title); // ����������
			// ������������
			HSSFRow rowm = sheet.createRow(0);
			HSSFCell cellTiltle = rowm.createCell(0);

			// sheet��ʽ���塾getColumnTopStyle()/getStyle()��Ϊ�Զ��巽�� - ������ - ����չ��
			HSSFCellStyle columnTopStyle = this.getColumnTopStyle(workbook);// ��ȡ��ͷ��ʽ����
			HSSFCellStyle style = this.getStyle(workbook); // ��Ԫ����ʽ����
			/*
			 * sheet.addMergedRegion(new CellRangeAddress(0,dataList.get(0).length-1 , 0,
			 * (rowName.length-1)));
			 */// �ϲ���Ԫ��
			sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, dataList.get(0).length - 1));// ����
			cellTiltle.setCellStyle(style);
			cellTiltle.setCellValue(title);
			// ������������
			int columnNum = rowName.length;
			HSSFRow rowRowName = sheet.createRow(0); // ������2��λ�ô�����(��˵��п�ʼ�ĵڶ���)

			// ����ͷ���õ�sheet�ĵ�Ԫ����
			for (int n = 0; n < columnNum; n++) {
				HSSFCell cellRowName = rowRowName.createCell(n); // ������ͷ��Ӧ�����ĵ�Ԫ��
				cellRowName.setCellType(HSSFCell.CELL_TYPE_STRING); // ������ͷ��Ԫ�����������
				HSSFRichTextString text = new HSSFRichTextString(rowName[n]);
				cellRowName.setCellValue(text); // ������ͷ��Ԫ���ֵ
				cellRowName.setCellStyle(columnTopStyle); // ������ͷ��Ԫ����ʽ
			}

			// ����ѯ�����������õ�sheet��Ӧ�ĵ�Ԫ����
			for (int i = 0; i < dataList.size(); i++) {

				Object[] obj = dataList.get(i);// ����ÿ������
				HSSFRow row = sheet.createRow(i + 2);// ����������������ӵ����п�ʼд���ݣ�

				for (int j = 0; j < obj.length; j++) {
					HSSFCell cell = null; // ���õ�Ԫ�����������
					if (j == 0) {
						cell = row.createCell(j, HSSFCell.CELL_TYPE_NUMERIC);
						cell.setCellValue(i);
					} else {
						cell = row.createCell(j, HSSFCell.CELL_TYPE_STRING);
						if (obj[j] != null) {
							cell.setCellValue(obj[j].toString());
						}
					}
					cell.setCellStyle(style); // ���õ�Ԫ����ʽ
				}
			}
			// ���п����ŵ������г��Զ���Ӧ
			for (int colNum = 0; colNum < dataList.get(1).length; colNum++) {
				int columnWidth = sheet.getColumnWidth(colNum) / 256;
				for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
					HSSFRow currentRow;
					// ��ǰ��δ��ʹ�ù�
					if (sheet.getRow(rowNum) == null) {
						currentRow = sheet.createRow(rowNum);
					} else {
						currentRow = sheet.getRow(rowNum);
					}
					/*
					 * if (currentRow.getCell(colNum) != null) { HSSFCell currentCell =
					 * currentRow.getCell(colNum); if (currentCell.getCellType() ==
					 * HSSFCell.CELL_TYPE_STRING) { int length =
					 * currentCell.getStringCellValue().getBytes().length; if (columnWidth < length)
					 * { columnWidth = length; } } }
					 */
					if (currentRow.getCell(colNum) != null) {
						HSSFCell currentCell = currentRow.getCell(colNum);
						if (currentCell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
							int length = 0;
							try {
								length = currentCell.getStringCellValue().getBytes().length;
							} catch (Exception e) {
								e.printStackTrace();
							}
							if (columnWidth < length) {
								columnWidth = length;
							}
						}
					}
				}
				if (colNum == 0) {
					sheet.setColumnWidth(colNum, (columnWidth - 2) * 256);
				} else {
					sheet.setColumnWidth(colNum, (columnWidth + 4) * 256);
				}
			}
			if (workbook != null) {
				try {
					workbook.write(out);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}

	/*
	 * ��ͷ��Ԫ����ʽ
	 */
	public HSSFCellStyle getColumnTopStyle(HSSFWorkbook workbook) {
		// ��������
		HSSFFont font = workbook.createFont();
		// ���������С
		font.setFontHeightInPoints((short) 11);
		// ����Ӵ�
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// ������������
		font.setFontName("Courier New");
		// ������ʽ;
		HSSFCellStyle style = workbook.createCellStyle();
		// ���õױ߿�;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// ���õױ߿���ɫ;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// ������߿�;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// ������߿���ɫ;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// �����ұ߿�;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// �����ұ߿���ɫ;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// ���ö��߿�;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// ���ö��߿���ɫ;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// ����ʽ��Ӧ�����õ�����;
		style.setFont(font);
		// �����Զ�����;
		style.setWrapText(false);
		// ����ˮƽ�������ʽΪ���ж���;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// ���ô�ֱ�������ʽΪ���ж���;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;

	}

	/*
	 * ��������Ϣ��Ԫ����ʽ
	 */
	public HSSFCellStyle getStyle(HSSFWorkbook workbook) {
		// ��������
		HSSFFont font = workbook.createFont();
		// ���������С
		// font.setFontHeightInPoints((short)10);
		// ����Ӵ�
		// font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// ������������
		font.setFontName("Courier New");
		// ������ʽ;
		HSSFCellStyle style = workbook.createCellStyle();
		// ���õױ߿�;
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		// ���õױ߿���ɫ;
		style.setBottomBorderColor(HSSFColor.BLACK.index);
		// ������߿�;
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		// ������߿���ɫ;
		style.setLeftBorderColor(HSSFColor.BLACK.index);
		// �����ұ߿�;
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		// �����ұ߿���ɫ;
		style.setRightBorderColor(HSSFColor.BLACK.index);
		// ���ö��߿�;
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		// ���ö��߿���ɫ;
		style.setTopBorderColor(HSSFColor.BLACK.index);
		// ����ʽ��Ӧ�����õ�����;
		style.setFont(font);
		// �����Զ�����;
		style.setWrapText(false);
		// ����ˮƽ�������ʽΪ���ж���;
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// ���ô�ֱ�������ʽΪ���ж���;
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		return style;
	}

	@Test
	public void a() {
		// ����HSSFWorkbook����
		HSSFWorkbook wb = new HSSFWorkbook();
		// ����HSSFSheet����
		HSSFSheet sheet = wb.createSheet("sheet0");
		// ����HSSFRow����
		HSSFRow row = sheet.createRow(0);
		// ����HSSFCell����
		HSSFCell cell = row.createCell(0);
		// ���õ�Ԫ���ֵ
		cell.setCellValue("��Ԫ���е�����");
		// ���Excel�ļ�
//		FileOutputStream output = new FileOutputStream("d:\\workbook.xls");
////		wkb.write(output);
//		output.flush();
	}

	// public void a() {
	// List<Map<String, Object>> list =
	// registrationInformationDao.findRegistrationInformation1(map);// ��ȡ����
	// List<Object[]> dataList = new ArrayList<Object[]>();
	// Object[] objects0 = new Object[list.get(0).size() + 1];
	// dataList.add(objects0);
	// Map<String, Object> map2 = list.get(0);
	// Set<String> keySet = map2.keySet();
	// int m = 1;
	// for (String key : keySet) {
	// dataList.get(0)[m++] = key;
	// }
	// for (int i = 0; i < list.size(); i++) {
	// Object[] objects = new Object[list.get(i).size() + 1];
	// dataList.add(objects);
	// int j = 1;
	// Map<String, Object> map3 = list.get(i);
	// Set<String> keySet1 = map3.keySet();
	// for (String key : keySet1) {
	// dataList.get(i + 1)[j++] = map3.get(key);
	// }
	// }
	// // ʹ���������ݵ���
	// OutputStream out = null;
	// try {
	// // ��ֹ��������
	// Parament findByName = paramentDao.findByName("export_name");
	// String headStr = "attachment; filename=\""
	// + new String((findByName.getParament_value() + /* ���غ���ļ���
	// */".xls").getBytes("gb2312"), "ISO8859-1")
	// + "\"";
	// response.setContentType("octets/stream");
	// response.setContentType("APPLICATION/OCTET-STREAM");
	// response.setHeader("Content-Disposition", headStr);
	// out = response.getOutputStream();
	// ExportExcelSeedBack ex = new
	// ExportExcelSeedBack(findByName.getParament_value(),
	// /* ��ı��� */ new String[] { findByName.getParament_value()/* ���ݱ��� */ },
	// dataList/* ����׼�� ---��������ΪList<Object[]> */);
	// ex.export(out);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}
