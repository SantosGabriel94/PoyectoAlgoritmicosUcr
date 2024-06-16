
package Logic.Movie;



/**
 *
 * @author User
 */
public class Movie {
    private String title;  // Título de la película
    private int year;      // Año de lanzamiento
    private String director; // Director de la película

    // Constructor que inicializa los atributos de la película
    public Movie(String title, int year, String director) {
        this.title = title;
        this.year = year;
        this.director = director;
    }

    // Getters y setters para los atributos
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Método toString para mostrar información de la película de manera legible
    @Override
    public String toString() {
        return "Movie{title='" + title + "', year=" + year + ", director='" + director + "'}";
    }
    
}
