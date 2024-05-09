package adm;

public class Movie {

    private String title;
    private String gender;
    private String description;
    private String pathImage;

    public Movie(String title, String gender, String description, String pathImage) {
        this.title = title;
        this.gender = gender;
        this.description = description;
        this.pathImage = pathImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
