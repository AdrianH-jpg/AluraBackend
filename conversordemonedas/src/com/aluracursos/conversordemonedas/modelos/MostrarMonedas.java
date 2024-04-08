package com.aluracursos.conversordemonedas.modelos;

import com.aluracursos.conversordemonedas.consultas.ConsultaAPI;

import java.util.List;

public class MostrarMonedas {

    public void  mostrarListaMonedas(ConsultaAPI consulta){

        System.out.println("Supported Codes:");
        var count = 0;
        for (List<String> currencyData : consulta.codigosDeConvecion().supported_codes()) {
            count++;
            if (count > 3) {
                count = 0;
                if (currencyData.get(1).length() >= 10) {
                    System.out.println(currencyData.get(0) + ": " + currencyData.get(1).substring(0, 10));
                } else {
                    System.out.println(currencyData.get(0) + ": " + currencyData.get(1));
                }
            }else {
                if (currencyData.get(1).length() >= 10) {
                    System.out.print(currencyData.get(0) + ": " + currencyData.get(1).substring(0, 10) + " | ");
                } else {
                    System.out.print(currencyData.get(0) + ": " + currencyData.get(1) + " | ");
                }
            }
        }
    }
}
