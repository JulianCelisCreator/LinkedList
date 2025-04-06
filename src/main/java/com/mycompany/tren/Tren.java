/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.tren;

import com.mycompany.tren.controller.*;
import com.mycompany.tren.model.*;
import com.mycompany.tren.view.Vista;
/**
 * Clase principal del sistema Tren.
 *
 * Esta clase contiene el método main que inicia la aplicación.
 * Se encarga de crear las instancias necesarias de Vista, la lista de vagones,
 * y el Controlador que gestiona toda la lógica del programa.
 *
 * @author Julian David Celis Giraldo
 * @email<jdcelisg@udistrital.edu.co>
 * @version 1.0
 * @since 2025-04-05
 */
public class Tren {
        /**
         * Método principal que lanza la ejecución del programa.
         *
         * @param args argumentos de línea de comandos (no se usan en esta aplicación)
         */
        public static void main(String[] args) {
            Vista vista = new Vista();
            ListaEnlazadaSimple<Vagon> lista = new ListaEnlazadaSimple<>();
            Controlador controlador = new Controlador(vista, lista);
            controlador.ejecutar();
        }
    }