package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.sound.sampled.BooleanControl;

import dominio.Pelicula;

public class ServicioPeliculaArchivo implements IServicioPelicula {

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculaArchivo() {
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            if (archivo.exists()) {
                System.out.println("El archivo ya existe!\n");
            } else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se creo el archivo correctamente\n");
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error" + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de peliculas\n");
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = entrada.readLine();
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("ocurrio un error al leer el archivo" + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = false;
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula);
            salida.close();
            System.out.println("Se agrego al archivo: " + pelicula + "\n");
        } catch (Exception e) {
            System.out.println("ocurrio un error al agregar una pelicula" + e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        File archivo = new File(NOMBRE_ARCHIVO);
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineatexto = entrada.readLine();
            int indice = 1;
            boolean encontrada = false;
            String peliculabuscar = pelicula.getNombre();
            while (lineatexto != null) {
                if (peliculabuscar != null && peliculabuscar.equalsIgnoreCase(lineatexto)) {
                    encontrada = true;
                    break;
                }
                lineatexto = entrada.readLine();
                indice++;
            }
            if (encontrada) {
                System.out.println("Pelicula " + lineatexto + " encontrada en la linea " + indice + "\n");
            } else
                System.out.println("no se a encontrado la pelicula: " + pelicula.getNombre() + "\n");
            entrada.close();
        } catch (Exception e) {
            System.out.println("ocurrio un error al buscar pelicula " + e.getMessage());
        }

    }

}
