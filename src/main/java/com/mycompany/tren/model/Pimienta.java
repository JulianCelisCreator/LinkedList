package com.mycompany.tren.model;
/**
 * clase pimienta es un constructor que hereda de hortalizas
 */
public class Pimienta extends Hortalizas {
    /**
     * Constructor de la clase acelgas
     * @param codLote define el codigo del lote del cultivo
     * @param epocaSiembra define la epoca de siembra del cultivo
     * @param epocaCosecha define la epoca de cosecha del cultivo
     * @param exposicionSolar define el tipo de exposición al sol que necesita el cultivo
     * @param valorCompra define el valor de compra del cultivo
     * @param cantidad define la cantidad del cultivo
     * @param frecuenciaRiego define la frecuencia de riego del cultivo
     * @param litrosAgua define la necesidad de agua del cultivo
     * @param plagas define las plagas que presenta el cultivo
     * @param tipoHortaliza define el tipo de hortaliza
     */
    public Pimienta(String codLote, String epocaSiembra,
                    String epocaCosecha, String exposicionSolar,
                    double valorCompra, int cantidad, String frecuenciaRiego,
                    float litrosAgua, String plagas, String tipoHortaliza) {
        super(codLote, epocaSiembra, epocaCosecha, exposicionSolar,
                valorCompra, cantidad, frecuenciaRiego, litrosAgua, plagas, tipoHortaliza);
    }
}
