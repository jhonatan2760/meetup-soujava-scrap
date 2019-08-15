package com.jhonatansouza;

import com.jhonatansouza.model.Produto;
import com.jhonatansouza.utils.FormataValor;
import com.jhonatansouza.web.WebPageDocument;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Americanas {

    public static void main(String [] args) throws IOException {


        String nome_produto = "Super Nintendo";
        String url = "https://www.americanas.com.br/";
        List<Produto> produtoList = new ArrayList<>();

        new WebPageDocument(url.concat("busca"))
                .doSearch(nome_produto)
                .getElementsByClass("Link-sc-1m3ayw0-2")
                .forEach( prod -> {
                    String urlProduto = prod.getElementsByClass("cXaYNF").attr("href");
                    String valoresProduto = new FormataValor( prod.getElementsByClass("doPTSH").text(), "$" ).toString();
                    String nomeDoProduto = prod.getElementsByClass("kTphob").text();
                    String totalCashback = "";
                    try {
                        totalCashback = new WebPageDocument(url.concat(urlProduto))
                                .capture()
                                .getElementsByClass("bvPBbl").text();
                        System.out.println(totalCashback);

                    } catch (IOException e) {
                        //e.printStackTrace();
                    }
                    produtoList.add( new Produto(nomeDoProduto, Double.parseDouble(valoresProduto), totalCashback) );
                    //System.out.println(valoresProduto);
                });


        Produto produtoMaisBarato = produtoList.stream()
                .min( Comparator.comparingDouble(Produto::getValor) )
                .get();

        System.out.println("Produto mais barato : " + produtoMaisBarato.getNome() + " - R$: "+produtoMaisBarato.getValor());
    }

}
