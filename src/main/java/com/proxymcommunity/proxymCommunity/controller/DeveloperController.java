package com.proxymcommunity.proxymCommunity.controller;

import com.proxymcommunity.proxymCommunity.entity.Developer;
import com.proxymcommunity.proxymCommunity.model.Login;
import com.proxymcommunity.proxymCommunity.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class DeveloperController {

    @Autowired
    private DeveloperService service;

    public DeveloperController(DeveloperService service) {
        this.service = service;
    }


    @PostMapping("/login")
    public boolean login(@RequestBody Login coords){
        return this.service.login(coords);
    }

    @GetMapping("/findByName/{name}")
    public Developer getByName(@PathVariable String name){
        return this.service.findByUsername(name);
    }

    @PostMapping("/update/{id}")
    public Developer updateDeveloper(@PathVariable Long id, @RequestBody Developer developer){
        return this.service.update(id, developer);
    }

    @PostMapping("/updateImage/{id}")
    public void updateImage(@PathVariable Long id, @RequestParam("image")MultipartFile image) throws IOException {
        this.service.updateProfileImage(id, image);
    }

    @PostMapping("/register")
    public String register(@RequestParam("user") String user, @RequestParam("profileImg") MultipartFile image) throws IOException {
        this.service.register(user, image);
        return "register OK";
    }

    @GetMapping("/allUsers/{userId}")
    public List<Developer> allUsers(@PathVariable Long userId){
        return this.service.getAllUsers(userId);
    }
}

