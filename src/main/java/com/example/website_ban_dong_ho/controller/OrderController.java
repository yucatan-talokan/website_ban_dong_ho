package com.example.website_ban_dong_ho.controller;

import com.example.website_ban_dong_ho.entity.Cart;
import com.example.website_ban_dong_ho.entity.Order;
import com.example.website_ban_dong_ho.entity.OrderDetail;
import com.example.website_ban_dong_ho.entity.Product;
import com.example.website_ban_dong_ho.service.ICartService;
import com.example.website_ban_dong_ho.service.IOrderDetailService;
import com.example.website_ban_dong_ho.service.IOrderService;
import com.example.website_ban_dong_ho.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private ICartService cartService;
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IOrderDetailService orderDetailService;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();

    @GetMapping("/checkout")
    public String checkout(Model model) {
        List<Cart> cartList = cartService.getAll().stream().toList();
        model.addAttribute("products", cartList);
        model.addAttribute("dateNow", date);
        return "order/checkout";
    }

    @PostMapping("/purchase")
    public String purchase(@RequestParam(name = "address") String address) {
        Order order = new Order();
        order.setCreateDate(date);
        order.setDeliveryAddress(address);
        List<OrderDetail> listOrderDetails = cartService.getAll().stream()
                .map(cart -> new OrderDetail(cart.getQuantity(), cart.getPrice(), productService.findById(cart.getId()),order))
                .toList();
        order.setOrderDetails(listOrderDetails);
        orderService.save(order);
        cartService.deleteAll();
        return "redirect:/orders/list";
    }

    @GetMapping("/list")
    public String listOrders(Model model) {
        List<Order> listOrders = orderService.findAllDesc();
        model.addAttribute("listOrders", listOrders);
        return "order/list";
    }

    @GetMapping("/detail")
    public String detailOrders(Model model, @RequestParam(name = "id") Integer id) {
        Order order = orderService.findById(id);
        model.addAttribute("detailOrders", order);
        return "order/detail";
    }

}
