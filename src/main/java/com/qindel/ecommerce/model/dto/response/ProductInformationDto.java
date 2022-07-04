package com.qindel.ecommerce.model.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductInformationDto{

    private Long brandId;

    private Date startDate;

    private Date endDate;

    private Integer priceList;

    private Integer productId;

    private Integer priority;

    private Double price;

    private String curr;
}
