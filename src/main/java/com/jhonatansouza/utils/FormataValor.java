package com.jhonatansouza.utils;

import java.util.Optional;

public class FormataValor {

    private String valor;
    private String delimita;

    public FormataValor(String valor, String delimita){
        this.valor = valor;
        this.delimita = delimita;
    }

    @Override
    public String toString() {
        if(valor.isEmpty() || valor == null)
            return "";
        return Optional.ofNullable(
                this.valor.substring(this.valor.indexOf(delimita) + 1,
                        ( this.valor.indexOf(",") ) ).replaceAll(" ", ""))
                .orElse("0");
    }
}
