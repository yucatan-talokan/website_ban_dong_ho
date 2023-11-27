package com.example.website_ban_dong_ho.controller;

import com.example.website_ban_dong_ho.entity.Brand;
import com.example.website_ban_dong_ho.entity.Category;
import com.example.website_ban_dong_ho.entity.Movement;
import com.example.website_ban_dong_ho.entity.Strap;
import com.example.website_ban_dong_ho.service.IBrandService;
import com.example.website_ban_dong_ho.service.ICategoryService;
import com.example.website_ban_dong_ho.service.IMovementService;
import com.example.website_ban_dong_ho.service.IStrapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/manage-property")
public class ManagePropertyController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IBrandService brandService;

    @Autowired
    private IStrapService strapService;

    @Autowired
    private IMovementService movementService;

    @GetMapping()
    public String findAll(Model model) {
        model.addAttribute("category", categoryService.findAll());
        model.addAttribute("brand", brandService.findAll());
        model.addAttribute("movement", movementService.findAll());
        model.addAttribute("strap", strapService.findAll());
        return "product-managed/property";
    }

    @PostMapping("/category/add")
    public String addCategory(@RequestParam(name = "name") String name) {
        Category c = new Category();
        c.setName(name);
        categoryService.save(c);
        return "redirect:/manage-property";
    }

    @GetMapping("/category/view-update")
    public String viewUpdateCategory(Model model, @RequestParam(name = "id") Integer id) {
        Category c=categoryService.findById(id);
        model.addAttribute("c",c);
        return "product-managed/category/update";
    }

    @PostMapping("category/update")
    public String updateCategory(@RequestParam(name = "id") Integer id,
                                 @RequestParam(name = "name") String name){
        Category c=categoryService.findById(id);
        c.setName(name);
        categoryService.save(c);
        return "redirect:/manage-property";
    }

    @GetMapping("category/delete")
    public String deleteCategory(@RequestParam(name = "id") Integer id){
        categoryService.delete(id);
        return "redirect:/manage-property";
    }

    @PostMapping("/brand/add")
    public String addBrand(@RequestParam(name = "name") String name) {
        Brand b = new Brand();
        b.setName(name);
        brandService.save(b);
        return "redirect:/manage-property";
    }

    @GetMapping("/brand/view-update")
    public String viewUpdateBrand(Model model, @RequestParam(name = "id") Integer id) {
        Brand b = brandService.findById(id);
        model.addAttribute("b", b);
        return "product-managed/brand/update";
    }

    @PostMapping("/brand/update")
    public String updateBrand(@RequestParam(name = "id") Integer id,
                              @RequestParam(name = "name") String name) {
        Brand b = brandService.findById(id);
        b.setName(name);
        brandService.save(b);
        return "redirect:/manage-property";
    }

    @GetMapping("/brand/delete")
    public String deleteBrand(@RequestParam(name = "id") Integer id){
        brandService.delete(id);
        return "redirect:/manage-property";
    }

    @PostMapping("/strap/add")
    public String addStrap(@RequestParam(name = "name") String name) {
        Strap s = new Strap();
        s.setName(name);
        strapService.save(s);
        return "redirect:/manage-property";
    }

    @GetMapping("/strap/view-update")
    public String viewUpdateStrap(Model model,@RequestParam(name = "id")Integer id) {
        Strap s=strapService.findById(id);
        model.addAttribute("s",s);
        return "product-managed/strap/update";
    }

    @PostMapping("/strap/update")
    public String updateStrap(@RequestParam(name = "id")Integer id,
                              @RequestParam(name = "name")String name){
        Strap s=strapService.findById(id);
        s.setName(name);
        strapService.save(s);
        return "redirect:/manage-property";
    }

    @GetMapping("/strap/delete")
    public String deleteStrap(@RequestParam(name = "id")Integer id){
        strapService.delete(id);
        return "redirect:/manage-property";
    }

    @PostMapping("/movement/add")
    public String addMovement(@RequestParam(name = "name") String name) {
        Movement m = new Movement();
        m.setName(name);
        movementService.save(m);
        return "redirect:/manage-property";
    }

    @GetMapping("/movement/view-update")
    public String viewUpdateMovement(Model model,@RequestParam(name = "id")Integer id){
        Movement m= movementService.findById(id);
        model.addAttribute("m",m);
        return "product-managed/movement/update";
    }

    @PostMapping("/movement/update")
    public String updateMovement(@RequestParam(name = "id")Integer id,
                                 @RequestParam(name = "name")String name){
        Movement m= movementService.findById(id);
        m.setName(name);
        movementService.save(m);
        return "redirect:/manage-property";
    }

    @GetMapping("/movement/delete")
    public String deleteMovement(@RequestParam(name = "id")Integer id){
        movementService.delete(id);
        return "redirect:/manage-property";
    }
}
