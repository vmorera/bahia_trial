package com.bahia.prices.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bahia.prices.entity.Brand;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PriceResponse {

    @ApiModelProperty(notes = "identificador de producto")
    private long productId;

    @ApiModelProperty(notes = "identificador de cadena")
    private Brand brand;

    @ApiModelProperty(notes = "tarifa a aplicar")
    private long priceList;

    @ApiModelProperty(notes = "fecha de comienzo de aplicación")
    private LocalDateTime startDate;

    @ApiModelProperty(notes = "fecha de finalización de aplicación")
    private LocalDateTime endDate;

    @ApiModelProperty(notes = "precio final a aplicar.")
    private BigDecimal price;
}
