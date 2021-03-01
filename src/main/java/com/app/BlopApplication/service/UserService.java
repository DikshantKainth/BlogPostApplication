package com.app.BlopApplication.service;

import com.app.BlopApplication.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //Contains all the business logic and communicate to database.
    public boolean login(User user){
        if(user.getUsername().equals("Dikshant") && user.getPassword().equals("chitkara"))
            return true;
        else
            return false;
    }
}
