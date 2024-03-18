package com.Ashish.BookMyShow.service;

import com.Ashish.BookMyShow.exception.UserException.InvalidPasswordException;
import com.Ashish.BookMyShow.exception.UserException.UserDoesNotExistsException;
import com.Ashish.BookMyShow.model.Ticket;
import com.Ashish.BookMyShow.model.User;
import com.Ashish.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setTickets(new ArrayList<>());

        User savedUser = userRepository.save(user);
        System.out.println(userRepository.findUserByEmail(savedUser.getEmail()));
        return savedUser;
    }

    public User login (String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if(user == null) {
            throw  new UserDoesNotExistsException("User does not exists with this email.");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new InvalidPasswordException("Invalid Password.");
        }
    }

    public boolean userExists(String email) {
        User user = userRepository.findUserByEmail(email);
        return user != null;
    }

    public User getUserById(int userId) {
        return userRepository.findById(userId).get();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
