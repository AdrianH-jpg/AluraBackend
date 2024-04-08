package com.aluracursos.conversordemonedas.principal;

import com.aluracursos.conversordemonedas.consultas.ConsultaAPI;
import com.aluracursos.conversordemonedas.consultas.Conversor;
import com.aluracursos.conversordemonedas.modelos.MostrarMonedas;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        ConsultaAPI consulta = new ConsultaAPI();
        MostrarMonedas m = new MostrarMonedas();
        var entrada = 0;
        while (entrada != 3){
            var base = "";
            var target ="";
            double amount = 0.0f;
            System.out.println("\n***************************************");
            System.out.println("Desea realizar una conversion?");
            System.out.println("1 - Si");
            System.out.println("2 - Ver simbolos de moneda");
            System.out.println("3 - Salir");
            entrada = lectura.nextInt();
            if(entrada == 3)
            {
                break;
            } else if (entrada == 2) {
                m.mostrarListaMonedas(consulta);
            }else{
                m.mostrarListaMonedas(consulta);
                System.out.println("\n***************************************");
                System.out.println("Seleccione alguno de los anteriores tipos de moneda que desea cambiar Ejemp: 'USD' para dolar:");
                base = lectura.next().toUpperCase();
                m.mostrarListaMonedas(consulta);
                System.out.println("Seleccione la moneda objetivo Ejemp: 'ARS' para Peso Argentino:");
                target = lectura.next();
                System.out.println("Ingrese el monto a cambiar:");
                amount = lectura.nextDouble();
                System.out.println("\n***************************************");

                Conversor conversor = consulta.convertirMoneda(target, base, amount);
                System.out.println("El valor de: " + amount + conversor.base_code() + " es de " + conversor.conversion_result() + conversor.target_code());

            }
        }

    }
}
