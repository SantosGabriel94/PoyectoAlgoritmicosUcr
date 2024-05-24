/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Sharon
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
        if (option.equals(TVOption.tv_cable)) {
            if (age >= TVOption.min_age_for_tv_cable) {
                System.out.println("Cable TV was selected");
            } else {
                System.out.println("Access restricted");
            }
        } else {
            if (option.equals(TVOption.streaming)) {
                if (age >= TVOption.min_age_for_streaming) {
                    System.out.println("Streaming was selected");
                } else {
                    System.out.println("Access restricted");
                }
            } else {
                System.out.println("Option invalide");
            }
        }
    }
}
