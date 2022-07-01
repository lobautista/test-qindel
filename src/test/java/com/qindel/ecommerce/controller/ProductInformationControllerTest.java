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

    private static final String api = "http://localhost:%s/productInfo/time/%s/date/%s/productId/%s/chain/%s";


    @Test
    public void getProductInfo1Test(){

        String time = "10:00";
        String date = "14";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, time, date, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-14-00.00.00",
                "2020-11-31-23.59.59", 5, 35455, 40.5);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals(productResponseDto, productResponse.getBody());
    }

    @Test
    public void getProductInfo2Test(){

        String time = "16:00";
        String date = "14";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, time, date, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-14-15.00.00",
                "2020-06-14-18.30.00", 2, 35455, 25.45);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals(productResponseDto, productResponse.getBody());
    }

    @Test
    public void getProductInfo3Test(){

        String time = "21:00";
        String date = "14";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, time, date, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-14-00.00.00",
                "2020-11-31-23.59.59", 5, 35455, 40.5);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals(productResponseDto, productResponse.getBody());
    }

    @Test
    public void getProductInfo4Test(){

        String time = "10:00";
        String date = "15";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, time, date, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-15-00.00.00",
                "2020-06-15-11.00.00", 3, 35455, 30.5);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals(productResponseDto, productResponse.getBody());
    }

    @Test
    public void getProductInfo5Test(){

        String time = "21:00";
        String date = "16";
        Integer productId = 35455;
        Long chain = 1L;
        String apiTest = String.format(this.api, this.port, time, date, productId, chain);
        ProductResponseDto productResponseDto = new ProductResponseDto(1L, "2020-06-15-00.00.00",
                "2020-06-15-11.00.00", 3, 35455, 30.5);

        ResponseEntity<ProductResponseDto> productResponse = this.restTemplate
                .getForEntity(apiTest, ProductResponseDto.class);

        assertEquals("No information for the given input. Exception message: null", productResponse.getBody().getError());
        assertEquals(HttpStatus.NOT_FOUND, productResponse.getStatusCode());
    }

}
