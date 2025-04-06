package com.mycompany.tren.model;
/**
 * Representa la clase concreta ArbolFrutal
 * Maneja la lógica de ArbolFrutal
 *
 * @author Julian David Celis Giraldo
 * @email jdcelisg@udistrital.edu.co
 *
 * @author Juan Esteban Jurado Martinez
 * @email jejuradom@udistrital.edu.co
 *
 * @version 1.0
 * @since 2025-04-05
 */
public class ArbolFrutal extends CultivoRegadio {
    private String tipoArbol;
    public ArbolFrutal(String codLote, String epocaSiembra,
                       String epocaCosecha, String exposicionSolar,
                       double valorCompra, int cantidad, String frecuenciaRiego,
                       float litrosAgua, String plagas, String tipoArbol) {
        super(codLote, epocaSiembra, epocaCosecha,
                exposicionSolar, valorCompra, cantidad,
                frecuenciaRiego, litrosAgua, plagas);
        this.tipoArbol = tipoArbol;
    }

    @Override
    public String getTipoArbol() {
        return "Arbol Frutal (" + tipoArbol + ")";
    }
}
