/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

//import java.awt.List;
//import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author User
 */
public class User {
    private String username;
    private String password;
    private int edad;
    private List<Profile> profiles;

    public User(String username, String password, int edad) {
        this.username = username;
        this.password = password;
        this.edad = edad;
        this.profiles = new ArrayList<>(); // Inicializamos la lista de perfiles como ArrayList
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public boolean agregarPerfil(String nombre, int edad) {
        if (profiles.size() >= 5) {
            System.out.println("No se pueden agregar más perfiles. Límite alcanzado.");
            return false;
        }
        Profile nuevoPerfil = new Profile(nombre, edad); // Creamos un nuevo perfil
        profiles.add(nuevoPerfil); // Agregamos el perfil a la lista 'profiles'
        System.out.println("Perfil agregado correctamente.");
        return true;
    }

    // Otros métodos, getters y setters (omitiendo para simplificar)
}


    

