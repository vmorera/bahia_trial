package com.bahia.prices.controller.impl;

import java.time.LocalDateTime;

import com.bahia.prices.controller.PriceController;
import com.bahia.prices.entity.Price;
import com.bahia.prices.response.PriceResponse;
import com.bahia.prices.service.PriceService;
import com.bahia.prices.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = Constants.PRICE_URI)
@RequiredArgsConstructor
public class PriceControllerImpl implements PriceController {

    private final PriceService priceService;

    @Override
    @GetMapping
    public ResponseEntity<PriceResponse> getRealPrice(final long productId,
                                                      final long brandId,
                                                      final LocalDateTime date) {
        return ResponseEntity.ok(priceService.getPrice(productId, brandId, date));
    }
}
