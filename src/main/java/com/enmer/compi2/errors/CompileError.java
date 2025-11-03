package com.enmer.compi2.errors;

public class CompileError {
    private final String fase;
    private final String mensaje;
    private final int linea;
    private final int columna;
    private final String archivo;

    public CompileError(String fase, String mensaje, int linea, int columna, String archivo) {
        this.fase = fase;
        this.mensaje = mensaje;
        this.linea = linea;
        this.columna = columna;
        this.archivo = archivo;
    }

    public String getFase() {
        return fase;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getArchivo() {
        return archivo;
    }

    @Override
    public String toString() {
        String where = (archivo != null && !archivo.isBlank()) ? archivo : "<sin-archivo>";
        return String.format("[%s] (%s:%d:%d) %s", fase, where, linea, columna, mensaje);
    }

}
