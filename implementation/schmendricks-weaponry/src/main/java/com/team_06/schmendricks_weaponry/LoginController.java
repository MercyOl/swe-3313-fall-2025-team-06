package com.team_06.schmendricks_weaponry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class LoginController {


    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("message", "Hello from Spring!");
        return "LoginPage"; // looks for templates/LoginPage.html
    }

    @PostMapping("/register")
    public String registerNewUser(int userId, String username, String email, String password) {

        // CREATE A NEW USER IN THE DATABASE
        User newUser = new User(userId, username, email, password);


        return "LoginPage";
    }

    @PostMapping("/login")
    public String loginUser(Model model){
        model.addAttribute("message", "Logging in...");

        // CHECK THE DATABASE TO SEE IF USER EXISTS

        //IF USER EXISTS
        return "HomePage";

        //ELSE
        //RETURN -FALSE- or -LOGINPAGE- or ETC...
    }
}

