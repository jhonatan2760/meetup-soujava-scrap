package com.jhonatansouza.enums;

public enum MerchantOrigin {

    AMERICANAS("https://www.americanas.com.br/"),
    SUBMARINO("https://www.submarino.com.br/"),
    SHOPTIME("https://www.shoptime.com.br/");

    String merchantOrigin;
    MerchantOrigin(String merchantOrigin){
        this.merchantOrigin = merchantOrigin;
    }

    public String getOrigin(){
        return this.merchantOrigin;
    }
}
