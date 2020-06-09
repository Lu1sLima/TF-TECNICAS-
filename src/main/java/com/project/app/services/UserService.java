package com.project.app.services;

import com.project.app.entities.User;
import com.project.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Boolean addUser(User user){
        User userSalvo = userRepository.save(user);
        if(userSalvo != null){ return true;}
        else{return false;}
    }

    public User findUserByEmail(String email){
        User userSalvo = userRepository.findByEmail(email);
        return userSalvo;
    }

    public Boolean autenticaUser(String email, String password){
        User user = userRepository.findByEmail(email);
        if(user!= null){
            if(password.equals(user.getPassword())){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }

    }
}