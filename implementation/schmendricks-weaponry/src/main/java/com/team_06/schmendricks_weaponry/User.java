package com.team_06.schmendricks_weaponry;

public class User {
    private int userId;
    private String username;
    private String email;
    private String password;

    public User(){}

    public User(int id, String u, String e, String p){
        userId = id;
        username = u;
        email = e;
        password = p;
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
}
