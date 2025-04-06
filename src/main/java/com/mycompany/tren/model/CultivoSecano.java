/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tren.model;

/**
 * clase CultivoSecano agrega nuevos atributos e instancia
 * objetos tipo cultivo
 */
public abstract class CultivoSecano extends Cultivo{
    private String maquinaIndustrial;

     /**
     * constructor de la clase CultivoRegadio
     * @param codLote define el codigo del lote del cultivo
     * @param epocaSiembra define la epoca de siembra del cultivo
     * @param epocaCosecha define la epoca de cosecha del cultivo
     * @param exposicionSolar define el tipo de exposición al sol que necesita el cultivo
     * @param valorCompra define el valor de compra del cultivo
     * @param cantidad define la cantidad del cultivo
     * @param maquinaIndustrial define la maquina que extrae el cultivo
     */
    public CultivoSecano(String codLote, String epocaSiembra, String epocaCosecha,
                         String exposicionSolar, double valorCompra,
                         int cantidad, String maquinaIndustrial) {
        super(codLote, epocaSiembra, epocaCosecha, exposicionSolar, valorCompra, cantidad);
        this.maquinaIndustrial = maquinaIndustrial;
    }

    /**
     * Getters y Setters de la clase CultivoSecano
     * @return retorna los atributos de la clase CultivoSecano
     */
    public String getMaquinaIndustrial() {
        return maquinaIndustrial;
    }

    public void setMaquinaIndustrial(String maquinaIndustrial) {
        this.maquinaIndustrial = maquinaIndustrial;
    }

    @Override
    public String getTipoCultivo() {
        return "Cultivo secano  ";
    }

    /**
     * metodo que transforma el objeto a un String
     * @return retorna la información del objeto en tipo String
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("[MaquinaIndustrial: ").append(maquinaIndustrial).append("]");
        return sb.toString();
    }

    public abstract String getTipoCereal();
}
