package com.proxymcommunity.proxymCommunity.services;

import com.proxymcommunity.proxymCommunity.entity.Developer;
import com.proxymcommunity.proxymCommunity.entity.Friends;
import com.proxymcommunity.proxymCommunity.repository.DeveloperRepository;
import com.proxymcommunity.proxymCommunity.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendsService {

    @Autowired
    private FriendsRepository repository;

    @Autowired
    private DeveloperRepository developerRepository;

    public FriendsService(FriendsRepository repository, DeveloperRepository developerRepository) {
        this.repository = repository;
        this.developerRepository = developerRepository;
    }

    public Long follow(Friends friends){
        this.repository.save(friends);
        return friends.getFollowed_Id();
    }

    public List<Developer> getMyList(Long id){
        List<Friends> idList = this.repository.findAll();
        System.out.println(idList);
        List<Developer> followed = idList.stream()
                .filter(item-> item.getFollower_Id() ==id  )
                .map(s-> this.developerRepository.findDeveloperById(s.getFollowed_Id()))
                .collect(Collectors.toList());
        return followed;
    }

}
