package com.orafaaraujo.rxrecyclerexample.presentation.main.model;

import java.io.Serializable;

public class SinopseModel implements Serializable
{
    private String Titulo;

    private String Ano;

    private String Genero;

    private String Texto;

    public SinopseModel()
    {

    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        Titulo = Titulo;
    }

    public String getAno() {
        return Ano;
    }

    public void setAno(String Ano) {
        Ano = Ano;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        Genero = Genero;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        Texto = Texto;
    }

    @Override
    public String toString() {
        return "Título: " + getTitulo()
                + "\nAno: " + getAno()
                + "\nGenêro: " + getGenero()
                + "\nTexto: " + getTexto();
    }
}
