package com.mycompany.tren.model;

/**
 * Representa el vagon que compone el tren
 */
public class Vagon {
    private String identificador;
    private Cultivo cultivo;
    private int capacidadMaxima;

    /**
     * Constructor para crear un vagón con sus datos esenciales.
     *
     * @param identificador    Identificador único del vagón.
     * @param cultivo          Cultivo transportado en el vagón.
     * @param capacidadMaxima  Capacidad máxima de carga del vagón.
     */
    public Vagon(String identificador, Cultivo cultivo, int capacidadMaxima) {
        this.identificador = identificador;
        this.cultivo = cultivo;
        this.capacidadMaxima = capacidadMaxima;
    }

    // Getters
    /**
     * Obtiene el identificador del vagón.
     *
     * @return Identificador único.
     */
    public String getIdentificador() { return identificador; }
    /**
     * Obtiene el cultivo que transporta el vagón.
     *
     * @return Cultivo del vagón.
     */

    public Cultivo getCultivo() { return cultivo; }

    /**
     * Obtiene la capacidad máxima de carga del vagón.
     *
     * @return Capacidad máxima en unidades del cultivo.
     */
    public int getCapacidadMaxima() { return capacidadMaxima; }


    /**
     * Retorna una representación en cadena del vagón, incluyendo su cultivo y capacidad.
     *
     * @return Cadena con la información del vagón.
     */
    @Override
    public String toString() {
        return String.format("Vagón %s: %s (Capacidad: %d/%d)",
                identificador, cultivo, cultivo.getCantidad(), capacidadMaxima);
    }
}