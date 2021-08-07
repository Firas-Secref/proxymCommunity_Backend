package com.proxymcommunity.proxymCommunity.services;

import com.proxymcommunity.proxymCommunity.entity.Developer;
import com.proxymcommunity.proxymCommunity.entity.Likes;
import com.proxymcommunity.proxymCommunity.entity.Publication;
import com.proxymcommunity.proxymCommunity.repository.DeveloperRepository;
import com.proxymcommunity.proxymCommunity.repository.LikesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LikesService {

    @Autowired
    private LikesRepository repository;

    @Autowired
    private DeveloperRepository developerRepository;

    public LikesService(LikesRepository repository, DeveloperRepository developerRepository) {
        this.repository = repository;
        this.developerRepository = developerRepository;
    }

    public Likes add(Likes likes){
       return this.repository.save(likes);
    }

    public int whoLikeThePost(Long id){
        List<Likes> allLikes = this.repository.findAll();
        List<Developer> likers =  allLikes.stream()
                .filter(item-> item.getPost_Id() ==id  )
                .map(like-> this.developerRepository.findDeveloperById(like.getLiker_Id()))
                .collect(Collectors.toList());
        return likers.size();
    }

    public boolean userLikePost(Long id, Long likerId){
        List<Likes> allLikesForThisPost = this.repository.getAlByPost_Id(id);
        for (Likes like: allLikesForThisPost){
            if (like.getLiker_Id() == likerId){
                return true;
            }
        }
        return false;
    }

    public int deletLike(Long likerId, Long postId){
        return this.repository.deleteLik(likerId, postId);
    }
}
