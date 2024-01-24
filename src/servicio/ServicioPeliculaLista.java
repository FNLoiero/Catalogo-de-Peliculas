package servicio;

import java.util.ArrayList;
import java.util.List;

import dominio.Pelicula;

public class ServicioPeliculaLista implements IServicioPelicula {

    private final List<Pelicula> peliculas;

    public ServicioPeliculaLista() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de Peliculas\n");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("se agrego la pelicula: " + pelicula + "\n");
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        int indice = peliculas.indexOf(pelicula);
        if (indice < 0) {
            System.out.println("No se encontro la pelicula\n");
            return;
        }
        System.out.println("Pelicula encontrada en el indice: " + indice + "\n");
    }

}
