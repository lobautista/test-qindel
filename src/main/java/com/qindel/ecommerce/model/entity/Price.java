package com.qindel.ecommerce.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Prices")
@Data
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_ID")
    private Long priceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    private Chain brandId;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "PRICE")
    private Double price;

    @Column(name = "CURR")
    private String curr;

    private static final long serialVersionUID = 1L;
}
