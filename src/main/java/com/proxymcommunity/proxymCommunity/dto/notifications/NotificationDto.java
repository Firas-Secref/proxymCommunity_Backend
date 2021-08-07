package com.proxymcommunity.proxymCommunity.dto.notifications;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class NotificationDto implements Serializable {

    private String from_firstname;
    private String from_lastname;
    private String from_username;
    private Long from_userId;
    private String to_firstname;
    private String to_lastname;
    private String to_username;
    private String to_userImage;
    private Long to_userId;
    private String action;

}
