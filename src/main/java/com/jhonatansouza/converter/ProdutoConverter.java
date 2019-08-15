package com.jhonatansouza.converter;

import com.jhonatansouza.model.Produto;
import com.jhonatansouza.utils.FormataValor;
import org.jsoup.nodes.Document;

public class ProdutoConverter {

    private Document document;

    public ProdutoConverter(Document document) {
        this.document = document;
    }

    public Produto getProduto(){
        String urlProduto = document.getElementsByClass("cXaYNF").attr("href");
        String valoresProduto = new FormataValor( document.getElementsByClass("doPTSH").text(), "$" ).toString();
        String nomeDoProduto = document.getElementsByClass("kTphob").text();

        Produto p = new Produto();
        p.setNome(nomeDoProduto);
        p.setValor(Double.parseDouble(valoresProduto));
        p.setCashback("");
        p.setUrl(urlProduto);
        return p;
    }
}
