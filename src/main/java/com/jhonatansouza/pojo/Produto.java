package com.jhonatansouza.pojo;

import com.jhonatansouza.interfaces.Product;

public class Produto implements Product {

    private String nome;
    private Double valor;
    private String cashback;
    private String url;
    private String img;

    public Produto(String nome, Double valor, String cashback, String url, String img) {
        this.nome = nome;
        this.valor = valor;
        this.cashback = cashback;
        this.url = url;
        this.img = img;
    }

    public Produto() {
    }



    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String getCashback() {
        return cashback;
    }

    public void setCashback(String cashback) {
        this.cashback = cashback;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getImg() {
        return img;
    }

    @Override
    public void setTotalCashback(String cashback) {
        this.cashback = cashback;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
