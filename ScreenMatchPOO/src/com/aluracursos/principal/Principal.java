package com.aluracursos.principal;

import com.aluracursos.screeanmatch.modelos.Pelicula;
import com.aluracursos.screeanmatch.modelos.Serie;
import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendacion;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);
        miPelicula.mostrarFichaTecnica();

        Serie miSerie = new Serie("La casa del dragón",2022);
        miSerie.setTemporadas(1);
        miSerie.setMinutosPorEpisodio(50);
        miSerie.setEpisodiosPorTemporada(10);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(miSerie);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtro = new FiltroRecomendacion();
        filtro.filtra(miPelicula);




    }
}
