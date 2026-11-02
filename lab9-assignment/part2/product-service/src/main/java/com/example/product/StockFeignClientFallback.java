package com.example.product;

import org.springframework.stereotype.Component;

@Component
public class StockFeignClientFallback implements StockFeignClient {

    @Override
    public int getStock(String productNumber) {
        return 0;
    }
}