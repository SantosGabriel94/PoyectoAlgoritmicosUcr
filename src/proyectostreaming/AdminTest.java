package proyectostreaming;

import Logic.Schedule;
import domain.AdminLinkedList;
import domain.AdminModule;

/**
 *
 * @author Marvin
 */
public class AdminTest {

    public static void main(String[] args) {
        AdminModule admin = new AdminModule();

        // Add movies
        admin.addMovie("Inception", "Sci-Fi", "A mind-bending thriller", "/path/to/inception.jpg");
        admin.addMovie("The Matrix", "Sci-Fi", "A hacker discovers the true nature of reality", "/path/to/matrix.jpg");
        admin.addMovie("The Godfather", "Crime", "The aging patriarch of an organized crime dynasty transfers control of his empire to his reluctant son", "/path/to/godfather.jpg");
        System.out.println("Movies added. \n");

        // Edit a movie
        admin.editMovie("Inception", "Inception", "Sci-Fi", "A science fiction thriller", "/new/path/to/inception.jpg");
        System.out.println("Movie edited.\n");

        // Delete a movie
        admin.deleteMovie("The Matrix");
        System.out.println("Movie deleted.\n");

        // Add series
        admin.addSerie("Breaking Bad", "Drama", "A chemistry teacher turns into a meth manufacturer", "/path/to/breakingbad.jpg");
        admin.addSerie("Game of Thrones", "Fantasy", "Nine noble families wage war against each other in order to gain control over the mythical land of Westeros", "/path/to/got.jpg");
        admin.addSerie("Friends", "Comedy", "Follows the personal and professional lives of six twenty to thirty-something-year-old friends living in Manhattan", "/path/to/friends.jpg");
        System.out.println("Series added.\n");

        // Edit a series
        admin.editSerie("Breaking Bad", "Breaking Bad", "Drama", "A teacher turns into a meth manufacturer", "/new/path/to/breakingbad.jpg");
        System.out.println("Series edited.\n");

        // Delete a series
        admin.deleteSerie("Friends");
        System.out.println("Series deleted.\n");

        // Add programs
        Schedule schedule1 = new Schedule("08:00 AM");
        Schedule schedule2 = new Schedule("12:00 PM");
        Schedule schedule3 = new Schedule("06:00 PM");
        admin.addProgram("Morning News", "News", schedule1, "/path/to/morningnews.jpg");
        admin.addProgram("Midday Show", "Talk Show", schedule2, "/path/to/middayshow.jpg");
        admin.addProgram("Evening Report", "News", schedule3, "/path/to/eveningreport.jpg");
        System.out.println("Programs added.\n");

        // Edit a program
        Schedule newSchedule = new Schedule("09:00 AM");
        admin.editProgram("Morning News", "Morning News", "News", newSchedule, "/new/path/to/morningnews.jpg");
        System.out.println("Program edited.\n");

        // Change the schedule of a program
        admin.changeProgramSchedule("Evening Report", new Schedule("07:00 PM"));
        System.out.println("Schedule of program changed.\n");

        // Delete a program
        admin.deleteProgram("Midday Show");
        System.out.println("Program deleted.\n");

        // Print current state of lists
        System.out.println("\nCURRENT MOVIES IN THE SYSTEM:");
        printList(admin.getMovies());

        System.out.println("\nCURRENT SERIES IN THE SYSTEM:");
        printList(admin.getSeries());

        System.out.println("\nCURRENT PROGRAMS IN THE SYSTEM:");
        printList(admin.getPrograms());
    }

    private static void printList(AdminLinkedList list) {
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getElementAt(i).toString());
        }
    }

}
