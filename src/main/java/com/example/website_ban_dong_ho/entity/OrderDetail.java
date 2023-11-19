package com.example.website_ban_dong_ho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "totalprice")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "productid",referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderid",referencedColumnName = "id")
    private Order order;

    public OrderDetail(Integer quantity, BigDecimal totalPrice, Product product, Order order) {
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.product = product;
        this.order = order;
    }
}
