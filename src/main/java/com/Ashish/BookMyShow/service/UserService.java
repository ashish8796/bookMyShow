package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.model.User;
import com.Ashish.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User signup(String name, String email ,String password )  {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setTickets(new ArrayList<>());
        return userRepository.save(user);
    }
}
