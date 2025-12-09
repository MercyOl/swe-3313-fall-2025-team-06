package com.team_06.schmendricks_weaponry;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class UserService {
    private ObjectMapper mapper = new ObjectMapper();
    private File userDataFile = new File("src/main/resources/data/UserData.json");

    public ArrayList<User> loadUsers(){
        try {
            return mapper.readValue(userDataFile, new TypeReference<ArrayList<User>>() { } );
        }catch(Exception e){
            System.out.print(e.getMessage());

            //return an empty list of Users
            return new ArrayList<User>();
        }
    }

    public void saveUsers(ArrayList<User> userList) throws IOException{
        mapper.writerWithDefaultPrettyPrinter().writeValue(userDataFile, userList);
    }

    public void addUser(User newUser) throws IOException{
        ArrayList<User> userList = loadUsers();

        // Set the new user's ID before adding to the list
        newUser.setUserId(userList.size());

        userList.add(newUser);
        saveUsers(userList);
    }
}
