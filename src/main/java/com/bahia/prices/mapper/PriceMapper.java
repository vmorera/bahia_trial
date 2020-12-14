package com.bahia.prices.mapper;

import com.bahia.prices.entity.Price;
import com.bahia.prices.response.PriceResponse;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {
    public PriceResponse sourceToDestination(Price source){
        return PriceResponse.builder()
                .productId(source.getProductId())
                .brand(source.getBrand())
                .startDate(source.getStartDate())
                .endDate(source.getEndDate())
                .priceList(source.getPriceList())
                .price(source.getPrice())
                .build();
    }
}