package com.luv2tech.entity;

import com.luv2tech.entity.base.BaseAudit;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_book")
@Setter
@Getter
@ToString
public class Book extends BaseAudit {
    private String sku;
    private String name;
    private String description;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "units_in_stock")
    private int unitsInStock;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private BookCategory category;
}