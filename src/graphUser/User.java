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
    private GraphUser profiles; // Grafo para almacenar perfiles
    private int maxProfiles = 5;

    public User(String username, String password, int age) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.profiles = new GraphUser(maxProfiles); // Inicializar el grafo con el tamaño máximo de perfiles
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
        Profile newProfile = new Profile(name, age); // Crear un nuevo perfil
        profiles.addVertex(newProfile); // Añadir el perfil al grafo
        System.out.println("Profile added successfully.");
        return true;
    }

    public GraphUser getProfiles() {
        return profiles;
    }

    public void printProfiles() {
        System.out.println(profiles.toString()); // Imprimir la información del grafo
    }
}