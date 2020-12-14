package com.bahia.prices.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.bahia.prices.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PriceRepository extends JpaRepository<Price, Long>{

    @Query(value = "SELECT p FROM Price p " +
            "WHERE PRODUCT_ID= :productId " +
            "AND BRAND_ID= :brandId " +
            "AND START_DATE <= :date " +
            "AND END_DATE >= :date " +
            "ORDER BY PRIORITY DESC")
    List<Price> getAssignedPrice(@Param("productId") long productId, @Param("brandId")long brandId,
                                 @Param("date")LocalDateTime date);
}
