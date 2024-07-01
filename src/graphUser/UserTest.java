package Logic.graphUser;

/**
 *
 * @author Marvin
 */
public class UserTest {

    public static void main(String[] args) {
        // Create a new user with username, password, and age
        User user = new User("juan300000", "password123", 350);

        // Print initial profiles (should include the user's own profile)
        user.printProfiles();

        // Add new profiles
        user.addProfile("profile1", 10);
        user.addProfile("profile2", 15);
        user.addProfile("profile3", 20);
        user.addProfile("profile4", 25);

        //Extra profiles. You have to send a message "Cannot add more profiles. Limit reached."
        //user.addProfile("profile5", 31);
        //user.addProfile("profile6", 56);
        //user.addProfile("profile7", 87);
        //user.addProfile("profile7", 87);

        // Print all profiles in the graph
        user.printProfiles();
    }
}
