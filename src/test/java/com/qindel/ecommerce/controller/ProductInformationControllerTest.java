package com.qindel.ecommerce.controller;

import com.qindel.ecommerce.ECommerceApplication;
import com.qindel.ecommerce.model.dto.response.ProductResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ECommerceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductInformationControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String api = "http://localhost:%s/productInfo/date/%s/productId/%s/chain/%s";


    @Test
    public void getProductInfo1Test(){

        String datetime = "2020-06-14 10:00:00";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, datetime, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-14 00:00:00",
                "2020-12-31 23:59:59", 1, 35455, 35.5, null);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals(productResponseDto, productResponse.getBody());
    }

    @Test
    public void getProductInfo2Test(){

        String datetime = "2020-06-14 16:00:00";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, datetime, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-14 15:00:00",
                "2020-06-14 18:30:00", 2, 35455, 25.45, null);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals(productResponseDto, productResponse.getBody());
    }

    @Test
    public void getProductInfo3Test(){

        String datetime = "2020-06-14 21:00:00";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, datetime, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-14 00:00:00",
                "2020-12-31 23:59:59", 1, 35455, 35.5, null);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals(productResponseDto, productResponse.getBody());
    }

    @Test
    public void getProductInfo4Test(){

        String datetime = "2020-06-15 10:00:00";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, datetime, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-15 00:00:00",
                "2020-06-15 11:00:00", 3, 35455, 30.5, null);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals(productResponseDto, productResponse.getBody());
    }

    @Test
    public void getProductInfo5Test(){

        String datetime = "2020-06-16 21:00:00";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, datetime, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-15 16:00:00",
                "2020-12-31 23:59:59", 4, 35455, 38.95, null);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals(productResponseDto, productResponse.getBody());
    }

}
