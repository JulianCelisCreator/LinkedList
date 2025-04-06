package com.mycompany.tren.model;
/**
 * Representa los tomates
 * Maneja la lógica de Tomate
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
public class Tomate extends Hortalizas {
    public Tomate(String codLote, String epocaSiembra, String epocaCosecha,
                  String exposicionSolar, double valorCompra, int cantidad,
                  String frecuenciaRiego, float litrosAgua, String plagas,
                  String tipoHortaliza) {
        super(codLote, epocaSiembra, epocaCosecha, exposicionSolar,
                valorCompra, cantidad, frecuenciaRiego, litrosAgua, plagas, tipoHortaliza);
    }
}
