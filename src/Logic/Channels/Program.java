
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
        return "title:" + title + ", schedule:" + schedule;
    }
    
    

   public static void main(String[] args) {
        // Crear una instancia de LocalTime usando el método of(int hour, int minute)
        LocalTime horaActual = LocalTime.of(13, 30);
        System.out.println("Hora actual creada con LocalTime.of(): " + horaActual);

        // Obtener la hora usando el método getHour()
        int horas = horaActual.getHour();
        System.out.println("Horas: " + horas);

        // Crear otra instancia de LocalTime para comparar
        LocalTime otraHora = LocalTime.of(12, 0);
        
        // Comparar horas usando el método isBefore(LocalTime other)
        if (horaActual.isBefore(otraHora)) {
            System.out.println(horaActual + " es antes de " + otraHora);
        } else {
            System.out.println(horaActual + " es despues de " + otraHora);
        }

        // Cambiar la hora usando el método withHour(int hour)
        LocalTime horaModificada = horaActual.withHour(15);
        System.out.println("Hora modificada con withHour(): " + horaModificada);

        // Mostrar la hora como una cadena usando el método toString()
        String horaComoString = horaActual.toString();
        System.out.println("Hora como String: " + horaComoString);

        // Formatear la hora usando el método format(DateTimeFormatter formatter)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormateada = horaActual.format(formatter);
        System.out.println("Hora formateada: " + horaFormateada);
    }

   
}
