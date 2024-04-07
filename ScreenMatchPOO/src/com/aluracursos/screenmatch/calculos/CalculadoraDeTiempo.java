package com.aluracursos.screenmatch.calculos;

import com.aluracursos.screeanmatch.modelos.Titulo;

public class CalculadoraDeTiempo {
    private  int tiempoTotal;

    public void incluye(Titulo titulo){
        System.out.println("Agregando duracion en minutos de " + titulo);
        tiempoTotal += titulo.getDuracionEnMinutos();
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }
}
