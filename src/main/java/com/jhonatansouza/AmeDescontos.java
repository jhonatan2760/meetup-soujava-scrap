package com.jhonatansouza;

import com.jhonatansouza.enums.MerchantOrigin;
import com.jhonatansouza.interfaces.Product;
import com.jhonatansouza.merchant.MerchantImplements;
import com.jhonatansouza.pojo.Produto;
import com.jhonatansouza.utils.FormataValor;
import com.jhonatansouza.web.WebPageDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SpringBootApplication
public class AmeDescontos {

    public static void main(String [] args) throws IOException {
        SpringApplication.run(AmeDescontos.class, args);
    }

}
