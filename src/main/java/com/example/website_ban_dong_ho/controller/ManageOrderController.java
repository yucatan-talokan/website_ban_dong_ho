package com.example.website_ban_dong_ho.controller;

import com.example.website_ban_dong_ho.service.IOrderDetailService;
import com.example.website_ban_dong_ho.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/manage-order")
public class ManageOrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IOrderDetailService orderDetailService;

    @GetMapping()
    public String listOrder(Model model, @RequestParam(name = "page",defaultValue = "1") Integer page){
        if (page<1)page = 1;
        Pageable pageable= PageRequest.of(page-1,10);
        model.addAttribute("order",orderService.findPageDesc(pageable));
        return "order-managed/list";
    }
}
