package com.aluracursos.principal;

import com.aluracursos.screeanmatch.modelos.Pelicula;
import com.aluracursos.screeanmatch.modelos.Serie;
import com.aluracursos.screeanmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.List;

public class PrincipaConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto",2021);
        miPelicula.evalua(9);
        Serie miSerie = new Serie("La casa del dragón",2022);
        miSerie.evalua(6);
        List<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(miSerie);

        for(Titulo item: lista){
            System.out.println(item.getNombre());
            if(item instanceof Pelicula pelicula){
                System.out.println(pelicula.getClasificacion());
            }

        }

    }
}
