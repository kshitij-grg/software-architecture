package com.example.stock;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @GetMapping("/stock/{productNumber}")
    public int getStock(@PathVariable("productNumber") String productNumber) {
        return 350;
    }
}
