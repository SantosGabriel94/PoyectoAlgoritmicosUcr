/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic;

//import java.awt.List;
//import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Algoritmicos
 */
public class User {

    private String username;
    private String password;
    private int age;
    private List<Profile> profiles;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.profiles = new ArrayList<>(); // We initialize the list of profiles as ArrayList
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

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public boolean agregarPerfil(String name, int age) {
        if (profiles.size() >= 5) {
            System.out.println("No more profiles can be added. Limit reached.");
            return false;
        }
        Profile newProfile = new Profile(name, age); // We create a new profile
        profiles.add(newProfile); // We add the profile to the 'profiles' list
        System.out.println("Profile added successfully.");
        return true;
    }
}
