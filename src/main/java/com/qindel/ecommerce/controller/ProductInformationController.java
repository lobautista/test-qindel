package com.qindel.ecommerce.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qindel.ecommerce.model.dto.response.ProductResponseDto;
import com.qindel.ecommerce.service.ProductInformationService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/productInfo")
@Slf4j
public class ProductInformationController {

	private static String inputDateFormat = "yyyy-MM-dd-HH.mm.ss";

    @Autowired
    private ProductInformationService productInformationService;

	@GetMapping("/date/{date}/productId/{productId}/chain/{chain}")
	public ResponseEntity<ProductResponseDto> getProductInfo(
			@PathVariable("date") String date,
			@PathVariable("productId") Integer productId,
			@PathVariable("chain") Long chain) {

        try {
        	date = convertToISO8601(date);
            ProductResponseDto productResponseDto = productInformationService
                    .getProductInformation(date, productId, chain);
            return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
        } catch (NoSuchElementException ex){
            return new ResponseEntity<>(new ProductResponseDto("No information for the given input. Exception message: " + ex.getMessage()), HttpStatus.NOT_FOUND);
        }
    }

	private String convertToISO8601(String notFormattedDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(inputDateFormat);
		SimpleDateFormat sdfISO8601 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = sdf.parse(notFormattedDate);
			return sdfISO8601.format(date);
		} catch (ParseException e) {
			try {
				sdfISO8601.parse(notFormattedDate);
				return notFormattedDate;
			} catch (ParseException e1) {
				log.error("Incorrect date format. It should be " + inputDateFormat, e);
			}
			log.error("Incorrect date format. It should be " + inputDateFormat, e);
		}
		return null;
	}
}
