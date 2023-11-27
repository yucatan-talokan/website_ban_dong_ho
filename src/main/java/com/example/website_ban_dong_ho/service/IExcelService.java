package com.example.website_ban_dong_ho.service;

import com.example.website_ban_dong_ho.entity.Product;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface IExcelService {
    Workbook createExcel(List<Product>list);
}
