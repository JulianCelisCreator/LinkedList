package com.mycompany.tren.model;
/**
 * Representa los cereales
 * Maneja la lógica de Cereales
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
public class Cereal extends CultivoSecano{
    private String tipoCereal;

    public Cereal(String codLote, String epocaSiembra, String epocaCosecha,
                  String exposicionSolar, double valorCompra, int cantidad,
                  String maquinaIndustrial, String tipoCereal) {
        super(codLote, epocaSiembra, epocaCosecha, exposicionSolar, valorCompra, cantidad, maquinaIndustrial);
        this.tipoCereal = tipoCereal;
    }


    @Override
    public String getTipoCereal() {
        return tipoCereal;
    }
}
