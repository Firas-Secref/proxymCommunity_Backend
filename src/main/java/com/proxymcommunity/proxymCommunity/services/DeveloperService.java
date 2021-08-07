package com.proxymcommunity.proxymCommunity.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proxymcommunity.proxymCommunity.entity.Developer;
import com.proxymcommunity.proxymCommunity.exception.UserNotFoundException;
import com.proxymcommunity.proxymCommunity.model.Login;
import com.proxymcommunity.proxymCommunity.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository repository;

    @Autowired
    private FriendsService friendsService;

    public String encodePassword(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }

    public DeveloperService(DeveloperRepository repository, FriendsService friendsService) {
        this.repository = repository;
        this.friendsService = friendsService;
    }

    public Developer register1(Developer developer){
        String encodedPassword = this.encodePassword(developer.getPassword());
        developer.setPassword(encodedPassword);
       return repository.save(developer);
    }

    public Developer findByUsername(String username){
        return this.repository.findDeveloperByUsername(username);
    }

    public Developer update(Long id, Developer developer){

        Developer existingDeveloper = this.repository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("this user does not exist")
        );
        existingDeveloper.setFirstName(developer.getFirstName());
        existingDeveloper.setLastName(developer.getLastName());
        existingDeveloper.setVille(developer.getVille());
        existingDeveloper.setAddress(developer.getAddress());
        existingDeveloper.setPays(developer.getPays());
        existingDeveloper.setProfileImage(developer.getProfileImage());
        existingDeveloper.setDepartement(developer.getDepartement());
        existingDeveloper.setProfile(developer.getProfile());
        return repository.save(existingDeveloper);
    }

    public boolean login(Login coords){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Developer existingDeveloper = this.findByUsername(coords.getUsername());
        if(existingDeveloper!= null){
            System.out.println(existingDeveloper.getPassword());
            if (passwordEncoder.matches(coords.getPassword(), existingDeveloper.getPassword())){
                return true;
            }else
                return false;
        }
        return false;
    }

    public void updateProfileImage(Long id, MultipartFile file) throws IOException {
        Developer existingDeveloper = this.repository.findById(id).orElseThrow(
                ()-> new UserNotFoundException("this user does not exist")
        );
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")){
            System.out.println("not a valide file");
        }
        existingDeveloper.setProfileImage(Base64.getEncoder().encodeToString(file.getBytes()));
        this.repository.save(existingDeveloper);

    }

    public void register(String user ,MultipartFile file) throws IOException {
        Developer newDeveloper = new ObjectMapper().readValue(user, Developer.class);

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")){
            System.out.println("not a valide file");
        }
        String encodedPassword = this.encodePassword(newDeveloper.getPassword());
        newDeveloper.setPassword(encodedPassword);
        newDeveloper.setProfileImage(Base64.getEncoder().encodeToString(file.getBytes()));
        this.repository.save(newDeveloper);
    }

    public List<Developer> getAllUsers(Long userId){
        List<Developer> allUsers =  this.repository.findAll();
        List<Developer> followsList = this.friendsService.getMyList(userId);
        List<Developer> usersWithoutMe = allUsers.stream()
                .filter(u-> u.getId()!=userId)
                .collect(Collectors.toList());
        usersWithoutMe.removeAll(followsList);

        return usersWithoutMe;
    }

}
