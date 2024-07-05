/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic.AdminMarv;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Algoritmicos
 */
public class Administrator {

    private List<Movie> films;
    private List<Serie> series;
    private List<Program> programs;

    //Initializes movie, series, and show lists as empty lists
    public Administrator() {
        this.films = new LinkedList<>();
        this.series = new LinkedList<>();
        this.programs = new LinkedList<>();
    }

    // Methods to add, edit and delete movies
    public void addMovie(String title, String genre, String description, String pathImage) {
        validate(title, "Title");
        validate(genre, "Genre");
        validate(description, "Description");
        validate(pathImage, "Path Image");

        // Check if a movie with the same title already exists
        if (findMovie(title) != null) {
            throw new ListException("Movie with the same title already exists.");
        }

        Movie newMovie = new Movie(title, genre, description, pathImage);
        films.add(newMovie);
    }

    public void editMovie(String nameMovie, String newTitle, String newGenre,
            String newDescription, String newPathImage) {
        validate(newTitle, "New Title");
        validate(newGenre, "New Genre");
        validate(newDescription, "New Description");
        validate(newPathImage, "New Path Image");

        for (Movie movie : films) {
            if (movie.getTitle().equals(nameMovie)) {
                movie.setTitle(newTitle);
                movie.setGenre(newGenre);
                movie.setDescription(newDescription);
                movie.setPathImage(newPathImage);
                return;
            }
        }
        throw new ListException("No movie found with the specified name.");
    }

    public void deleteMovie(String nameMovie) {
        for (int i = 0; i < films.size(); i++) {
            Movie movie = films.get(i);
            if (movie.getTitle().equals(nameMovie)) {
                films.remove(i);
                return;
            }
        }
        throw new ListException("No movie found with the specified name.");
    }

    // Search a movie by its title
    public Movie findMovie(String nameMovie) {
        for (Movie movie : films) {
            if (movie.getTitle().equals(nameMovie)) {
                return movie;
            }
        }
        return null;
    }

    // Methods to add, edit and delete series
    public void addSeries(String title, String genre, String description,
            String pathImage) {
        validate(title, "Title");
        validate(genre, "Genre");
        validate(description, "Description");
        validate(pathImage, "Path Image");

        // Check if a series with the same title already exists
        if (findSeries(title) != null) {
            throw new ListException("Series with the same title already exists.");
        }
        Serie newSeries = new Serie(title, genre, description, pathImage);
        series.add(newSeries);
    }

    public void editSeries(String nameSeries, String newTitle, String newGenre,
            String newDescription, String newPathImage) {
        validate(newTitle, "New Title");
        validate(newGenre, "New Genre");
        validate(newDescription, "New Description");
        validate(newPathImage, "New Path Image");

        for (Serie serie : series) {
            if (serie.getTitle().equals(nameSeries)) {
                serie.setTitle(newTitle);
                serie.setGenre(newGenre);
                serie.setDescription(newDescription);
                serie.setPathImage(newPathImage);
                return;
            }
        }
        throw new ListException("No series found with the specified name.");
    }

    public void deleteSeries(String nameSeries) {
        for (int i = 0; i < series.size(); i++) {
            Serie serie = series.get(i);
            if (serie.getTitle().equals(nameSeries)) {
                series.remove(i);
                return;
            }
        }
        throw new ListException("No series found with the specified name.");
    }

    // Search a series by its title
    public Serie findSeries(String nameSeries) {
        for (Serie serie : series) {
            if (serie.getTitle().equals(nameSeries)) {
                return serie;
            }
        }
        return null;
    }

    // Methods to add, edit and delete programs, change the time
    public void addProgram(String name, String type, String startTime, String pathImage) {
        validate(name, "Name");
        validate(type, "Type");
        validate(startTime, "Start Time");
        validate(pathImage, "Path Image");

        // Check if a program with the same name already exists
        if (findProgram(name) != null) {
            throw new ListException("Program with the same name already exists.");
        }

        Schedule schedule = new Schedule(startTime);
        Program newProgram = new Program(name, type, schedule, pathImage);
        programs.add(newProgram);
    }

    public void editProgram(String nameProgram, String newName, String newType,
            String newPathImage) {
        validate(newName, "New Name");
        validate(newType, "New Type");
        validate(newPathImage, "New Path Image");

        for (Program program : programs) {
            if (program.getName().equals(nameProgram)) {
                program.setName(newName);
                program.setType(newType);
                program.setPathImage(newPathImage);
                return;
            }
        }
        throw new ListException("No program found with the specified name.");
    }

    public void deleteProgram(String nameProgram) {
        for (int i = 0; i < programs.size(); i++) {
            Program program = programs.get(i);
            if (program.getName().equals(nameProgram)) {
                programs.remove(i);
                return;
            }
        }
        throw new ListException("No program found with the specified name.");
    }

    // Search for a program by name
    public Program findProgram(String nameProgram) {
        for (Program program : programs) {
            if (program.getName().equals(nameProgram)) {
                return program;
            }
        }
        return null;
    }

    public void changeProgramSchedule(String nameProgram, String newStartTime) {
        validate(newStartTime, "New Start Time");

        for (Program program : programs) {
            if (program.getName().equals(nameProgram)) {
                Schedule existingSchedule = program.getHour();
                existingSchedule.setStartTime(newStartTime);
                return;
            }
        }
        throw new ListException("No program found with the specified name.");
    }

    // Non-null or empty string validation method
    private void validate(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be null or empty.");
        }
    }
}
