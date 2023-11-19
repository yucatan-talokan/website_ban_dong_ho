package com.example.website_ban_dong_ho.interceptor;

import com.example.website_ban_dong_ho.service.ICartService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class CartInterceptor  implements HandlerInterceptor {
    @Autowired
    private ICartService cartService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("totalPrice",cartService.getTotalPrice());
        request.setAttribute("totalQuantity",cartService.getTotalQuantity());
    }
}
