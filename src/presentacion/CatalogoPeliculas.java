package presentacion;

import servicio.ServicioPeliculaLista;

import servicio.IServicioPelicula;
import servicio.ServicioPeliculaArchivo;

import java.util.Scanner;

import dominio.Pelicula;

public class CatalogoPeliculas {
    public static void main(String[] args) {
        boolean salir = false;
        Scanner consola = new Scanner(System.in);
        IServicioPelicula serviciopeliculas = new ServicioPeliculaArchivo();

        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, serviciopeliculas);
            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("""
                *** Catalogo de Peliculas
                1. Agregar pelicula
                2. Listar pelicula
                3. Buscar pelicula
                4. Salir
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicioPelicula serviciopeliculas) {
        int opcion = Integer.parseInt(consola.nextLine());
        boolean salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.println("Introduce el nombre de la pelicula: \n");
                String nombrepelicula = consola.nextLine();
                serviciopeliculas.agregarPelicula(new Pelicula(nombrepelicula));
            }
            case 2 -> {
                serviciopeliculas.listarPeliculas();
                System.out.println("\n");
            }
            case 3 -> {
                System.out.println("introduce la pelicula a buscar: \n");
                String buscar = consola.nextLine();
                serviciopeliculas.buscarPelicula(new Pelicula(buscar));
            }
            case 4 -> {
                System.out.println("hasta pronto!");
                salir = true;
            }

            default -> System.out.println("Opcion no reconocida\n");
        }
        return salir;
    }
}