package com.mycompany.tren.model;
/**
 * Representa las vainas
 * Maneja la lógica de las vainas
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
public class Vainas extends Hortalizas {
    public Vainas(String codLote, String epocaSiembra, String epocaCosecha,
                  String exposicionSolar, double valorCompra, int cantidad,
                  String frecuenciaRiego, float litrosAgua, String plagas,
                  String tipoHortaliza) {
        super(codLote, epocaSiembra, epocaCosecha, exposicionSolar,
                valorCompra, cantidad, frecuenciaRiego, litrosAgua, plagas, tipoHortaliza);
    }
}
