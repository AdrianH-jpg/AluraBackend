package com.aluracursos.screeanmatch.excepcion;

public class ErrorEnConversionDeDuracionException extends RuntimeException {
    private  String mensaje;
    public ErrorEnConversionDeDuracionException(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return this.mensaje;
    }
}
