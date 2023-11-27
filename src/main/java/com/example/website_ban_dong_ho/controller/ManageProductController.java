package com.example.website_ban_dong_ho.controller;

import com.example.website_ban_dong_ho.entity.Product;
import com.example.website_ban_dong_ho.service.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/manage-products")
public class ManageProductController {

    private final FileUpload fileUpload;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private IStrapService strapService;

    @Autowired
    private IMovementService movementService;

    @Autowired
    private IExcelService excelService;


    @GetMapping()
    public String getListProduct(Model model, @RequestParam(defaultValue = "1", name = "page") Integer page) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Product> products = productService.findPage(pageable);
        model.addAttribute("products", products);
        return "product-managed/list";
    }

    @GetMapping("/detail")
    public String detail(Model model, @RequestParam(name = "id") Integer id) {
        Product p = productService.findById(id);
        model.addAttribute("p", p);
        return "product-managed/detail";
    }

    @GetMapping("/view-add")
    public String viewAdd(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("brand", brandService.findAll());
        model.addAttribute("movement", movementService.findAll());
        model.addAttribute("strap", strapService.findAll());
        return "product-managed/add";
    }

    @PostMapping("/add")
    public String add(@RequestParam(name = "shortName") String shortName,
                      @RequestParam(name = "name") String name,
                      @RequestParam(name = "price") BigDecimal price,
                      @RequestParam(name = "image") MultipartFile multipartFile,
                      @RequestParam(name = "brand") Integer brandId,
                      @RequestParam(name = "category") Integer categoryId,
                      @RequestParam(name = "movement") Integer movementId,
                      @RequestParam(name = "strap") Integer strapId
    ) throws IOException {
        Map uploadResult = fileUpload.uploadFile(multipartFile);
        Product p = new Product(
                null,
                shortName,
                name,
                (String) uploadResult.get("url"),
                (String) uploadResult.get("public_id"),
                price,
                brandService.findById(brandId),
                categoryService.findById(categoryId),
                strapService.findById(strapId),
                movementService.findById(movementId));
        productService.save(p);
        return "redirect:/manage-products";
    }

    @GetMapping("/view-update")
    public String viewUpdate(Model model,
                             @RequestParam(name = "id") Integer id) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("brand", brandService.findAll());
        model.addAttribute("movement", movementService.findAll());
        model.addAttribute("strap", strapService.findAll());
        return "product-managed/update";
    }

    @PostMapping("/update")
    public String update(@RequestParam(name = "id")Integer id,
                         @RequestParam(name = "shortName") String shortName,
                         @RequestParam(name = "name") String name,
                         @RequestParam(name = "price") BigDecimal price,
                         @RequestParam(name = "image") MultipartFile multipartFile,
                         @RequestParam(name = "brand") Integer brandId,
                         @RequestParam(name = "category") Integer categoryId,
                         @RequestParam(name = "movement") Integer movementId,
                         @RequestParam(name = "strap") Integer strapId
                         ) throws IOException {
        Product p=productService.findById(id);
        if (multipartFile!=null&&!multipartFile.isEmpty()){
            Map uploadResult =fileUpload.updateFile(productService.findById(id).getImageId(),multipartFile);
            p.setShortName(shortName);
            p.setName(name);
            p.setPrice(price);
            p.setImage((String) uploadResult.get("url"));
            p.setImageId((String) uploadResult.get("public_id"));
            p.setBrand(brandService.findById(brandId));
            p.setCategory(categoryService.findById(categoryId));
            p.setMovement(movementService.findById(movementId));
            p.setStrap(strapService.findById(strapId));
            productService.save(p);
        }
        else {
            p.setShortName(shortName);
            p.setName(name);
            p.setPrice(price);
            p.setBrand(brandService.findById(brandId));
            p.setCategory(categoryService.findById(categoryId));
            p.setMovement(movementService.findById(movementId));
            p.setStrap(strapService.findById(strapId));
            productService.save(p);
        }
        return "redirect:/manage-products";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id) throws IOException {
        productService.delete(id);
        return "redirect:/manage-products";
    }

    @GetMapping("/export-excel")
    public void exportExcel(HttpServletResponse response)throws IOException{
        List<Product>list=productService.findAll();
        Workbook workbook=excelService.createExcel(list);
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=DanhSachSanPham.xlsx");
        workbook.write(response.getOutputStream());
        workbook.close();
    }
}
