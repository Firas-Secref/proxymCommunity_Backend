package com.proxymcommunity.proxymCommunity.controller;

import com.proxymcommunity.proxymCommunity.entity.Likes;
import com.proxymcommunity.proxymCommunity.repository.LikesRepository;
import com.proxymcommunity.proxymCommunity.services.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeControler {

    @Autowired
    private LikesService service;

    public LikeControler(LikesService service) {
        this.service = service;
    }

    @PostMapping("/like")
    public Likes like(@RequestBody Likes like){
       return this.service.add(like);
    }

    @GetMapping("/likesNb/{id}")
    public int nbLikes(@PathVariable Long id){
        return this.service.whoLikeThePost(id);
    }

    @GetMapping("/likesByPost/{postId}/{likerId}")
    public boolean userLikePost(@PathVariable Long postId, @PathVariable Long likerId){
        return this.service.userLikePost(postId, likerId);
    }

    @DeleteMapping("/deleteLike/{likerId}/{postId}")
    public int delete(@PathVariable Long likerId, @PathVariable Long postId){
       return this.service.deletLike(likerId, postId);
    }
}
