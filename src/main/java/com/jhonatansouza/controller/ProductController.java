package com.jhonatansouza.controller;

import com.jhonatansouza.enums.MerchantOrigin;
import com.jhonatansouza.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(){}

    @GetMapping("/{merchant}")
    public ResponseEntity findProduct(@PathVariable("merchant")  MerchantOrigin merchantOrigin,
                                      @RequestParam("produto")   String productName){
        return ResponseEntity.of(this.productService.findProduct(productName, merchantOrigin));
    }

    @GetMapping("/")
    public String healt(){
        return "toasty";
    }
}
