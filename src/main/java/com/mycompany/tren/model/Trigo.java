package com.mycompany.tren.model;
/**
 * Representa el trigo
 * Maneja la lógica del trigo
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
public class Trigo extends Cereal {
    public Trigo(String codLote, String epocaSiembra,
                 String epocaCosecha, String exposicionSolar,
                 double valorCompra, int cantidad
            ,String maquinaIndustrial, String tipoCereal) {
        super(codLote, epocaSiembra, epocaCosecha,
                exposicionSolar, valorCompra, cantidad,
                maquinaIndustrial, tipoCereal);
    }
}