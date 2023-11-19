package com.example.website_ban_dong_ho.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @CreatedDate
    @Column(name = "createdate")
    private Date createDate;

    @Column(name = "paymentmethod")
    private String paymentMethod;

    @Column(name = "deliveryaddress")
    private String deliveryAddress;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetail>orderDetails;
}
