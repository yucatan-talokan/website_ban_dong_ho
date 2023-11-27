package com.example.website_ban_dong_ho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "products")
@NoArgsConstructor
public class Product{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "shortname")
    private String shortName;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "imageid")
    private String imageId;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "brandid", referencedColumnName ="id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "strapid",referencedColumnName = "id")
    private Strap strap;

    @ManyToOne
    @JoinColumn(name = "movementid",referencedColumnName = "id")
    private Movement movement;
}