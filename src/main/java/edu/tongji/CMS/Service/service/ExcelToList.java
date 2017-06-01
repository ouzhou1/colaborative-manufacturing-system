package edu.tongji.CMS.Service.service;

import edu.tongji.CMS.dao.services.ServicesDao;
import edu.tongji.CMS.domain.Services;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ouzhou on 2017/5/25.
 */

@Service
public class ExcelToList {

    @Autowired
    ServicesDao servicesDao;

    public List<Services> convertExcelToArrayList(String filepath) throws Exception {
        List<Services> result = new ArrayList<>();
        int version = 2003;
        final InputStream is = new FileInputStream(filepath);

        if (filepath.endsWith(".xls"))
            version = 2003;
        else if (filepath.endsWith(".xlsx"))
            version = 2007;

        Workbook workbook = null;
        if (version == 2003) {
            workbook = new HSSFWorkbook(is);
        } else if (version == 2007) {
            workbook = new XSSFWorkbook(is);
        }

        // Get workbook sheet
        List<Services> cityList = new ArrayList<>();
        for(int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            if(sheet == null) continue;
            // Get rows in a sheet
            for(int r = 1; r <= sheet.getLastRowNum(); r++) {
                Row row = sheet.getRow(r);
                if(row == null) continue;
                Services services = new Services();
                // Get cells in a row
                double s = Double.valueOf(getValue(row.getCell(0)));
                services.setId((long) s);
                services.setCategory(getValue(row.getCell(1)));
                services.setOwner(getValue(row.getCell(2)));
                services.setServicename(getValue(row.getCell(row.getLastCellNum()-1)));
                result.add(services);
            }
        }
        return result;
    }

    private String getValue(Cell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            // 返回数值类型的值
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            // 返回字符串类型的值
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    public static void main(String[] s) {
        try {
            List<Services> city = new ExcelToList().convertExcelToArrayList("D:\\ouzhou\\test.xlsx");
            for(Services item : city) {
                System.out.println(item.getId()+item.getCategory()+item.getOwner()+item.getServicename());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}