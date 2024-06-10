/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author User
 */
public class LoginTest {

    public static void main(String[] args) {
        // Prueba de la clase Login
        Login login = new Login();

        // Registro de usuarios
        System.out.println("Registro de 'user1' con contraseña 'pass1': " + login.register("user1", "pass1"));
        System.out.println("Intento de registrar nuevamente 'user1': " + login.register("user1", "pass1"));

        // Autenticación de usuarios
        System.out.println("Autenticación con 'user1' y contraseña 'pass1': " + login.authenticate("user1", "pass1"));
        System.out.println("Autenticación con 'user1' y contraseña incorrecta 'pass2': " + login.authenticate("user1", "pass2"));

        // Prueba de la clase Profile
        Profile profile1 = new Profile("Perfil1", 30);
        System.out.println("Nombre del perfil: " + profile1.getNameProfile() + ", Edad: " + profile1.getAge());

        // Cambio de nombre del perfil y edad
        profile1.setNameProfile("Perfil1 Actualizado");
        profile1.setAge(31);
        System.out.println("Perfil actualizado: Nombre - " + profile1.getNameProfile() + ", Edad - " + profile1.getAge());

        // Opciones de visualización de medios
        profile1.streamingOrTV(TVOption.STREAMING); 
        profile1.streamingOrTV(TVOption.TV_CABLE);
    }
}

    
    

