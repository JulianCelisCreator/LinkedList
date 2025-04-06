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
public class Legumbres extends CultivoSecano{
    String tipoLegumbre;

    /**
     *
     * @param codLote valor identificaodr
     * @param epocaSiembra temporada de siembra
     * @param epocaCosecha temporada de cosecha
     * @param exposicionSolar requerida para el crecimiento
     * @param valorCompra costo economico
     * @param cantidad cantidad
     * @param maquinaIndustrial Utilizada para su explotación
     * @param tipoLegumbre Clasificación del tipo
     */
    public Legumbres(String codLote, String epocaSiembra, String epocaCosecha,
                     String exposicionSolar, double valorCompra, int cantidad,
                     String maquinaIndustrial, String tipoLegumbre) {
        super(codLote, epocaSiembra, epocaCosecha, exposicionSolar, valorCompra, cantidad, maquinaIndustrial);
        this.tipoLegumbre = tipoLegumbre;
    }

    /**
     *
     * @return legumbre
     */
    @Override
    public String getTipoCultivo() {
        return "Legumbre (" + tipoLegumbre + ")";
    }

    @Override
    public String getTipoCereal() {
        return "";
    }
}
