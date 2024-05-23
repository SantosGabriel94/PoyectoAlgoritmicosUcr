/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.util.ArrayList;
import Logic.Profile;

/**
 *
 * @author User
 */
public class User {

    private String userName;
    private String password;
    private ArrayList<Profile> profiles;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.profiles = new ArrayList();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(ArrayList<Profile> profiles) {
        this.profiles = profiles;
    }

    public void addProfile(Profile profile) {
        if (profiles.size() < 5) {
            profiles.add(profile);
        } else {
            System.out.println("No more profiles can be added");
        }
    }  
}
