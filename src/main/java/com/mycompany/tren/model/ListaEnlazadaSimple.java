package com.mycompany.tren.model;

/**
 * Representa una lista enlazada simple especializada para manejar vagones de tren.
 * Soporta operaciones de inserción, eliminación, búsqueda e iteración.
 *
 * @param <T> Tipo de elementos que contendrá la lista, normalmente {@link Vagon}.
 */
public class ListaEnlazadaSimple<T> {
    private Nodo<T> cabeza;
    private int tamanno;

    /**
     * Constructor que inicializa una lista vacía.
     */
    public ListaEnlazadaSimple() {
        cabeza = null;
        tamanno = 0;
    }

    // ---------------------- Operaciones Básicas ----------------------

    /**
     * Agrega un nuevo vagón al final del tren.
     *
     * @param vagon Vagón a agregar.
     */
    public void agregarVagon(T vagon) {
        Nodo<T> nuevoNodo = new Nodo<>(vagon);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo<T> actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
        tamanno++;
    }

    /**
     * Elimina un vagón del tren por su identificador
     * @param idVagon Identificador del vagón a eliminar
     * @return true si se eliminó, false si no se encontró
     */
    public boolean eliminarVagon(String idVagon) {
        if (cabeza == null) return false;

        // Caso especial: eliminar la cabeza
        if (obtenerIdentificador(cabeza.getDato()).equals(idVagon)) {
            cabeza = cabeza.getSiguiente();
            tamanno--;
            return true;
        }

        // Buscar en el resto de la lista
        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (obtenerIdentificador(actual.getSiguiente().getDato()).equals(idVagon)) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                tamanno--;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Método auxiliar para obtener el identificador de diferentes tipos de vagones
    private String obtenerIdentificador(T vagon) {
        if (vagon instanceof Cultivo) {
            return ((Cultivo) vagon).getCodLote();
        } else if (vagon instanceof Vagon) {
            return ((Vagon) vagon).getIdentificador();
        }
        throw new IllegalArgumentException("Tipo de vagón no soportado");
    }

    // ---------------------- Búsqueda ----------------------

    /**
     * Verifica si existe un vagón con el identificador especificado
     * @param idVagon Identificador a buscar
     * @return true si existe, false si no
     */
    public boolean contieneVagon(String idVagon) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (obtenerIdentificador(actual.getDato()).equals(idVagon)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // ---------------------- Utilidades ----------------------

    /**
     * @return Número de vagones en el tren
     */
    public int getTamanno() {
        return tamanno;
    }

    /**
     * Imprime todos los vagones del tren
     */
    public void imprimirVagones() {
        Nodo<T> actual = cabeza;
        System.out.println("\n=== COMPOSICIÓN DEL TREN ===");
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
        System.out.println("Total vagones: " + tamanno);
    }

    // ---------------------- Operaciones Específicas ----------------------

    /**
     * Inserta un nuevo vagón antes o después de uno existente
     * @param idReferencia Identificador del vagón de referencia
     * @param nuevoVagon Nuevo vagón a insertar
     * @param insertarDespues true para insertar después, false para antes
     * @return true si se insertó, false si no se encontró la referencia
     */
    public boolean insertarVagonRelativo(String idReferencia, T nuevoVagon, boolean insertarDespues) {
        if (cabeza == null) return false;

        // Caso especial: insertar antes de la cabeza
        if (obtenerIdentificador(cabeza.getDato()).equals(idReferencia)) {
            if (!insertarDespues) {
                Nodo<T> nuevoNodo = new Nodo<>(nuevoVagon, cabeza);
                cabeza = nuevoNodo;
                tamanno++;
                return true;
            }
        }

        Nodo<T> actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (obtenerIdentificador(actual.getSiguiente().getDato()).equals(idReferencia)) {
                Nodo<T> nuevoNodo = new Nodo<>(nuevoVagon);
                if (insertarDespues) {
                    nuevoNodo.setSiguiente(actual.getSiguiente().getSiguiente());
                    actual.getSiguiente().setSiguiente(nuevoNodo);
                } else {
                    nuevoNodo.setSiguiente(actual.getSiguiente());
                    actual.setSiguiente(nuevoNodo);
                }
                tamanno++;
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Agrega un vagón al inicio del tren
     * @param nuevoVagon Vagón a agregar
     */
    public void agregarVagonAlInicio(T nuevoVagon) {
        Nodo<T> nuevaCabeza = new Nodo<>(nuevoVagon, cabeza);
        cabeza = nuevaCabeza;
        tamanno++;
    }

    /**
     * Calcula el valor total de la carga en todos los vagones
     * @return Valor total de la carga
     */
    public double calcularValorTotalCarga() {
        double total = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato() instanceof Vagon) {
                total += ((Vagon) actual.getDato()).getCultivo().getValorTotal();
            }
            actual = actual.getSiguiente();
        }
        return total;
    }

    // ---------------------- Iterador ----------------------

    /**
     * @return Iterador para recorrer los vagones
     */
    public IteradorVagones<T> iterador() {
        return new IteradorVagones<>(cabeza);
    }

    /**
     * Clase interna para iterar sobre los vagones
     */
    public static class IteradorVagones<T> {
        private Nodo<T> actual;

        public IteradorVagones(Nodo<T> cabeza) {
            this.actual = cabeza;
        }

        /**
         * @return true si hay más vagones por recorrer
         */
        public boolean tieneSiguiente() {
            return actual != null;
        }

        /**
         * @return Siguiente vagón en la lista
         * @throws IllegalStateException si no hay más vagones
         */
        public T siguiente() {
            if (!tieneSiguiente()) {
                throw new IllegalStateException("No hay más vagones");
            }
            T vagon = actual.getDato();
            actual = actual.getSiguiente();
            return vagon;
        }
    }
}