package com.mycompany.tren.model;

/**
 * clase centeno es un constructor que hereda de cereal
 */
public class Centeno extends Cereal {
    /**
     * constructor de la clase centeno
     * @param codLote define el codigo del lote del cultivo
     * @param epocaSiembra define la epoca de siembra del cultivo
     * @param epocaCosecha define la epoca de cosecha del cultivo
     * @param exposicionSolar define el tipo de exposición al sol que necesita el cultivo
     * @param valorCompra define el valor de compra del cultivo
     * @param cantidad define la cantidad del cultivo
     * @param maquinaIndustrial define la maquina que extrae el cultivo
     * @param tipoCereal define el tipo de cereal
     */
    public Centeno(String codLote, String epocaSiembra,
                   String epocaCosecha, String exposicionSolar,
                   double valorCompra, int cantidad, String maquinaIndustrial,
                   String tipoCereal) {
        super(codLote, epocaSiembra, epocaCosecha, exposicionSolar,
                valorCompra, cantidad, maquinaIndustrial, tipoCereal);
    }
}
