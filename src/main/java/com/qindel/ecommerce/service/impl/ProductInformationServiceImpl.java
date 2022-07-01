package com.qindel.ecommerce.service.impl;

import com.qindel.ecommerce.model.dto.response.ProductInformationDto;
import com.qindel.ecommerce.model.dto.response.ProductResponseDto;
import com.qindel.ecommerce.repository.ProductInformationRepository;
import com.qindel.ecommerce.service.ProductInformationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
public class ProductInformationServiceImpl implements ProductInformationService {

    @Autowired
    private ProductInformationRepository productInformationRepository;
    @Override
    public ProductResponseDto getProductInformation(String time, String date,
                                                    Integer productId, Long chain) throws NoSuchElementException{

        List<ProductInformationDto> productList = productInformationRepository.getProductInformation(chain, productId);
        ProductResponseDto response = getProductInRange(productList, time, date);
        return response;
    }

    private ProductResponseDto getProductInRange(List<ProductInformationDto> productList, final String time, final String date) {

        ProductInformationDto product = productList.stream().filter(p -> {

            DecimalFormat decimalFormat = new DecimalFormat("00");
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
            LocalDateTime startLocalDate = LocalDateTime.parse(p.getStartDate(), dateFormatter);
            LocalDateTime endLocalDate = LocalDateTime.parse(p.getEndDate(), dateFormatter);
            LocalDateTime inputDateTime = null;
            if(String.valueOf(startLocalDate.getDayOfMonth()).equals(date)) {
                StringBuilder sb = new StringBuilder();
                sb.append(startLocalDate.getYear());
                sb.append("-");
                sb.append(decimalFormat.format(Double.valueOf(startLocalDate.getMonthValue())));
                sb.append("-");
                sb.append(decimalFormat.format(Double.valueOf(startLocalDate.getDayOfMonth())));
                sb.append(" ");
                sb.append(time);
                sb.append(":00");

                dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                inputDateTime = LocalDateTime.parse(sb.toString(), dateFormatter);
            }

            return null != inputDateTime && inputDateTime.isAfter(startLocalDate)
                    && inputDateTime.isBefore(endLocalDate);
        }).max(Comparator.comparing(ProductInformationDto::getPriority)).orElseThrow(NoSuchElementException::new);

        return new ProductResponseDto(product.getBrandId(), product.getStartDate(), product.getEndDate(),
                product.getPriceList(), product.getProductId(), product.getPrice());
    }
}
