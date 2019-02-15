package com.example.demo21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    public UserRepository userRepository;


    @GetMapping("/all")
    public Iterable<Users> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/add")
    public String addUser(String name) {
        Users newUser = new Users();
        newUser.setName(name);
        userRepository.save(newUser);
        return "Saved";
    }

    @GetMapping("/delOneUser")
    public String delUser(int id) {
        userRepository.deleteById(id);
        return "DELETED";
    }

    @GetMapping("/delAll")
    public String dellAll() {
        userRepository.deleteAll();
        return "ALL_DELETED";
    }

    @GetMapping("/findOne")
    public Optional<Users> findOne(int id) {
        return userRepository.findById(id);
    }

    @GetMapping("/update/{id}")
    public Users update(@PathVariable int id, @RequestParam String name) {
        Users user = userRepository.findById(id).get();
        user.setName(name);
        return userRepository.save(user);
    }

}
