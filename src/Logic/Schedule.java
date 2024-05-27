package Logic;

public class Schedule {

    private String startTime;

    public Schedule(String startTime) {
        this.startTime = startTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String horaInicio) {
        this.startTime = horaInicio;
    }

    @Override
    public String toString() {
        return "Schedule"
                + "startTime: " + startTime + "\n";
    }
}
