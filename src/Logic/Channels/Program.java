
package Logic.Channels;

import TDA.DynamicStack.DynamicStack;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Program {
    
    private String title;
    private LocalTime schedule;

    public Program() {
    }

    public Program(String title, LocalTime schedule) {
        this.title = title;
        this.schedule = schedule;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalTime schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return  title;
    }  
}
