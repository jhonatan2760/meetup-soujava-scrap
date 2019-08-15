package com.jhonatansouza.controller;

import com.jhonatansouza.enums.MerchantOrigin;
import com.jhonatansouza.response.ProdutoResponse;
import com.jhonatansouza.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(){}

    @GetMapping("/{merchant}")
    public ResponseEntity findProduct(@PathVariable("merchant")@NotNull @NotEmpty MerchantOrigin merchantOrigin,
                                      @RequestParam("produto")@NotNull @NotEmpty String productName){
        return ResponseEntity.of(this.productService
                .findProduct(productName, merchantOrigin)
                .map(ProdutoResponse::fromModel));
    }

    @GetMapping("/")
    public String healt(){
        return "toasty";
    }
}
