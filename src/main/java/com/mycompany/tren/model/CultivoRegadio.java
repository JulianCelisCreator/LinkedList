package com.mycompany.tren.model;

/**
 * clase CultivoRegadio agrega nuevos atributos e instancia
 * objetos tipo cultivo
 */
public abstract class CultivoRegadio extends Cultivo {
    private String frecuenciaRiego;
    private float necesidadesAgua;
    private String plagas;

    /**
     * constructor de la clase CultivoRegadio
     * @param codLote define el codigo del lote del cultivo
     * @param epocaSiembra define la epoca de siembra del cultivo
     * @param epocaCosecha define la epoca de cosecha del cultivo
     * @param exposicionSolar define el tipo de exposición al sol que necesita el cultivo
     * @param valorCompra define el valor de compra del cultivo
     * @param cantidad define la cantidad del cultivo
     * @param frecuenciaRiego define la frecuencia de riego del cultivo
     * @param necesidadesAgua define la necesidad de agua del cultivo
     * @param plagas define las plagas que presenta el cultivo
     */
    public CultivoRegadio(String codLote, String epocaSiembra, String epocaCosecha, String exposicionSolar, double valorCompra, int cantidad, String frecuenciaRiego, float necesidadesAgua, String plagas) {
        super(codLote, epocaSiembra, epocaCosecha, exposicionSolar, valorCompra, cantidad);
        this.frecuenciaRiego = frecuenciaRiego;
        this.necesidadesAgua = necesidadesAgua;
        this.plagas = plagas;
    }

    /**
     * Getters y Setters de clase CultivoRegadio
     * @return retorna los atributos de la clase CultivoRegadio
     */
    @Override
    public String getTipoCultivo() {
        return "Cultivo de riego";
    }

    public String getFrecuenciaRiego() {
        return frecuenciaRiego;
    }

    public void setFrecuenciaRiego(String frecuenciaRiego) {
        this.frecuenciaRiego = frecuenciaRiego;
    }

    public float getNecesidadesAgua() {
        return necesidadesAgua;
    }

    public void setNecesidadesAgua(float necesidadesAgua) {
        this.necesidadesAgua = necesidadesAgua;
    }

    public String getPlagas() {
        return plagas;
    }

    public void setPlagas(String plagas) {
        this.plagas = plagas;
    }

    /**
     * metodo que transforma el objeto a un String
     * @return retorna la información del objeto en tipo String
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" [Riego: %s, Agua: %.2f l/m2]",
                frecuenciaRiego, necesidadesAgua);
    }

    public abstract String getTipoArbol();
}
