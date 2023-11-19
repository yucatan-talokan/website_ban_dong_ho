package com.example.website_ban_dong_ho.controller;

import com.example.website_ban_dong_ho.entity.Cart;
import com.example.website_ban_dong_ho.entity.Product;
import com.example.website_ban_dong_ho.service.ICartService;
import com.example.website_ban_dong_ho.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService service;

    @Autowired
    private ICartService cartService;


    @GetMapping()
    public String getAll(Model model,@RequestParam(defaultValue = "1",name = "page") Integer page) {
        if (page == 0)page=1;
        Pageable pageable= PageRequest.of(page-1,9);
        Page<Product> listPage=service.findPage(pageable);

        model.addAttribute("products", listPage);
        return "guest/list";
    }

    @GetMapping("/details")
    public String details(Model model,
                          @RequestParam(name = "id")Integer id) {
        Product p=service.findById(id);
        model.addAttribute("p", p);
        return "guest/detail";
    }

    @GetMapping("/findByCategory")
    public String findById(Model model,
                           @RequestParam(name = "id")Integer id) {
        List<Product>listByCategory = service.findByCategoryId(id);
        model.addAttribute("products", listByCategory);
        return "guest/list";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam(name = "id")Integer id){
        Product product = service.findById(id);
        Cart cart=new Cart();
        cart.setId(product.getId());
        cart.setName(product.getName());
        cart.setPrice(product.getPrice());
        cartService.add(cart);
        System.out.println(cartService.getAll());
        return "redirect:/products";
    }
}
