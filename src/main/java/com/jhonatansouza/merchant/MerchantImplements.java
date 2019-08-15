package com.jhonatansouza.merchant;

import com.jhonatansouza.enums.MerchantOrigin;
import com.jhonatansouza.interfaces.Merchant;
import com.jhonatansouza.interfaces.Product;
import com.jhonatansouza.pojo.Produto;
import com.jhonatansouza.utils.FormataValor;
import com.jhonatansouza.web.WebPageDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MerchantImplements implements Merchant {

    private WebPageDocument webPageDocument;
    private MerchantOrigin merchantOrigin;

    public MerchantImplements(MerchantOrigin merchantOrigin) {
        this.webPageDocument = new WebPageDocument(merchantOrigin.getOrigin().concat("busca"));
        this.merchantOrigin = merchantOrigin;
    }

    @Override
    public List<Product> grabProducts(String productName) {
        List<Product> productList = new ArrayList<>();
        try {

            this.webPageDocument
                    .doSearch(productName)
                    .getElementsByClass("Link-sc-1m3ayw0-2")
                    .forEach(prod -> {

                        String urlProduto = prod.getElementsByClass("cXaYNF").attr("href");
                        String valoresProduto = new FormataValor(prod.getElementsByClass(this.merchantOrigin == MerchantOrigin.AMERICANAS ? "doPTSH" : "eHnJri").text(), "$").toString();
                        String nomeDoProduto = prod.getElementsByClass(this.merchantOrigin == MerchantOrigin.AMERICANAS ? "kTphob" : "YHJwU").text();
                        String totalCashback = "";
                        String img = prod.getElementsByClass("enKgcp").attr("src");

                        try {
                            totalCashback = new WebPageDocument(this.merchantOrigin.getOrigin().concat(urlProduto))
                                    .capture()
                                    .getElementsByClass("bvPBbl").text();
                        } catch (IOException e) {
                            //e.printStackTrace();
                        }
                        productList.add(new Produto(nomeDoProduto, Double.parseDouble(valoresProduto), totalCashback, urlProduto, img));
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

}
