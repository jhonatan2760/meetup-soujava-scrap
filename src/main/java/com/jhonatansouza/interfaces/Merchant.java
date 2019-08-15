package com.jhonatansouza.interfaces;

import com.jhonatansouza.enums.MerchantOrigin;

import java.util.List;

public interface Merchant {

    List<Product> grabProducts(String productName);

}
