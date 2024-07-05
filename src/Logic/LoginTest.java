/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic;

/**
 *
 * @author Algoritmicos
 */
public class LoginTest {

    public static void main(String[] args) {
        // Test the Login class
        Login login = new Login();

        // User Registration
        System.out.println("Registration of 'Gabriel' with password 'pass1243534531': " + login.register("Gabriel2", "gv2", 20));

        // User authentication
        System.out.println("Authentication with 'Gabriel' and password 'pass1243534531': " + login.authenticate("Gabriel2", "gv2"));

        // Get user and add profiles
        User user = login.getUser("Gabriel2");

        // Add profiles
        user.agregarPerfil("Perfil22", 25);//This is to add the profile to a list in case you want to add various profiles
        //user.agregarPerfil("Perfil3", 35);
        //user.agregarPerfil("Perfil4", 45);
        //user.agregarPerfil("Perfil5", 55);
        //user.agregarPerfil("Perfil6", 65); // This should fail if you want to add more than 5 users to the account.

        // Save users again
        login.saveUsers();// This works in order to add the profile to the account in this case Gabriel2

        // User profile verification
        // User updatedUser = login.getUser("Gabriel");
        //Profile profile1 = updatedUser.getProfiles().get(0);
        //Profile profile2 = updatedUser.getProfiles().get(1);
        //Profile profile3 = updatedUser.getProfiles().get(2);
        //Profile profile4 = updatedUser.getProfiles().get(3);
        //Profile profile5 = updatedUser.getProfiles().get(4);
        //
        //System.out.println("Nombre del perfil 1: " + profile1.getNameProfile() + ", Edad: " + profile1.getAge());
        //System.out.println("Nombre del perfil 2: " + profile2.getNameProfile() + ", Edad: " + profile2.getAge());
        //System.out.println("Nombre del perfil 3: " + profile3.getNameProfile() + ", Edad: " + profile3.getAge());
        //System.out.println("Nombre del perfil 4: " + profile4.getNameProfile() + ", Edad: " + profile4.getAge());
        //System.out.println("Nombre del perfil 5: " + profile5.getNameProfile() + ", Edad: " + profile5.getAge());
        //
        // Testing the Profile class
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
        //
        // Profile name and age change
        // profileA.setNameProfile("PerfilA Actualizado");
        // profileA.setAge(31);
        // System.out.println("Perfil actualizado: Nombre - " + profileA.getNameProfile() + ", Edad - " + profileA.getAge());
        //
        // Media display options
        // profileA.streamingOrTV(TVOption.STREAMING); 
        // profileA.streamingOrTV(TVOption.TV_CABLE);
    }
}
