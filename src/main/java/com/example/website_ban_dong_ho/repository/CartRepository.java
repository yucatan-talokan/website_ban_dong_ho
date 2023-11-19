package com.example.website_ban_dong_ho.repository;

import com.example.website_ban_dong_ho.entity.Cart;
import com.example.website_ban_dong_ho.entity.Product;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@SessionScope
public class CartRepository implements ICartRepository{
    Map<Integer,Cart>maps=new HashMap<>();

    @Override
    public void add(Cart item) {
        Cart cart=maps.get(item.getId());
        if (cart==null){
            maps.put(item.getId(),item);
        }
        else {
            cart.setQuantity(cart.getQuantity()+1);
        }
    }

    @Override
    public void remove(Integer id) {
        maps.remove(id);
    }

    @Override
    public Cart update(Integer id, Integer quantity) {
        Cart cart=maps.get(id);
        cart.setQuantity(quantity);
        return cart;
    }

    @Override
    public void deleteAll() {
        maps.clear();
    }

    @Override
    public Collection<Cart> getAll() {
        return maps.values();
    }

    @Override
    public Integer getTotalQuantity() {
        return maps.values().size();
    }

    @Override
    public BigDecimal getTotalPrice() {
        return maps.values().stream()
                .map(item->item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }

}
