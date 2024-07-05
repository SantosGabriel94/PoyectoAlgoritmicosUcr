
package Logic.Movie;

import Logic.*;
import Logic.DoubleLinkedList.LinkedList;
import Logic.DoubleLinkedList.Node;

/**
 *
 * @author User
 */
public class MovieGenreLists {
    public LinkedList cienciaFiccionMovies;
    public LinkedList disparosMovies;
    public LinkedList documentalesMovies;
    public LinkedList terrorMovies;
    // Añadir más géneros según sea necesario

    public MovieGenreLists() {
        cienciaFiccionMovies = new LinkedList();
        disparosMovies = new LinkedList();
        documentalesMovies = new LinkedList();
        terrorMovies = new LinkedList();
        // Inicializar las listas para otros géneros

        initializeMovies(); // Llamada al método para inicializar las películas
    }

    public void initializeMovies() {
        // Ciencia Ficción
        addMovieToGenre("cienciaficcion", new Movie("Interstellar", 2014, "Christopher Nolan"));
        addMovieToGenre("cienciaficcion", new Movie("The Matrix", 1999, "Lana Wachowski, Lilly Wachowski"));
        addMovieToGenre("cienciaficcion", new Movie("Inception", 2010, "Christopher Nolan"));
        addMovieToGenre("cienciaficcion", new Movie("Blade Runner 2049", 2017, "Denis Villeneuve"));
        addMovieToGenre("cienciaficcion", new Movie("Avatar", 2009, "James Cameron"));
        addMovieToGenre("cienciaficcion", new Movie("Star Wars: Episode IV", 1977, "George Lucas"));
        addMovieToGenre("cienciaficcion", new Movie("The Terminator", 1984, "James Cameron"));

        // Disparos
        addMovieToGenre("disparos", new Movie("John Wick", 2014, "Chad Stahelski"));
        addMovieToGenre("disparos", new Movie("Die Hard", 1988, "John McTiernan"));
        addMovieToGenre("disparos", new Movie("Mad Max: Fury Road", 2015, "George Miller"));
        addMovieToGenre("disparos", new Movie("The Dark Knight", 2008, "Christopher Nolan"));
        addMovieToGenre("disparos", new Movie("Gladiator", 2000, "Ridley Scott"));
        addMovieToGenre("disparos", new Movie("300", 2006, "Zack Snyder"));
        addMovieToGenre("disparos", new Movie("Terminator 2: Judgment Day", 1991, "James Cameron"));

        // Documentales
        addMovieToGenre("documentales", new Movie("Planet Earth", 2006, "Alastair Fothergill"));
        addMovieToGenre("documentales", new Movie("The Last Dance", 2020, "Jason Hehir"));
        addMovieToGenre("documentales", new Movie("Won't You Be My Neighbor?", 2018, "Morgan Neville"));
        addMovieToGenre("documentales", new Movie("13th", 2016, "Ava DuVernay"));
        addMovieToGenre("documentales", new Movie("Blackfish", 2013, "Gabriela Cowperthwaite"));
        addMovieToGenre("documentales", new Movie("Jiro Dreams of Sushi", 2011, "David Gelb"));
        addMovieToGenre("documentales", new Movie("The Social Dilemma", 2020, "Jeff Orlowski"));

        // Terror
        addMovieToGenre("terror", new Movie("The Exorcist", 1973, "William Friedkin"));
        addMovieToGenre("terror", new Movie("Get Out", 2017, "Jordan Peele"));
        addMovieToGenre("terror", new Movie("A Nightmare on Elm Street", 1984, "Wes Craven"));
        addMovieToGenre("terror", new Movie("The Shining", 1980, "Stanley Kubrick"));
        addMovieToGenre("terror", new Movie("It", 2017, "Andy Muschietti"));
        addMovieToGenre("terror", new Movie("Halloween", 1978, "John Carpenter"));
        addMovieToGenre("terror", new Movie("The Conjuring", 2013, "James Wan"));
    }

    public void addMovieToGenre(String genre, Movie movie) {
        switch (genre.toLowerCase()) {
            case "cienciaficcion":
                cienciaFiccionMovies.insert(movie);
                break;
            case "disparos":
                disparosMovies.insert(movie);
                break;
            case "documentales":
                documentalesMovies.insert(movie);
                break;
            case "terror":
                terrorMovies.insert(movie);
                break;
            default:
                System.out.println("Unknown genre: " + genre);
                break;
        }
    }
    
    
    

    public void displayMoviesInGenre(String genre) {
        LinkedList listToDisplay = null;
        switch (genre.toLowerCase()) {
            case "cienciaficcion":
                listToDisplay = cienciaFiccionMovies;
                break;
            case "disparos":
                listToDisplay = disparosMovies;
                break;
            case "documentales":
                listToDisplay = documentalesMovies;
                break;
            case "terror":
                listToDisplay = terrorMovies;
                break;
            default:
                System.out.println("Unknown genre: " + genre);
                return;
        }

        if (listToDisplay.isEmpty()) {
            System.out.println("No movies in the " + genre + " genre.");
            return;
        }

        System.out.println("Movies in the " + genre + " genre:");
        Node current = listToDisplay.start;
        while (current != null) {
            System.out.println(current.element);
            current = current.next;
        }
    }
    
    public LinkedList getMoviesInGenre(String genre) {
        switch (genre.toLowerCase()) {
            case "cienciaficcion":
                return cienciaFiccionMovies;
            case "disparos":
                return disparosMovies;
            case "documentales":
                return documentalesMovies;
            case "terror":
                return terrorMovies;
            default:
                System.out.println("Unknown genre: " + genre);
                return null;
        }
    

   // public static void main(String[] args) {
        // Crear la instancia de MovieGenreLists
        //MovieGenreLists movieLists = new MovieGenreLists();

        // Mostrar las películas de cada género
       // movieLists.displayMoviesInGenre("cienciaficcion");
      //  movieLists.displayMoviesInGenre("disparos");
     //   movieLists.displayMoviesInGenre("documentales");
  ///      movieLists.displayMoviesInGenre("terror");
   }
}
    
    
    
    
    
    

    

