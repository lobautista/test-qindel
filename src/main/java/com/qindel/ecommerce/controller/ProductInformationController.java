package com.qindel.ecommerce.controller;

import com.qindel.ecommerce.model.dto.response.ProductResponseDto;
import com.qindel.ecommerce.service.ProductInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/productInfo")
public class ProductInformationController {

    @Autowired
    private ProductInformationService productInformationService;

    @GetMapping("/time/{time}/date/{date}/productId/{productId}/chain/{chain}")
    public ResponseEntity<ProductResponseDto> getProductInfo(@PathVariable("time") String time,
                                         @PathVariable("date") String date,
                                         @PathVariable("productId") Integer productId,
                                         @PathVariable("chain") Long chain) {

        try {
            ProductResponseDto productResponseDto = productInformationService
                    .getProductInformation(time, date, productId, chain);
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } catch (NoSuchElementException ex){
            return new ResponseEntity<>(new ProductResponseDto("No information for the given input. Exception message: " + ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
