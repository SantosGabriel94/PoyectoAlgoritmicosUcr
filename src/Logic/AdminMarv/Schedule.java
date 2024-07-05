/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic.AdminMarv;

/**
 *
 * @author Algoritmicos
 */
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
}
