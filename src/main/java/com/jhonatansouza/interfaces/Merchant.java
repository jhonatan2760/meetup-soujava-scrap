package com.jhonatansouza.interfaces;

import com.jhonatansouza.enums.MerchantOrigin;

import java.util.List;

public abstract class Merchant {

    public abstract List<Product> grabProducts(String productName);

}
