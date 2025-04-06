/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tren.model;

/**
 * clase cultivo crea la estructura de los objetos tipo cultivo
 *
 */
public abstract class Cultivo {
    private String codLote;
    private String epocaSiembra;
    private String epocaCosecha;
    private String exposicionSolar;
    private double valorCompra;
    private int cantidad;

    /**
     * constructor de la clase cultivo
     * @param codLote define el codigo del lote del cultivo
     * @param epocaSiembra define la epoca de siembra del cultivo
     * @param epocaCosecha define la epoca de cosecha del cultivo
     * @param exposicionSolar define el tipo de exposición al sol que necesita el cultivo
     * @param valorCompra define el valor de compra del cultivo
     * @param cantidad define la cantidad del cultivo
     */
    public Cultivo(String codLote, String epocaSiembra, String epocaCosecha, String exposicionSolar, double valorCompra, int cantidad) {
        this.codLote = codLote;
        this.epocaSiembra = epocaSiembra;
        this.epocaCosecha = epocaCosecha;
        this.exposicionSolar = exposicionSolar; //sol, sol/sombra, sombra
        this.valorCompra = valorCompra;
        this.cantidad = cantidad;
    }

    /**
     * Get del tipo de cultivo
     * @return retorna el tipo de cultivo
     */
    public abstract String getTipoCultivo();

    //Getters and setters

    /**
     * Getters y setters de la clase cultivo
     * @return retorna los atributos de tipo cultivo
     */
    public String getEpocaSiembra() {
        return epocaSiembra;
    }

    public void setEpocaSiembra(String epocaSiembra) {
        this.epocaSiembra = epocaSiembra;
    }

    public String getEpocaCosecha() {
        return epocaCosecha;
    }

    public void setEpocaCosecha(String epocaCosecha) {
        this.epocaCosecha = epocaCosecha;
    }

    public String getCodLote() {
        return codLote;
    }

    public void setCodLote(String codLote) {
        this.codLote = codLote;
    }

    public String getExposicionSolar() {
        return exposicionSolar;
    }

    public void setExposicionSolar(String exposicionSolar) {
        this.exposicionSolar = exposicionSolar;
    }

    public double getValorTotal() {
        return valorCompra * cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }

    /**
     * metodo que transforma el objeto a un String
     * @return retorna la información del objeto en tipo String
     */
    @Override
    public String toString() {
        return String.format("%s [Lote: %s, Siembra: %s, Cosecha: %s, Sol: %s, Cant: %d, Valor: $%.2f]",
                getTipoCultivo(), codLote, epocaSiembra, epocaCosecha,
                exposicionSolar, cantidad, getValorTotal());
        }
    }
    
    
    
   

