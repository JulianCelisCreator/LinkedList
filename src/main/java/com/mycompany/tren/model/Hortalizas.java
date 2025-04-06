package com.mycompany.tren.model;

/**
 * Representa las hortalizas
 * Maneja la lógica de Hortalizas
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
public class Hortalizas extends CultivoRegadio {
    private String tipoHortaliza;
    public Hortalizas(String codLote, String epocaSiembra, String epocaCosecha,
                      String exposicionSolar, double valorCompra, int cantidad,
                      String frecuenciaRiego, float litrosAgua, String plagas, String tipoHortaliza) {
        super(codLote, epocaSiembra, epocaCosecha, exposicionSolar, valorCompra,
                cantidad, frecuenciaRiego, litrosAgua, plagas);
        this.tipoHortaliza = tipoHortaliza;
    }

    @Override
    public String getTipoCultivo() {
        return "Hortaliza (" + tipoHortaliza + ")";
    }

    @Override
    public String getTipoArbol() {
        return "";
    }
}
