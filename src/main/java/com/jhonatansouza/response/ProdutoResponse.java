package com.jhonatansouza.response;

import com.jhonatansouza.interfaces.Product;
import com.jhonatansouza.pojo.Produto;

import java.time.LocalDateTime;
import java.util.Locale;

public class ProdutoResponse {

    private String nome;
    private String valor;
    private String cashback;
    private String dataPesquisa;

    public ProdutoResponse(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getCashback() {
        return cashback;
    }

    public void setCashback(String cashback) {
        this.cashback = cashback;
    }

    public String getDataPesquisa() {
        return dataPesquisa;
    }

    public void setDataPesquisa(String dataPesquisa) {
        this.dataPesquisa = dataPesquisa;
    }

    public static ProdutoResponse fromModel(Product product){
        ProdutoResponse p = new ProdutoResponse();
        p.setNome(product.getNome());
        p.setValor(java.text.NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br")).format(product.getValor()));
        p.setCashback(product.getCashback());
        p.setDataPesquisa(LocalDateTime.now().toString());
        return p;
    }

}
