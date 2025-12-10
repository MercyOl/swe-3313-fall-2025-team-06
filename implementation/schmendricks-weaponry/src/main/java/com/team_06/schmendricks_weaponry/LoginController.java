package com.team_06.schmendricks_weaponry;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String registerNewUser(@RequestParam("username") String username, @RequestParam("email") String email, @RequestParam("password") String password, Model model) {

        // Create a new user
        User newUser = new User(username, email, password);

        // Load the users in the database to check
        ArrayList<User> userList = loginService.loadUsers();

        // Check the database to see if username or email are already in use
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getUsername().equals(username)) {
                model.addAttribute("registerError", "Username already exists.");
                return "LoginPage";
            }

            if(userList.get(i).getPassword().equals(email)){
                model.addAttribute("registerError", "Email already in use.");
                return "LoginPage";
            }
        }

        //Add the new user to the database
        try {

            loginService.addUser(newUser);

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        //Return success message
        System.out.println("USER SUCCESSFULLY REGISTERED!");
        model.addAttribute("registerSuccess", "Registration complete! Please log in.");
        return "LoginPage";
    }


    @PostMapping("/login")
    public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model){

        // Load the users in the database to check
        ArrayList<User> userList = loginService.loadUsers();

        // If the user exists (and password is correct), send them to the home page
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getUsername().equals(username)){
                if(userList.get(i).getPassword().equals(password)){
                    System.out.println("USER SUCCESSFULLY LOGGED IN!");
                    return "HomePage";      //REPLACE WITH REDIRECT TO HOMEPAGE
                }
            }
        }

        model.addAttribute("loginError", "Invalid email or password.");
        return "LoginPage";  // reload the same page with error message
    }
}

