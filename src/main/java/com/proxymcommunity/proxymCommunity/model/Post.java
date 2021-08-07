package com.proxymcommunity.proxymCommunity.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Post implements Serializable {

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
}
