package com.aluracursos.conversordemonedas.consultas;

public record Conversor(String result,
                        String base_code,
                        String target_code,
                        double conversion_rate,
                        double conversion_result) {
}
