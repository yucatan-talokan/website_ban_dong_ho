package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Product;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class ExcelService implements IExcelService{
    @Override
    public Workbook createExcel(List<Product> list) {
        Workbook workbook=new XSSFWorkbook();
        Sheet sheet=workbook.createSheet("Danh sach san pham");
        Row headerRow= sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Mã hàng");
        headerRow.createCell(1).setCellValue("Tên hàng");
        headerRow.createCell(2).setCellValue("Hình ảnh");
        headerRow.createCell(3).setCellValue("Giá");
        headerRow.createCell(4).setCellValue("Tên hãng");
        headerRow.createCell(5).setCellValue("Tên danh mục");
        headerRow.createCell(6).setCellValue("Chất liệu dây");
        headerRow.createCell(7).setCellValue("Loại máy");

        int rowNum=1;
        for (Product p:list){
            Row row=sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(p.getId());
            row.createCell(1).setCellValue(p.getName());
            row.createCell(2).setCellValue(p.getImage());
            row.createCell(3).setCellValue(String.valueOf(p.getPrice()));
            row.createCell(4).setCellValue(p.getBrand().getName());
            row.createCell(5).setCellValue(p.getCategory().getName());
            row.createCell(6).setCellValue(p.getStrap().getName());
            row.createCell(7).setCellValue(p.getMovement().getName());
        }
        return workbook;
    }
}
