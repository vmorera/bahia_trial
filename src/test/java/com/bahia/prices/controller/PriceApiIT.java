package com.bahia.prices.controller;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PriceApiIT {

    @Autowired
    protected MockMvc mockMvc;

    @Test
    public void testGetClientData_case1() throws Exception {
        mockMvc.perform(
                get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14T10:00:00")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brand.id").value(1L))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("35.5")));
    }

    @Test
    public void testGetClientData_case2() throws Exception {
        mockMvc.perform(
                get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14T16:00:00")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brand.id").value(1L))
                .andExpect(jsonPath("$.priceList").value(2))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("25.45")));
    }

    @Test
    public void testGetClientData_case3() throws Exception {
        mockMvc.perform(
                get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-14T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brand.id").value(1L))
                .andExpect(jsonPath("$.priceList").value(1))
                .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("35.5")));
    }
    @Test
    public void testGetClientData_case4() throws Exception {
        mockMvc.perform(
                get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-15T10:00:00")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brand.id").value(1L))
                .andExpect(jsonPath("$.priceList").value(3))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("30.5")));
    }

    @Test
    public void testGetClientData_case5() throws Exception {
        mockMvc.perform(
                get("/price")
                        .param("productId", "35455")
                        .param("brandId", "1")
                        .param("date", "2020-06-16T21:00:00")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.productId").value(35455))
                .andExpect(jsonPath("$.brand.id").value(1L))
                .andExpect(jsonPath("$.priceList").value(4))
                .andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
                .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
                .andExpect(jsonPath("$.price").value(new BigDecimal("38.95")));
    }
}
