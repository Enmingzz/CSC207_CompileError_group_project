package entity;

import java.util.ArrayList;

public class CommonUser implements User{
    String name;
    String password;
    String email;
    float userRating;
    String Utroid;

    public CommonUser(String name, String Password, String email, float userRating, String Utroid){
        this.name = name;
        this.password = Password;
        this.email = email;
        this.userRating = userRating;
        this.Utroid = Utroid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public float getUserRating() {
        return userRating;
    }

    public String getUtroid() {
        return Utroid;
    }
}
