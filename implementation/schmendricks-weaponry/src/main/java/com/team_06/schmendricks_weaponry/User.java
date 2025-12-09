package com.team_06.schmendricks_weaponry;

import java.util.ArrayList;

public class User {

    private int userId;
    private String username;
    private String email;
    private String password;
    private boolean isAdmin;

    public User(){}

    public User(String u, String e, String p){
        username = u;
        email = e;
        password = p;
    }

    public void setUserId(int id){
        userId = id;
    }

    public int getUserId(){
        return userId;
    }


    public String getUsername(){
        return username;
    }


    public String getEmail(){
        return email;
    }


    public String getPassword(){
        return password;
    }

    public boolean getIsAdmin(){
        return isAdmin;
    }
}

