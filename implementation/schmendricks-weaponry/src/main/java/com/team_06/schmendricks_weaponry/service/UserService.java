package com.team_06.schmendricks_weaponry.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import com.team_06.schmendricks_weaponry.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
@SessionScope
public class UserService {

    @Autowired
    private CartService cartService;

    private ObjectMapper mapper = new ObjectMapper();
    private File userDataFile = new File("src/main/resources/data/UserData.json");

    private User currentUser = new User();

    // Load all users from JSON
    public ArrayList<User> loadUsers() {
        try {
            return mapper.readValue(userDataFile, new TypeReference<ArrayList<User>>() { } );
        } catch(Exception e) {
            System.out.print(e.getMessage());
            return new ArrayList<>();
        }
    }

    // Save all users to JSON
    public void saveUsers(ArrayList<User> userList) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(userDataFile, userList);
    }

    // Add a new user
    public void addUser(User newUser) throws IOException {
        ArrayList<User> userList = loadUsers();

        // Set the new user's ID before adding
        newUser.setUserId(userList.size());

        userList.add(newUser);
        saveUsers(userList);
    }

    // Set the currently logged-in user
    public void setCurrentUser(User u) {
        currentUser = u;
    }

    // Get the currently logged-in user
    public User getCurrentUser() {
        return currentUser;
    }
}
