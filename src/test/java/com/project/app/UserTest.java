package com.project.app;

import com.project.app.entities.User;
import com.project.app.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void shouldFindUserByEmail(){
        User user = userService.findUserByEmail("admin@admin.com");
        Assert.assertEquals("admin", user.getName());
    }

    @Test
    public void shouldAddUser(){
        User user = new User("test","test@test.com","test","5132433233","POA");
        userService.addUser(user);

        Assert.assertEquals("test",userService.findUserByEmail("test@test.com").getName());
        Assert.assertEquals("test@test.com",userService.findUserByEmail("test@test.com").getEmail());
        Assert.assertEquals("test",userService.findUserByEmail("test@test.com").getPassword());
        Assert.assertEquals("5132433233",userService.findUserByEmail("test@test.com").getContact());
        Assert.assertEquals("POA",userService.findUserByEmail("test@test.com").getCity());


    }

    @Test
    public void shouldAutenticarUser(){
        User user = new User("test1","test1@test1.com","test1","5132433233","POA");
        userService.addUser(user);

        Assert.assertTrue(userService.autenticaUser("test1@test1.com","test1"));
    }

    @Test
    public void shouldNotAutenticarUserWhenEmailIsInvalid(){
        User user = new User("test2","test2@test2.com","test2","5132433233","POA");
        userService.addUser(user);

        Assert.assertFalse(userService.autenticaUser("test3213@test.com","test2"));
    }

    @Test
    public void shouldNotAutenticarUserWhenPasswordIsInvalid(){
        User user = new User("test2","test3@test3.com","test3","5132433233","POA");
        userService.addUser(user);

        Assert.assertFalse(userService.autenticaUser("test3@test3.com","test324"));
    }



}
