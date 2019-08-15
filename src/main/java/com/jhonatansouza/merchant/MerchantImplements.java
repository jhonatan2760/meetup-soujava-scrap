package com.jhonatansouza.merchant;

import com.jhonatansouza.enums.MerchantOrigin;
import com.jhonatansouza.interfaces.Merchant;
import com.jhonatansouza.interfaces.Product;
import com.jhonatansouza.pojo.Produto;
import com.jhonatansouza.utils.FormataValor;
import com.jhonatansouza.web.WebPageDocument;
import org.jsoup.nodes.Element;

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
                        try {
                            Product product = this.createProduct(prod);

                            String totalCashback = new WebPageDocument(this.merchantOrigin.getOrigin().concat(product.getUrl()))
                                    .capture()
                                    .getElementsByClass("bvPBbl").text();
                            product.setTotalCashback(totalCashback);

                            productList.add(product);
                        } catch (IOException e) {
                            //e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productList;
    }

    private Product createProduct(Element selectedElement) {
        String urlProduto = selectedElement.getElementsByClass("cXaYNF").attr("href");
        String valoresProduto = new FormataValor(selectedElement.getElementsByClass(this.merchantOrigin == MerchantOrigin.AMERICANAS ? "doPTSH" : "eHnJri").text(), "$").toString();
        String nomeDoProduto = selectedElement.getElementsByClass(this.merchantOrigin == MerchantOrigin.AMERICANAS ? "kTphob" : "YHJwU").text();
        String img = selectedElement.getElementsByClass("enKgcp").attr("src");
        String totalCashback = "";
        return new Produto(nomeDoProduto, Double.parseDouble(valoresProduto), totalCashback, urlProduto, img);
    }

}
