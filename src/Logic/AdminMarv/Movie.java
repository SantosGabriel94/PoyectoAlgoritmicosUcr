package Logic.AdminMarv;

public class Movie {

    private String title;
    private String genre;
    private String description;
    private String pathImage;

    public Movie(String title, String genre, String description, String pathImage) {
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

}
