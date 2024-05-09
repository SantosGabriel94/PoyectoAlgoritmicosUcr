package domain;

import adm.Schedule;
import adm.Movie;
import adm.Program;
import adm.Serie;
import java.util.LinkedList;
import java.util.List;

public class Administrator {

    private List<Movie> films;
    private List<Serie> series;
    private List<Program> programs;

    //Inicializa las listas de películas, series y programas como listas vacías
    public Administrator() {
        this.films = new LinkedList<>();
        this.series = new LinkedList<>();
        this.programs = new LinkedList<>();
    }

    // Métodos para agregar, editar y eliminar peliculas
    public void addMovie(String title, String gender, String description, String pathImage) {
        Movie newMovie = new Movie(title, gender, description, pathImage);
        films.add(newMovie);
    }

    public void editMovie(String nameMovie, String newTitle, String newGender, String newDescription, String newPathImage) {
        for (Movie movie : films) {
            if (movie.getTitle().equals(nameMovie)) {
                movie.setTitle(newTitle);
                movie.setGender(newGender);
                movie.setDescription(newDescription);
                movie.setPathImage(newPathImage);
                return;
            }
        }
        System.out.println("No program found with the specified name.");
    }

    public void deleteMovie(String nameMovie) {
        for (int i = 0; i < films.size(); i++) {
            Movie movie = films.get(i);
            if (movie.getTitle().equals(nameMovie)) {
                films.remove(i);
                return;
            }
        }
        System.out.println("No program found with the specified name.");
    }

    // Métodos para agregar, editar y eliminar series
    public void addSeries(String title, int season, String description, String pathImage) {
        Serie newSeries = new Serie(title, season, description, pathImage);
        series.add(newSeries);
    }

    public void editSeries(String nameSeries, String newTitle, int newSeason, String newDescription, String newPathImage) {
        for (Serie serie : series) {
            if (serie.getTitle().equals(nameSeries)) {
                serie.setTitle(newTitle);
                serie.setSeason(newSeason);
                serie.setDescription(newDescription);
                serie.setPathImage(newPathImage);
                return;
            }
        }
        System.out.println("No program found with the specified name.");
    }

    public void deleteSeries(String nameSeries) {
        for (int i = 0; i < series.size(); i++) {
            Serie serie = series.get(i);
            if (serie.getTitle().equals(nameSeries)) {
                series.remove(i);
                return;
            }
        }
        System.out.println("No program found with the specified name.");
    }

    // Métodos para agregar, editar y eliminar programas, cambia la hora
    public void addProgram(String name, String type, String startTime, String pathImage) {
        Schedule schedule = new Schedule(startTime);
        Program newProgram = new Program(name, type, schedule, pathImage);
        programs.add(newProgram);
    }

    public void editProgram(String nameProgram, String newName, String newType, String newPathImage) {
        for (Program program : programs) {
            if (program.getName().equals(nameProgram)) {
                program.setName(newName);
                program.setType(newType);
                program.setPathImage(newPathImage);
                return;
            }
        }
        System.out.println("No program found with the specified name.");
    }

    public void deleteProgram(String nameProgram) {
        for (int i = 0; i < programs.size(); i++) {
            Program program = programs.get(i);
            if (program.getName().equals(nameProgram)) {
                programs.remove(i);
                return;
            }
        }
        System.out.println("No program found with the specified name.");
    }

    public void changeProgramSchedule(String nameProgram, String newStartTime) {
        for (Program program : programs) {
            if (program.getName().equals(nameProgram)) {
                Schedule existingSchedule = program.getHour();
                existingSchedule.setStartTime(newStartTime);
                return;
            }
        }
        System.out.println("No program found with the specified name.");
    }

}
