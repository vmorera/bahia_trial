package com.bahia.prices.controller;

import java.time.LocalDateTime;

import com.bahia.prices.entity.Price;
import com.bahia.prices.response.PriceResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface PriceController {

    @ApiOperation(value = "Get Price for moment", response = Price.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")})
    ResponseEntity<PriceResponse> getRealPrice(@RequestParam long productId,
                                               @RequestParam long brandId,
                                               @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date);
}
