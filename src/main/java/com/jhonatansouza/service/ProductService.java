package com.jhonatansouza.service;

import com.jhonatansouza.enums.MerchantOrigin;
import com.jhonatansouza.interfaces.Product;

import java.util.Comparator;
import java.util.Optional;

import com.jhonatansouza.merchant.MerchantImplements;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public Optional<Product> findProduct(String productName, MerchantOrigin merchantOrigin){
        return new MerchantImplements(merchantOrigin)
                .grabProducts(productName)
                .parallelStream()
                .min(Comparator.comparingDouble(Product::getValor));
    }

}
