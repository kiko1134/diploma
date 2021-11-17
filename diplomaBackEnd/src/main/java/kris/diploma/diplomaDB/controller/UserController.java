package kris.diploma.diplomaDB.controller;


import kris.diploma.diplomaDB.model.User;
import kris.diploma.diplomaDB.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/users")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){return userService.getUsers();}

    @PostMapping
    public void registerNewUser(@RequestBody User user){userService.addNewUser(user);}

    @DeleteMapping(path = "{user_id}")
    public void deleteUser(@PathVariable("user_id") Long user_id){userService.deleteUser(user_id);}

    @PutMapping(path = "{user_id}")
    public void updateUser(@PathVariable("user_id") Long user_id,
                           @RequestParam(required = false) String name,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String password){
        userService.updateUser(user_id,name,email,password);
    }
}