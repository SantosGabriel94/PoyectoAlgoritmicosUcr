package Logic.domain;

public class Program {

    private String name;
    private String type;
    private Schedule hour;
    private String pathImage;

    public Program(String name, String type, Schedule hour, String pathImage) {
        this.name = name;
        this.type = type;
        this.hour = hour;
        this.pathImage = pathImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Schedule getHour() {
        return hour;
    }

    public void setHour(Schedule hour) {
        this.hour = hour;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    @Override
    public String toString() {
        return "Program \n"
                + "name: " + name + "\n"
                + "type: " + type + "\n"
                + "hour: " + hour
                + "image: " + pathImage + "\n";
    }

}
