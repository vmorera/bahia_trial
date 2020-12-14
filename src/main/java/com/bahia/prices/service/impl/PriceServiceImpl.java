package com.bahia.prices.service.impl;

import java.time.LocalDateTime;

import com.bahia.prices.entity.Price;
import com.bahia.prices.mapper.PriceMapper;
import com.bahia.prices.repository.PriceRepository;
import com.bahia.prices.response.PriceResponse;
import com.bahia.prices.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;

    private final PriceMapper mapper;

    @Override
    public PriceResponse getPrice(final long productId, final long brandId, final LocalDateTime date) {
        return mapper.sourceToDestination(findPrice(productId, brandId, date));
    }

    @Override
    public Price findPrice(final long productId, final long brandId, final LocalDateTime date) {
        return priceRepository.getAssignedPrice(productId, brandId, date).get(0);
    }
}
