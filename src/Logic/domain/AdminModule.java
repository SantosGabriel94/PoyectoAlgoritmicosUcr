package Logic.domain;



public class AdminModule {

    private AdminLinkedList movies;
    private AdminLinkedList series;
    private AdminLinkedList programs;

    public AdminModule() {
        this.movies = new AdminLinkedList();
        this.series = new AdminLinkedList();
        this.programs = new AdminLinkedList();
    }

    // Movies
    public void addMovie(String title, String genre, String description, String imagePath) {
        Movie movie = new Movie(title, genre, description, imagePath);
        movies.insert(movie);
        System.out.println("Movie added: " + title);
    }

    public void editMovie(String oldTitle, String newTitle, String newGenre, String newDescription, String newImagePath) {
        int position = getMoviePosition(oldTitle);
        if (position != -1) {
            Movie movie = (Movie) movies.getElementAt(position);
            movie.setTitle(newTitle);
            movie.setGenre(newGenre);
            movie.setDescription(newDescription);
            movie.setPathImage(newImagePath);
            System.out.println("Movie edited: " + oldTitle + " to " + newTitle);
        } else {
            throw new ListException("Movie not found");
        }
    }

    public void deleteMovie(String title) {
        int position = getMoviePosition(title);
        if (position != -1) {
            movies.delete(position);
            System.out.println("Movie deleted: " + title);
        } else {
            throw new ListException("Movie not found");
        }
    }

    private int getMoviePosition(String title) {
        for (int i = 0; i < movies.getSize(); i++) {
            Movie movie = (Movie) movies.getElementAt(i);
            if (movie.getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public AdminLinkedList getMovies() {
        return movies;
    }

    // Series
    public void addSerie(String title, String genre, String description, String imagePath) {
        Serie serie = new Serie(title, genre, description, imagePath);
        series.insert(serie);
        System.out.println("Serie added: " + title);
    }

    public void editSerie(String oldTitle, String newTitle, String newGenre, String newDescription, String newImagePath) {
        int position = getSeriePosition(oldTitle);
        if (position != -1) {
            Serie serie = (Serie) series.getElementAt(position);
            serie.setTitle(newTitle);
            serie.setGenre(newGenre);
            serie.setDescription(newDescription);
            serie.setPathImage(newImagePath);
            System.out.println("Serie edited: " + oldTitle + " to " + newTitle);
        } else {
            throw new ListException("Serie not found");
        }
    }

    public void deleteSerie(String title) {
        int position = getSeriePosition(title);
        if (position != -1) {
            series.delete(position);
            System.out.println("Serie deleted: " + title);
        } else {
            throw new ListException("Serie not found");
        }
    }

    private int getSeriePosition(String title) {
        for (int i = 0; i < series.getSize(); i++) {
            Serie serie = (Serie) series.getElementAt(i);
            if (serie.getTitle().equals(title)) {
                return i;
            }
        }
        return -1;
    }

    public AdminLinkedList getSeries() {
        return series;
    }

    // Programs
    public void addProgram(String name, String type, Schedule schedule, String imagePath) {
        Program program = new Program(name, type, schedule, imagePath);
        programs.insert(program);
        System.out.println("Program added: " + name);
    }

    public void editProgram(String oldName, String newName, String newType, Schedule newSchedule, String newImagePath) {
        int position = getProgramPosition(oldName);
        if (position != -1) {
            Program program = (Program) programs.getElementAt(position);
            program.setName(newName);
            program.setType(newType);
            program.setHour(newSchedule);
            program.setPathImage(newImagePath);
            System.out.println("Program edited: " + oldName + " to " + newName);
        } else {
            throw new ListException("Program not found");
        }
    }

    public void deleteProgram(String name) {
        int position = getProgramPosition(name);
        if (position != -1) {
            programs.delete(position);
            System.out.println("Program deleted: " + name);
        } else {
            throw new ListException("Program not found");
        }
    }

    public void changeProgramSchedule(String name, Schedule newSchedule) {
        int position = getProgramPosition(name);
        if (position != -1) {
            Program program = (Program) programs.getElementAt(position);
            program.setHour(newSchedule);
            System.out.println("Schedule of program " + name + " changed to " + newSchedule.getStartTime());
        } else {
            throw new ListException("Program not found");
        }
    }

    private int getProgramPosition(String name) {
        for (int i = 0; i < programs.getSize(); i++) {
            Program program = (Program) programs.getElementAt(i);
            if (program.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public AdminLinkedList getPrograms() {
        return programs;
    }
}
