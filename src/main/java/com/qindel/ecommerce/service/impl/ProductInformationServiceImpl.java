package com.qindel.ecommerce.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qindel.ecommerce.model.dto.response.ProductResponseDto;
import com.qindel.ecommerce.repository.ProductInformationRepository;
import com.qindel.ecommerce.service.ProductInformationService;

@Service
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    private ProductInformationRepository productInformationRepository;
    @Override
    public ProductResponseDto getProductInformation(String date,
                                                    Integer productId, Long chain) throws NoSuchElementException{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return productInformationRepository.getProductInformation(chain, productId, Timestamp.valueOf(date)).stream()
				.map(p -> new ProductResponseDto(p.getBrandId(), sdf.format(p.getStartDate().getTime()), sdf.format(p.getEndDate().getTime()), p.getPriceList(), p.getProductId(),
						p.getPrice(), null))
				.findFirst().orElse(null);
	}
}
