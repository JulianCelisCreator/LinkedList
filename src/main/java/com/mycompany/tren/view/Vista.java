package com.mycompany.tren.view;

import com.mycompany.tren.model.*;
import java.util.Scanner;
/**
 * Clase encargada de interactuar con el usuario en la consola.
 * Se encarga de mostrar menús, solicitar datos y presentar resultados.
 */

public class Vista {
    private Scanner scanner;

    /**
     * Constructor que inicializa el escáner para la entrada de datos.
     */

    public Vista() {
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra el menú principal del sistema y solicita una opción.
     *
     * @return Opción seleccionada por el usuario.
     */
    public int mostrarMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE GESTIÓN DE VAGONES ===");
        System.out.println("1. Agregar vagón al final del tren");
        System.out.println("2. Insertar vagón ANTES de otro");
        System.out.println("3. Insertar vagón DESPUÉS de otro");
        System.out.println("4. Eliminar vagón");
        System.out.println("5. Mostrar composición del tren");
        System.out.println("6. Calcular valor total de la carga");
        System.out.println("7. Mostrar resumen por tipo de cultivo");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");

        while(!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Opción inválida. Seleccione nuevamente: ");
        }
        return scanner.nextInt();
    }
    /**
     * Muestra el mensaje de bienvenida del sistema.
     */
    public void mostrarBienvenida() {
        System.out.println("**************************************");
        System.out.println("*  SISTEMA DE GESTIÓN DE VAGONES     *");
        System.out.println("*      TRANSPORTE DE CULTIVOS        *");
        System.out.println("**************************************");
        System.out.println();
    }

    /**
     * Solicita los datos para crear un nuevo vagón.
     *
     * @return Objeto {@link Vagon} con los datos ingresados por el usuario.
     */
    public Vagon solicitarDatosVagon() {
        scanner.nextLine(); // Limpiar buffer

        System.out.println("\n=== NUEVO VAGÓN ===");
        System.out.print("Identificador del vagón (ej: V001): ");
        String idVagon = scanner.nextLine();

        System.out.print("Capacidad máxima del vagón: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Cultivo cultivo = solicitarDatosCultivo();

        return new Vagon(idVagon, cultivo, capacidad);
    }

    /**
     * Solicita los datos específicos para crear un cultivo.
     *
     * @return Instancia de una subclase de {@link Cultivo}.
     */
    private Cultivo solicitarDatosCultivo() {
        System.out.println("\n=== DATOS DEL CULTIVO ===");
        System.out.println("Tipo de cultivo:");
        System.out.println("1. Hortaliza");
        System.out.println("2. Árbol frutal");
        System.out.println("3. Cereal");
        System.out.println("4. Legumbre");
        System.out.print("Seleccione el tipo: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        System.out.print("\nCódigo de lote (ej: LOTE-001): ");
        String codigoLote = scanner.nextLine();

        System.out.print("Época de siembra: ");
        String epocaSiembra = scanner.nextLine();

        System.out.print("Época de cosecha: ");
        String epocaCosecha = scanner.nextLine();

        System.out.print("Exposición solar (sol/sombra/sol-sombra): ");
        String exposicionSolar = scanner.nextLine();

        System.out.print("Valor por unidad ($): ");
        double valor = scanner.nextDouble();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        switch(tipo) {
            case 1: // Hortaliza
                System.out.print("Frecuencia de riego: ");
                String frecuenciaRiego = scanner.nextLine();

                System.out.print("Necesidades de agua (l/m2): ");
                float necesidadesAgua = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Plagas (separadas por comas): ");
                String plagas = scanner.nextLine();

                System.out.print("Tipo de hortaliza (ej: Tomate): ");
                String tipoHortaliza = scanner.nextLine();

                return new Hortalizas(codigoLote, epocaSiembra, epocaCosecha,
                        exposicionSolar, valor, cantidad,
                        frecuenciaRiego, necesidadesAgua,
                        plagas, tipoHortaliza);

            case 2: // Árbol frutal
                System.out.print("Frecuencia de riego: ");
                String frecuenciaRiegoArbol = scanner.nextLine();

                System.out.print("Necesidades de agua (l/m2): ");
                float necesidadesAguaArbol = scanner.nextFloat();
                scanner.nextLine();

                System.out.print("Plagas (separadas por comas): ");
                String plagasArbol = scanner.nextLine();

                System.out.print("Tipo de árbol (ej: Manzano): ");
                String tipoArbol = scanner.nextLine();

                return new ArbolFrutal(codigoLote, epocaSiembra, epocaCosecha,
                        exposicionSolar, valor, cantidad,
                        frecuenciaRiegoArbol, necesidadesAguaArbol,
                        plagasArbol, tipoArbol);

            case 3: // Cereal
                System.out.print("Maquinaria necesaria: ");
                String maquinariaCereal = scanner.nextLine();

                System.out.print("Tipo de cereal (ej: Trigo): ");
                String tipoCereal = scanner.nextLine();

                return new Cereal(codigoLote, epocaSiembra, epocaCosecha,
                        exposicionSolar, valor, cantidad,
                        maquinariaCereal, tipoCereal);

            case 4: // Legumbre
                System.out.print("Maquinaria necesaria (separada por comas): ");
                String maquinariaLegumbre = scanner.nextLine();

                System.out.print("Tipo de legumbre (ej: Lentejas): ");
                String tipoLegumbre = scanner.nextLine();

                return new Legumbres(codigoLote, epocaSiembra, epocaCosecha,
                        exposicionSolar, valor, cantidad,
                        maquinariaLegumbre, tipoLegumbre);

            default:
                throw new IllegalArgumentException("Tipo de cultivo no válido");
        }
    }

    /**
     * Solicita el identificador de un vagón de referencia para inserciones relativas.
     *
     * @param esDespues true si se insertará después, false si antes.
     * @return ID del vagón de referencia.
     */
    public String solicitarIdVagonReferencia(boolean esDespues) {
        scanner.nextLine(); // Limpiar buffer
        String tipo = esDespues ? "DESPUÉS" : "ANTES";
        System.out.print("\nIngrese el ID del vagón " + tipo + " del cual quiere insertar: ");
        return scanner.nextLine();
    }

    /**
     * Solicita el identificador del vagón a eliminar.
     *
     * @return ID del vagón a eliminar.
     */
    public String solicitarIdVagonEliminar() {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("\nIngrese el ID del vagón a eliminar: ");
        return scanner.nextLine();
    }

    /**
     * Muestra un mensaje informativo al usuario.
     *
     * @param mensaje Texto a mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    /**
     * Muestra un mensaje de error al usuario.
     *
     * @param mensaje Texto del error.
     */
    public void mostrarError(String mensaje) {
        System.err.println("[ERROR] " + mensaje);
    }

    /**
     * Muestra la composición completa del tren.
     *
     * @param tren Lista de vagones.
     */
    public void mostrarComposicionTren(ListaEnlazadaSimple<Vagon> tren) {
        System.out.println("\n=== COMPOSICIÓN DEL TREN ===");
        if (tren.getTamanno() == 0) {
            System.out.println("El tren no tiene vagones.");
            return;
        }

        ListaEnlazadaSimple.IteradorVagones<Vagon> iterador = tren.iterador();
        while (iterador.tieneSiguiente()) {
            Vagon vagon = iterador.siguiente();
            System.out.println(vagon);
        }
        System.out.println("Total vagones: " + tren.getTamanno());
    }

    /**
     * Muestra el valor total acumulado de la carga de los vagones.
     *
     * @param valorTotal Valor total en dólares.
     */
    public void mostrarValorTotal(double valorTotal) {
        System.out.printf("\nValor total de la carga: $%.2f%n", valorTotal);
    }

    /**
     * Muestra un resumen de la cantidad de cultivos por tipo.
     *
     * @param hortalizas Cantidad de hortalizas.
     * @param arboles    Cantidad de árboles frutales.
     * @param cereales   Cantidad de cereales.
     * @param legumbres  Cantidad de legumbres.
     */
    public void mostrarResumenCultivos(int hortalizas, int arboles, int cereales, int legumbres) {
        System.out.println("\n=== RESUMEN DE CULTIVOS ===");
        System.out.println("Hortalizas: " + hortalizas);
        System.out.println("Árboles frutales: " + arboles);
        System.out.println("Cereales: " + cereales);
        System.out.println("Legumbres: " + legumbres);
        System.out.println("TOTAL: " + (hortalizas + arboles + cereales + legumbres));
    }

    /**
     * Cierra el escáner y finaliza la interacción con el usuario.
     */
    public void cerrar() {
        scanner.close();
    }
}