/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tren.model;

/**
 * Clase Nodo crea un nuevo nodo a la lista
 *
 */
public class Nodo<T> {
    private T dato;
    private Nodo<T> siguiente;

    /**
     * Constructor de la clase Nodo
     * @param dato crea un nuevo nodo sin puntero
     */
    public Nodo(T dato) {
        this(dato, null);
    }

    /**
     * Constructor de la clase Nodo con sobreescritura
     * @param dato Sobreescribe el dato del anterior constructor
     * @param siguiente hace que el nodo apunte al siguiente nodo de la lista
     */
    public Nodo(T dato, Nodo<T> siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    /**
     * Getters y Setters de la clase Nodo
     * @return permite hacer retorno de los datos y las posiciones
     * de los siguientes nodos
     */
    public T getDato() {
        return dato;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * metodo que transforma el objeto tipo T dato a String
     * @return permite retornar la informacion del nodo en texto tipo String
     */
    @Override
    public String toString() {
        return dato.toString();
    }
}