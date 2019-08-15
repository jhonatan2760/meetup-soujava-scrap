package com.jhonatansouza.model;

public class Produto {

    private String nome;
    private Double valor;
    private String cashback;
    private String url;

    public Produto(String nome, Double valor, String cashback) {
        this.nome = nome;
        this.valor = valor;
        this.cashback = cashback;
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCashback() {
        return cashback;
    }

    public void setCashback(String cashback) {
        this.cashback = cashback;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
