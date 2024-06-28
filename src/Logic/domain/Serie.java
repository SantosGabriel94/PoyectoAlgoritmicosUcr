package Logic.domain;

public class Serie {

    private String title;
    private String genre;
    private String description;
    private String pathImage;

    public Serie(String title, String genre, String description, String pathImage) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.pathImage = pathImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public String toString() {
        return "Serie \n"
                + "title: " + title + "\n"
                + "genre: " + genre + "\n"
                + "description: " + description + "\n"
                + "image: " + pathImage + "\n";
    }

}
