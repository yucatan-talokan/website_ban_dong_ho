package com.example.website_ban_dong_ho.controller;

import com.example.website_ban_dong_ho.entity.Cart;
import com.example.website_ban_dong_ho.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService cartService;

    @GetMapping("/viewCart")
    public String showCart(Model model){
        List<Cart> cartList = cartService.getAll().stream().toList();
        model.addAttribute("products",cartList);
        return "cart/shopping-cart";
    }
}
