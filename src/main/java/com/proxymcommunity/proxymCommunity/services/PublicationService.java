package com.proxymcommunity.proxymCommunity.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proxymcommunity.proxymCommunity.entity.Developer;
import com.proxymcommunity.proxymCommunity.entity.Publication;
import com.proxymcommunity.proxymCommunity.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationService {

    @Autowired
    private PublicationRepository repository;

    @Autowired
    private LikesService likesService;

    @Autowired
    private FriendsService friendsService;


    public PublicationService(PublicationRepository repository, LikesService likesService, FriendsService friendsService) {
        this.repository = repository;
        this.likesService = likesService;
        this.friendsService = friendsService;
    }

    public List<Publication> getAll(Long userId){
        List<Publication> posts = this.repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<Publication> publications;
        for(Publication p: posts){
            p.setLikesNb(this.likesService.whoLikeThePost(p.getId()));
        }
        for(Publication p: posts){
            p.setILikeIt(this.likesService.userLikePost(p.getId(),userId));
        }

        return posts;
    }

    public Publication newPost(MultipartFile file, String pub, String user) throws IOException {
        Publication newPub = new ObjectMapper().readValue(pub, Publication.class);
        Developer thatDev = new ObjectMapper().readValue(user, Developer.class);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")){
            System.out.println("not a valide file");
        }
        System.out.println("aaaaa"+newPub.getLikesNb());

        newPub.setDeveloper(thatDev);
        newPub.setImage1(Base64.getEncoder().encodeToString(file.getBytes()));
        System.err.println("post added ..");
        return this.repository.save(newPub);
    }

    public List<Publication> getMyPosts(Long id){
        List<Publication> posts =  this.repository.findByDeveloper_Id(id, Sort.by(Sort.Direction.DESC, "id"));
        List<Publication> publications;
        for(Publication p: posts){
            p.setLikesNb(this.likesService.whoLikeThePost(p.getId()));
        }
        for(Publication p: posts){
            p.setILikeIt(this.likesService.userLikePost(p.getId(),id));
        }

        return posts;
    }

    public List<Publication> getMyFriendsPosts(Long userId){

        List<Publication> allPosts = this.repository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<Developer> friends = this.friendsService.getMyList(userId);
        List<Long> friendsId = friends.stream()
                .map(f-> f.getId())
                .collect(Collectors.toList());
        friendsId.add(userId);
        List<Publication> friendsPosts = new ArrayList<>();
        for (Publication p : allPosts){
            for (Long idF: friendsId){
                if (p.getDeveloper().getId() == idF){
                    friendsPosts.add(p);
                    p.setLikesNb(this.likesService.whoLikeThePost(p.getId()));
                    p.setILikeIt(this.likesService.userLikePost(p.getId(),userId));
                }
            }
        }
        System.err.println(friendsId);
        return friendsPosts;

    }


}
