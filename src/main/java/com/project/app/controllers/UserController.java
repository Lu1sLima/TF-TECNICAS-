package com.project.app.controllers;


import com.project.app.entities.User;
import com.project.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        if (userService.addUser(user)) {
            return new ResponseEntity("user Created", HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/autentica/{email}/{password}")
    public ResponseEntity<Boolean> autenticaUser(@PathVariable String email, @PathVariable String password) {
        if (userService.autenticaUser(email, password) == true) {
            return new ResponseEntity(userService.findUserByEmail(email), HttpStatus.OK);
        } else {
            return new ResponseEntity("Usuario ou senha invalida", HttpStatus.BAD_REQUEST);
        }
    }
}