package toreno.Main;


import java.util.ArrayList;
import java.util.Scanner;

import toreno.Model.Data;
import toreno.Model.Jugador;
import toreno.Model.Marcador;
import toreno.Model.Nif;
import toreno.Model.Partit;
import toreno.Model.Torneig;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Jugador> jugadores = new ArrayList<>();
    private static final ArrayList<Partit> partidos = new ArrayList<>();
    private static Torneig torneig;

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Opció: ");
            opcion = leerEntero();

            switch (opcion) {
                case 1 -> anadirJugador();
                case 2 -> anadirPartido();
                case 3 -> crearTorneo();
                case 4 -> mostrarJugadores();
                case 5 -> mostrarPartidos();
                case 6 -> mostrarTorneo();
                case 99 -> System.out.println("Sortint del programa...");
                default -> System.out.println("Opció incorrecta. Torna-ho a intentar.");
            }

        } while (opcion != 99);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== GESTIÓ DE TORNEIGS =====");
        System.out.println("1. Afegir jugador");
        System.out.println("2. Afegir partit");
        System.out.println("3. Crear torneig");
        System.out.println("4. Mostrar jugadors");
        System.out.println("5. Mostrar partits");
        System.out.println("6. Mostrar torneig");
        System.out.println("99. Sortir");
    }

    private static void anadirJugador() {
        try {
            System.out.print("DNI (8 dígits): ");
            int dni = leerEnteroConEjemplo("DNI no válido. Ejemplo: 12345678", 10000000, 99999999);

            System.out.print("Lletra DNI: ");
            String lletra = scanner.nextLine().trim();
            if (lletra.isEmpty() || lletra.length() != 1 || !lletra.matches("[A-Za-z]")) {
                System.out.println("Letra del DNI no válida. Ejemplo: A");
                return;
            }

            System.out.print("Nom: ");
            String nom = scanner.nextLine().trim();
            if (nom.isEmpty()) {
                System.out.println("Nombre no puede estar vacío.");
                return;
            }

            System.out.print("Dia naixement: ");
            int dia = leerEnteroConEjemplo("Día no válido. Ejemplo: 15", 1, 31);

            System.out.print("Mes naixement: ");
            int mes = leerEnteroConEjemplo("Mes no válido. Ejemplo: 7", 1, 12);

            System.out.print("Any naixement: ");
            int any = leerEnteroConEjemplo("Año no válido. Ejemplo: 2023", 1, 9999);

            System.out.print("Número llicència: ");
            int numLlicencia = leerEnteroConEjemplo("Número de licencia no válido. Ejemplo: 1001", 1, Integer.MAX_VALUE);

            Nif nif = new Nif(dni, lletra);
            Data dataNaixement = new Data(dia, mes, any);
            Jugador jugador = new Jugador(nif, nom, dataNaixement, numLlicencia);

            jugadores.add(jugador);
            System.out.println("Jugador afegit correctament: " + jugador);

        } catch (Exception e) {
            System.out.println("Error en afegir jugador: " + e.getMessage());
        }
    }

    private static void anadirPartido() {
        if (jugadores.size() < 2) {
            System.out.println("Cal tenir almenys dos jugadors per crear un partit.");
            return;
        }

        mostrarJugadores();

        System.out.print("Selecciona índex del jugador 1: ");
        int idx1 = leerEnteroConEjemplo("Índex no vàlid. Exemple: 1", 1, jugadores.size()) - 1;

        System.out.print("Selecciona índex del jugador 2: ");
        int idx2 = leerEnteroConEjemplo("Índex no vàlid. Exemple: 2", 1, jugadores.size()) - 1;

        if (idx1 == idx2) {
            System.out.println("No pots seleccionar el mateix jugador dues vegades.");
            return;
        }

        System.out.print("Punts jugador 1 (0-21): ");
        int punts1 = leerEnteroConEjemplo("Punts no vàlids. Introduïu un número entre 0 i 21. Exemple: 18", 0, 21);

        System.out.print("Punts jugador 2 (0-21): ");
        int punts2 = leerEnteroConEjemplo("Punts no vàlids. Introduïu un número entre 0 i 21. Exemple: 15", 0, 21);

        Jugador j1 = jugadores.get(idx1);
        Jugador j2 = jugadores.get(idx2);

        Jugador guanyador = punts1 > punts2 ? j1 : j2;

        try {
            Marcador marcador = new Marcador(punts1, punts2);
            Partit partit = new Partit(j1, j2, guanyador, marcador);
            partidos.add(partit);
            System.out.println("Partit afegit correctament: " + partit);
        } catch (Exception e) {
            System.out.println("Error en afegir partit: " + e.getMessage());
        }
    }

    private static void crearTorneo() {
        if (partidos.isEmpty()) {
            System.out.println("No hi ha partits per crear un torneig.");
            return;
        }

        try {
            System.out.print("Dia torneig: ");
            int dia = leerEnteroConEjemplo("Día no válido. Ejemplo: 15", 1, 31);

            System.out.print("Mes torneig: ");
            int mes = leerEnteroConEjemplo("Mes no válido. Ejemplo: 7", 1, 12);

            System.out.print("Any torneig: ");
            int any = leerEnteroConEjemplo("Año no válido. Ejemplo: 2023", 1, 9999);

            Data dataTorneig = new Data(dia, mes, any);
            Partit[] arrayPartits = partidos.toArray(new Partit[0]);
            Jugador guanyadorTorneig = calcularGuanyadorTorneig(arrayPartits);

            torneig = new Torneig(dataTorneig, arrayPartits.length, arrayPartits, guanyadorTorneig);

            System.out.println("Torneig creat correctament.");
        } catch (Exception e) {
            System.out.println("Error en crear torneig: " + e.getMessage());
        }
    }

    private static Jugador calcularGuanyadorTorneig(Partit[] arrayPartits) {
        var comptador = new java.util.HashMap<Jugador, Integer>();

        for (Partit p : arrayPartits) {
            comptador.put(p.getGuanyador(), comptador.getOrDefault(p.getGuanyador(), 0) + 1);
        }

        Jugador guanyador = null;
        int maxVictories = 0;
        for (var entry : comptador.entrySet()) {
            if (entry.getValue() > maxVictories) {
                maxVictories = entry.getValue();
                guanyador = entry.getKey();
            }
        }
        return guanyador;
    }

    private static void mostrarJugadores() {
        if (jugadores.isEmpty()) {
            System.out.println("No hi ha jugadors.");
            return;
        }

        System.out.println("\n--- Llista de jugadors ---");
        for (int i = 0; i < jugadores.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, jugadores.get(i));
        }
    }

    private static void mostrarPartidos() {
        if (partidos.isEmpty()) {
            System.out.println("No hi ha partits.");
            return;
        }

        System.out.println("\n--- Llista de partits ---");
        for (int i = 0; i < partidos.size(); i++) {
            System.out.printf("%d) %s\n", i + 1, partidos.get(i));
        }
    }

    private static void mostrarTorneo() {
        if (torneig == null) {
            System.out.println("No hi ha torneig creat.");
            return;
        }

        System.out.println("\n--- Informació del torneig ---");
        System.out.println(torneig);
    }

    // Lectura segura de entero
    private static int leerEntero() {
        while (true) {
            try {
                String linea = scanner.nextLine().trim();
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.print("Entrada no vàlida. Torna-ho a intentar: ");
            }
        }
    }

    // Lectura segura de entero con rango y mensaje de ejemplo
    private static int leerEnteroConEjemplo(String mensajeError, int min, int max) {
        while (true) {
            try {
                String linea = scanner.nextLine().trim();
                int valor = Integer.parseInt(linea);
                if (valor < min || valor > max) {
                    System.out.println(mensajeError);
                    System.out.print("Torna-ho a intentar: ");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println(mensajeError);
                System.out.print("Torna-ho a intentar: ");
            }
        }
    }
}
