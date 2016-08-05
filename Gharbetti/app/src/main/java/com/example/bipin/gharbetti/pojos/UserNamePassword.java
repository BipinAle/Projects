package com.example.bipin.gharbetti.pojos;

/**
 * Created by bipin on 6/16/16.
 */
public class UserNamePassword {

    String name,password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserNamePassword(String name,String password) {

        this.name = name;
        this.password = password;
    }
}
