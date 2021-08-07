package com.proxymcommunity.proxymCommunity.controller;

import com.proxymcommunity.proxymCommunity.converter.PublicationConverter;
import com.proxymcommunity.proxymCommunity.dto.PublicationsDTO;
import com.proxymcommunity.proxymCommunity.entity.Publication;
import com.proxymcommunity.proxymCommunity.services.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class PublicationControler {

    @Autowired
    private PublicationService service;
    @Autowired
    private PublicationConverter converter;

    public PublicationControler(PublicationService service) {
        this.service = service;
    }

    @PostMapping("/addPost")
    public PublicationsDTO addNewPatient(@RequestParam("pubImage") MultipartFile file, @RequestParam("pub") String pub, @RequestParam("user") String user) throws IOException {
        return this.converter.entityToDto(this.service.newPost(file, pub, user)) ;
    }

    @GetMapping("/getAllPosts/{userId}")
    public List<PublicationsDTO> getAllPub(@PathVariable long userId){
        List<Publication> allPosts = this.service.getAll(userId);
        return this.converter.entityToDto(allPosts);
    }

    @GetMapping("/myPosts/{id}")
    public List<PublicationsDTO> getMyPosts(@PathVariable Long id){
        List<Publication> myPosts = this.service.getMyPosts(id);
        return this.converter.entityToDto(myPosts);

    }

    @GetMapping("/getFriendsPosts/{id}")
    public List<PublicationsDTO> getMyFrienPosts(@PathVariable("id") Long id){
        List<Publication> posts = this.service.getMyFriendsPosts(id);
        return this.converter.entityToDto(posts);
    }
}
