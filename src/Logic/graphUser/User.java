package Logic.graphUser;

import Logic.Profile;

/**
 *
 * @author User
 */
public class User {

    private String username;
    private String password;
    private int age;
    private GraphUser profiles; // Graph to store profiles
    private int maxProfiles = 5;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.profiles = new GraphUser(maxProfiles); // Initialize the graph with a maximum size of profiles
        addProfile(username, age);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean addProfile(String name, int age) {
        if (profiles.getSize() >= maxProfiles) {
            System.out.println("Cannot add more profiles. Limit reached.");
            return false;
        }
        Profile newProfile = new Profile(name, age); // Create a new profile
        profiles.addVertex(newProfile); // Add the profile to the graph
        System.out.println("Profile added successfully.");
        return true;
    }

    public void printProfiles() {
        System.out.println(profiles.toString()); // Print the graph information

    }
}
