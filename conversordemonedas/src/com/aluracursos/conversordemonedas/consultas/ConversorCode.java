package com.aluracursos.conversordemonedas.consultas;

import java.util.List;

public record ConversorCode(String result, String documentation, String terms_of_use, List<List<String>> supported_codes) {}
