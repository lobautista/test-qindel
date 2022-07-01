package com.qindel.ecommerce.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHAINS")
@Data
public class Chain {

    @Id
    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name = "NAME")
    private String name;

    private static final long serialVersionUID = 1L;
}
