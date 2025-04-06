package com.mycompany.tren.controller;

import com.mycompany.tren.model.*;
import com.mycompany.tren.view.Vista;

/**
 * Clase Controlador
 * Esta clase gestiona la lógica principal del sistema de gestión de un tren de vagones agrícolas.
 * Coordina la interacción entre la vista (interfaz con el usuario) y la lista enlazada de vagones.
 * Permite agregar, insertar, eliminar vagones, así como calcular el valor total de la carga
 * y mostrar un resumen por tipo de cultivo.
 *
 * @author Julian David Celis Giraldo
 * @email jdcelisg@udistrital.edu.co
 * @version 1.0
 * @since 2025-04-05
 */

public class Controlador {
    private Vista vista;
    private ListaEnlazadaSimple<Vagon> tren;

    /**
     * Constructor del controlador.
     *
     * @param vista la interfaz de usuario
     * @param tren la lista enlazada que representa la composición del tren
     */
    public Controlador(Vista vista, ListaEnlazadaSimple<Vagon> tren) {
        this.vista = vista;
        this.tren = tren;
    }
    /**
     * Método principal que ejecuta el flujo de la aplicación.
     * Muestra el menú principal y responde a las opciones seleccionadas por el usuario.
     */
    public void ejecutar() {
        try {
            vista.mostrarBienvenida();
            cargarDatosIniciales();

            int opcion;
            do {
                opcion = vista.mostrarMenuPrincipal();
                switch(opcion) {
                    case 1:
                        agregarVagonFinal();
                        break;
                    case 2:
                        insertarVagonRelativo(false); // Antes de
                        break;
                    case 3:
                        insertarVagonRelativo(true); // Después de
                        break;
                    case 4:
                        eliminarVagon();
                        break;
                    case 5:
                        vista.mostrarComposicionTren(tren);
                        break;
                    case 6:
                        calcularValorTotalCarga();
                        break;
                    case 7:
                        mostrarResumenPorTipoCultivo();
                        break;
                    case 8:
                        vista.mostrarMensaje("Saliendo del sistema...");
                        break;
                    default:
                        vista.mostrarError("Opción no válida");
                }
            } while(opcion != 8);

        } catch (Exception e) {
            vista.mostrarError("Error: " + e.getMessage());
        } finally {
            vista.cerrar();
        }
    }

    /**
     * Carga datos de ejemplo iniciales en el tren.
     */
    private void cargarDatosIniciales() {
        // Datos para Trigo (subclase de Cereal)
        Cultivo miTrigo = new Trigo(
                "LOTE-001",          // codLote
                "Otoño",             // epocaSiembra
                "Verano",            // epocaCosecha
                "sol",               // exposicionSolar
                1.8,                 // valorCompra
                200,                 // cantidad
                "Trilladora",        // maquinaIndustrial
                "Trigo"              // tipoCereal
        );

        // Datos para Hortaliza
        Cultivo hortaliza = new Hortalizas(
                "LOTE-001", "Primavera", "Verano",
                "sol", 2.5, 100, "Diario", 5.0f,
                "Mosca blanca", "Tomate"
        );

        tren.agregarVagon(new Vagon("V001", hortaliza, 150));
        tren.agregarVagon(new Vagon("V002", miTrigo, 250));
    }

    /**
     * Solicita un nuevo vagón y lo agrega al final del tren.
     */
    private void agregarVagonFinal() {
        Vagon vagon = vista.solicitarDatosVagon();
        tren.agregarVagon(vagon);
        vista.mostrarMensaje("Vagón agregado exitosamente al final del tren");
    }

    /**
     * Inserta un vagón antes o después de un vagón existente identificado por su ID.
     *
     * @param insertarDespues true si se inserta después del ID de referencia, false si es antes
     */
    private void insertarVagonRelativo(boolean insertarDespues) {
        try {
            vista.mostrarComposicionTren(tren);
            String idReferencia = vista.solicitarIdVagonReferencia(insertarDespues);
            Vagon nuevoVagon = vista.solicitarDatosVagon();

            boolean exito = tren.insertarVagonRelativo(idReferencia, nuevoVagon, insertarDespues);

            if (exito) {
                vista.mostrarMensaje("Vagón insertado exitosamente " +
                        (insertarDespues ? "después" : "antes") + " del vagón " + idReferencia);
            } else {
                vista.mostrarError("No se encontró el vagón con ID: " + idReferencia);
            }
        } catch (Exception e) {
            vista.mostrarError("Error al insertar vagón: " + e.getMessage());
        }
    }

    /**
     * Elimina un vagón del tren basado en el ID ingresado por el usuario.
     */
    private void eliminarVagon() {
        vista.mostrarComposicionTren(tren);
        String idVagon = vista.solicitarIdVagonEliminar();

        if (tren.eliminarVagon(idVagon)) {
            vista.mostrarMensaje("Vagón " + idVagon + " eliminado exitosamente");
        } else {
            vista.mostrarError("No se encontró el vagón con ID: " + idVagon);
        }
    }

    /**
     * Calcula y muestra el valor total de carga del tren.
     */
    private void calcularValorTotalCarga() {
        double total = tren.calcularValorTotalCarga();
        vista.mostrarValorTotal(total);
    }

    /**
     * Muestra un resumen de la cantidad total de carga por tipo de cultivo.
     */
    private void mostrarResumenPorTipoCultivo() {
        int hortalizas = 0, arboles = 0, cereales = 0, legumbres = 0;

        ListaEnlazadaSimple.IteradorVagones<Vagon> iterador = tren.iterador();
        while (iterador.tieneSiguiente()) {
            Vagon vagon = iterador.siguiente();
            Cultivo cultivo = vagon.getCultivo();

            if (cultivo instanceof Hortalizas) {
                hortalizas += cultivo.getCantidad();
            } else if (cultivo instanceof ArbolFrutal) {
                arboles += cultivo.getCantidad();
            } else if (cultivo instanceof Cereal) {
                cereales += cultivo.getCantidad();
            } else if (cultivo instanceof Legumbres) {
                legumbres += cultivo.getCantidad();
            }
        }

        vista.mostrarResumenCultivos(hortalizas, arboles, cereales, legumbres);
    }
}