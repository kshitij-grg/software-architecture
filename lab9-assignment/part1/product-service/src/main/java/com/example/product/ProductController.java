package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private StockFeignClient stockFeignClient;

    @GetMapping("/product/{productNumber}")
    public Product getProduct(@PathVariable("productNumber")  String productNumber) {
        int numberOnStock = stockFeignClient.getStock(productNumber);

        return new Product(
                productNumber,
                "Laptop",
                numberOnStock
        );
    }
}
