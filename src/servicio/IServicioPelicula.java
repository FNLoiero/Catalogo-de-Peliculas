package servicio;

import dominio.Pelicula;

public interface IServicioPelicula {

    public void listarPeliculas();

    public void agregarPelicula(Pelicula pelicula);

    public void buscarPelicula(Pelicula pelicula);
}
