package com.example.maria.entregable2potettimariano;

import java.io.Serializable;
import java.util.Objects;

public class Receta implements Serializable{
    private String titulo;
    private String ingredientes;
    private String preparacion;
    private Integer imageRes;

    public Receta(String titulo, String ingredientes, String preparacion, Integer imageRes) {
        this.titulo = titulo;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.imageRes = imageRes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public Integer getImageRes() {
        return imageRes;
    }

    public void setImageRes(Integer imageRes) {
        this.imageRes = imageRes;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Receta)) {
            return false;
        }
        Receta recetaAComparar = (Receta) o;
        return (this.titulo.equals(recetaAComparar.getTitulo()));
    }


}
