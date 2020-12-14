package com.bahia.prices.service;

import java.time.LocalDateTime;

import com.bahia.prices.entity.Price;
import com.bahia.prices.response.PriceResponse;

public interface PriceService {

    PriceResponse getPrice(long productId, long brandId, LocalDateTime date);

    Price findPrice(long productId, long brandId, LocalDateTime date);
}
