/*
 * Universidad de Costa Rica | Algoritmos y Estructura de Datos
 * Proyecto Final | Grupo #6 Algoritmicos
 */
package Logic;

/**
 *
 * @author Algoritmicos
 */
public class Profile {

    private String nameProfile;
    private int age;

    public Profile(String nameProfile, int age) {
        this.nameProfile = nameProfile;
        this.age = age;
    }

    public String getNameProfile() {
        return nameProfile;
    }

    public void setNameProfile(String nameProfile) {
        this.nameProfile = nameProfile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void streamingOrTV(String option) {
        if (option.equals(TVOption.TV_CABLE)) {
            System.out.println("Cable tv was selected");
        } else if (option.equals(TVOption.STREAMING)) {
            System.out.println("Streaming was selected");
        } else {
            System.out.println("Error");
        }
    }
}
