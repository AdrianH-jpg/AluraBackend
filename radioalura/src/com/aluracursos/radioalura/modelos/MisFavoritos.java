package com.aluracursos.radioalura.modelos;

public class MisFavoritos {

    public void adicione(Audio audio){
        if (audio.getCasificacion() >= 8){
            System.out.println(audio.getTitulo() + " Es uno de los favoritos");
        }else {
            System.out.println(audio.getTitulo() + " Terrible para tus oidos");
        }
    }
}
