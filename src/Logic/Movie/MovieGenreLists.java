
package Logic.Movie;

import Logic.*;
import Logic.DoubleLinkedList.LinkedList;
import Logic.DoubleLinkedList.Node;

/**
 *
 * @author User
 */
public class MovieGenreLists {
    public LinkedList horrorMovies;
    public LinkedList actionMovies;
    public LinkedList comedyMovies;
    public LinkedList dramaMovies;
    // Añadir más géneros según sea necesario

    public MovieGenreLists() {
        horrorMovies = new LinkedList();
        actionMovies = new LinkedList();
        comedyMovies = new LinkedList();
        dramaMovies = new LinkedList();
        // Inicializar las listas para otros géneros
    }

    public void addMovieToGenre(String genre, Movie movie) {
        switch (genre.toLowerCase()) {
            case "horror":
                horrorMovies.insert(movie);
                break;
            case "action":
                actionMovies.insert(movie);
                break;
            case "comedy":
                comedyMovies.insert(movie);
                break;
            case "drama":
                dramaMovies.insert(movie);
                break;
            // Añadir casos para otros géneros
            default:
                System.out.println("Genero desconocido: " + genre);
                break;
        }
    }

    public void displayMoviesInGenre(String genre) {
        LinkedList listToDisplay = null;
        switch (genre.toLowerCase()) {
            case "horror":
                listToDisplay = horrorMovies;
                break;
            case "action":
                listToDisplay = actionMovies;
                break;
            case "comedy":
                listToDisplay = comedyMovies;
                break;
            case "drama":
                listToDisplay = dramaMovies;
                break;
            // Añadir casos para otros géneros
            default:
                System.out.println("Genero desconocido: " + genre);
                return;
        }

        if (listToDisplay.isEmpty()) {
            System.out.println("No hay peliculas en el género de " + genre + ".");
            return;
        }

        System.out.println("Peliculas del genero " + genre + ":");
        Node current = listToDisplay.start;
        while (current != null) {
            System.out.println(current.element);
            current = current.next;
        }
    }
    
    public static void main(String[] args) {
        // Crear la instancia de MovieGenreLists
        MovieGenreLists movieLists = new MovieGenreLists();

        // Crear algunas películas usando el constructor correcto
        Movie movie1 = new Movie("El Exorcista", 1973, "William Friedkin");
        Movie movie2 = new Movie("Terminator", 1984, "James Cameron");
        Movie movie3 = new Movie("Superbad", 2007, "Greg Mottola");
        Movie movie4 = new Movie("The Shawshank Redemption", 1994, "Frank Darabont");

        // Añadir películas a las listas correspondientes
        movieLists.addMovieToGenre("horror", movie1);
        movieLists.addMovieToGenre("action", movie2);
        movieLists.addMovieToGenre("comedy", movie3);
        movieLists.addMovieToGenre("drama", movie4);

        // Mostrar las películas de cada género
        movieLists.displayMoviesInGenre("horror");
        movieLists.displayMoviesInGenre("action");
        movieLists.displayMoviesInGenre("comedy");
        movieLists.displayMoviesInGenre("drama");
    }
    
    
    

    
}
