/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import domain.Administrator;

/**
 *
 * @author Marvin
 */
public class Test {

    public static void main(String[] args) {
        // Crear una instancia del Administrador
        Administrator admin = new Administrator();

        // Probar la adición de una película
        System.out.println("Adding a movie:");
        admin.addMovie("Inception", "Sci-Fi", "A mind-bending thriller", "path/to/inception.jpg");
        admin.addMovie("Interstellar", "Sci-Fi", "A journey through space and time", "path/to/interstellar.jpg");

        // Probar la edición de una película
        System.out.println("Editing a movie:");
        admin.editMovie("Inception", "Inception (Edited)", "Sci-Fi", "A mind-bending thriller (Edited)", "path/to/inception_edited.jpg");

        // Probar la eliminación de una película
        System.out.println("Deleting a movie:");
        admin.deleteMovie("Interstellar");

        // Probar la adición de una serie
        System.out.println("Adding a series:");
        admin.addSeries("Breaking Bad", "Drama", "A high school teacher turned meth producer", "path/to/breaking_bad.jpg");

        // Probar la edición de una serie
        System.out.println("Editing a series:");
        admin.editSeries("Breaking Bad", "Breaking Bad (Edited)", "Drama", "A high school teacher turned meth producer (Edited)", "path/to/breaking_bad_edited.jpg");

        // Probar la eliminación de una serie
        System.out.println("Deleting a series:");
        admin.deleteSeries("Breaking Bad (Edited)");

        // Probar la adición de un programa
        System.out.println("Adding a program:");
        admin.addProgram("Morning News", "News", "06:00 AM", "path/to/morning_news.jpg");

        // Probar la edición de un programa
        System.out.println("Editing a program:");
        admin.editProgram("Morning News", "Morning News (Edited)", "News", "path/to/morning_news_edited.jpg");

        // Probar la eliminación de un programa
        System.out.println("Deleting a program:");
        admin.deleteProgram("Morning News (Edited)");

        // Probar el cambio de horario de un programa
        System.out.println("Changing program schedule:");
        admin.addProgram("Evening Show", "Entertainment", "08:00 PM", "path/to/evening_show.jpg");
        admin.changeProgramSchedule("Evening Show", "09:00 PM");

        System.out.println("Tests completed.");
    }
}
