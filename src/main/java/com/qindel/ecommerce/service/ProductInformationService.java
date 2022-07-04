package com.qindel.ecommerce.service;

import com.qindel.ecommerce.model.dto.response.ProductResponseDto;

public interface ProductInformationService {

	public ProductResponseDto getProductInformation(String date, Integer id, Long chain);
}
