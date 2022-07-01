package com.qindel.ecommerce.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductInformationDto{

    private Long brandId;

    private String startDate;

    private String endDate;

    private Integer priceList;

    private Integer productId;

    private Integer priority;

    private Double price;

    private String curr;
}
