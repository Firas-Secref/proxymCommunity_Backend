package com.proxymcommunity.proxymCommunity.controller;

import com.proxymcommunity.proxymCommunity.entity.Developer;
import com.proxymcommunity.proxymCommunity.entity.Friends;
import com.proxymcommunity.proxymCommunity.services.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendsControler {

    @Autowired
    private FriendsService service;

    public FriendsControler(FriendsService service) {
        this.service = service;
    }

    @PostMapping("/follow")
    public Long follow(@RequestBody Friends friends){
       return this.service.follow(friends);
    }

    @GetMapping("/followList/{id}")
    public List<Developer> getMyList(@PathVariable Long id){
        return this.service.getMyList(id);
    }
}
