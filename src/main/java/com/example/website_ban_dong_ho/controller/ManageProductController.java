package com.example.website_ban_dong_ho.controller;

import com.example.website_ban_dong_ho.entity.Product;
import com.example.website_ban_dong_ho.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manage-products")
public class ManageProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String getListProduct(Model model, @RequestParam(defaultValue = "1",name = "page") Integer page) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Product> products = productService.findPage(pageable);
        model.addAttribute("products", products);
        return "product-managed/list";
    }

    @GetMapping("/detail")
    public String detail (Model model, @RequestParam (name = "id") Integer id){
        Product p=productService.findById(id);
        model.addAttribute("p", p);
        return "product-managed/detail";
    }
}
