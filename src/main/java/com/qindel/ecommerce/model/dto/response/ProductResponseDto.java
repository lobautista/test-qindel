package com.qindel.ecommerce.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long idCadena;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fechaInicio;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fechaFin;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer tarifa;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer idProducto;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double precioFinal;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;


    public ProductResponseDto(String error) {
        this.error = error;
    }
}
