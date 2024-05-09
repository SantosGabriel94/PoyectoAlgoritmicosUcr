package adm;

public class Serie {

    private String title;
    private int season;
    private String description;
    private String pathImage;

    public Serie(String title, int season, String description, String pathImage) {
        this.title = title;
        this.season = season;
        this.description = description;
        this.pathImage = pathImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
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
