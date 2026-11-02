package com.example.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "StockService")
public interface StockFeignClient {

    @GetMapping("/stock/{productNumber}")
    int getStock(@PathVariable("productNumber") String productNumber);
}
