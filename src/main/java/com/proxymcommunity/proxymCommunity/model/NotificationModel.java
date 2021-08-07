package com.proxymcommunity.proxymCommunity.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class NotificationModel implements Serializable {

    private String from_firstname;
    private String from_lastname;
    private Long from_userId;
    private String to_firstname;
    private String to_lastname;
    private Long to_userId;
    private String action;
}
