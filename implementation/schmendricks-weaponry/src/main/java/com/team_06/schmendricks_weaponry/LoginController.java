package com.team_06.schmendricks_weaponry;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.ArrayList;


@Controller
public class LoginController {

    @Autowired
    private UserService loginService;

    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("message", "Hello from Spring!");

        return "LoginPage"; // looks for templates/LoginPage.html
    }


    @PostMapping("/register")
    public String registerNewUser(int userId, String username, String email, String password) {

        // CREATE A NEW USER IN THE DATABASE
        User newUser = new User(userId, username, email, password);

        try {

            // Add the new user to the database
            loginService.addUser(newUser);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        return "LoginPage";
    }


    @PostMapping("/login")
    public String loginUser(String username, String password){

        // Load the users in the database to check
        ArrayList<User> userList = loginService.loadUsers();

        // If the user exists (and password is correct), send them to the home page
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getUsername().equals(username)){
                if(userList.get(i).getPassword().equals(password)){
                    return "HomePage";
                }
            }
        }

        return "LoginPage";
    }
}

