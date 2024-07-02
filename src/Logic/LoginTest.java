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
        System.out.println("Registro de 'Gabriel' con contraseña 'pass1243534531': " + login.register("Gabriel2", "gv2", 20));

        // Autenticación de usuarios
        System.out.println("Autenticación con 'Gabriel' y contraseña 'pass1243534531': " + login.authenticate("Gabriel2", "gv2"));

        // Obtener usuario y agregar perfiles
        User user = login.getUser("Gabriel2");

        // Agregar perfiles
        user.agregarPerfil("Perfil22", 25);//este es para agregar el perfil a una lista por si se desean agregar diversos perfiles
        //user.agregarPerfil("Perfil3", 35);
        //user.agregarPerfil("Perfil4", 45);
        //user.agregarPerfil("Perfil5", 55);
      //  user.agregarPerfil("Perfil6", 65); // Este debería fallar en caso que se quiera meter mas de 5 usuarios dentro de la cuenta

        // Guardar usuarios nuevamente
        login.saveUsers();//este funciona con el fin de agregar el perfil a la cuenta en este caso Gabriel2

        // Verificación de perfiles del usuario
       // User updatedUser = login.getUser("Gabriel");
        //Profile profile1 = updatedUser.getProfiles().get(0);
        //Profile profile2 = updatedUser.getProfiles().get(1);
        //Profile profile3 = updatedUser.getProfiles().get(2);
        //Profile profile4 = updatedUser.getProfiles().get(3);
        //Profile profile5 = updatedUser.getProfiles().get(4);

        //System.out.println("Nombre del perfil 1: " + profile1.getNameProfile() + ", Edad: " + profile1.getAge());
        //System.out.println("Nombre del perfil 2: " + profile2.getNameProfile() + ", Edad: " + profile2.getAge());
        //System.out.println("Nombre del perfil 3: " + profile3.getNameProfile() + ", Edad: " + profile3.getAge());
        //System.out.println("Nombre del perfil 4: " + profile4.getNameProfile() + ", Edad: " + profile4.getAge());
        //System.out.println("Nombre del perfil 5: " + profile5.getNameProfile() + ", Edad: " + profile5.getAge());

        // Prueba de la clase Profile
       // Profile profileA = new Profile("PerfilA", 30);
        //System.out.println("Nombre del perfil: " + profileA.getNameProfile() + ", Edad: " + profileA.getAge());

        //Profile profileB = new Profile("PerfilB", 50);
        //System.out.println("Nombre del perfil: " + profileB.getNameProfile() + ", Edad: " + profileB.getAge());

        //Profile profileC = new Profile("PerfilC", 70);
        //System.out.println("Nombre del perfil: " + profileC.getNameProfile() + ", Edad: " + profileC.getAge());

        //Profile profileD = new Profile("PerfilD", 20);
        //System.out.println("Nombre del perfil: " + profileD.getNameProfile() + ", Edad: " + profileD.getAge());

        //Profile profileE = new Profile("PerfilE", 300);
        //System.out.println("Nombre del perfil: " + profileE.getNameProfile() + ", Edad: " + profileE.getAge());

        //Profile profileF = new Profile("PerfilF", 3000);
        //System.out.println("Nombre del perfil: " + profileF.getNameProfile() + ", Edad: " + profileF.getAge());

        // Cambio de nombre del perfil y edad
        // profileA.setNameProfile("PerfilA Actualizado");
        // profileA.setAge(31);
        // System.out.println("Perfil actualizado: Nombre - " + profileA.getNameProfile() + ", Edad - " + profileA.getAge());

        // Opciones de visualización de medios
        // profileA.streamingOrTV(TVOption.STREAMING); 
        // profileA.streamingOrTV(TVOption.TV_CABLE);
    }
}

    
    

