package com.proxymcommunity.proxymCommunity.dto;

import com.proxymcommunity.proxymCommunity.entity.Developer;
import com.proxymcommunity.proxymCommunity.entity.Publication;
import lombok.Data;

import java.io.Serializable;

@Data
public class PublicationsDTO implements Serializable {

    private Long id;
    private String text;
    private String image1;
    private Long likesNb;
    private String userImage;
    private String categorie;
    private String username;
    private String firstName;
    private String lastName;
    private String profileUser;
    private String userDepartment;
    private boolean iLikeIt;
    private Long userId;
}
