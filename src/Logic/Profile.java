
package Logic;

public class Profile {

    private String nameProfile;
    private int age;

    public Profile() {
    }
    
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
