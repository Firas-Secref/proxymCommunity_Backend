package com.proxymcommunity.proxymCommunity.converter;

import com.proxymcommunity.proxymCommunity.dto.notifications.*;
import com.proxymcommunity.proxymCommunity.entity.Notification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NotificationConverter {

    public NotificationDto entityToLikeDto(Notification notif){
        NotificationLikeDto dto = new NotificationLikeDto();
        dto.setAction(notif.getAction());
        dto.setFrom_firstname(notif.getDeveloper().getFirstName());
        dto.setFrom_lastname(notif.getDeveloper().getLastName());
        dto.setFrom_userId(notif.getDeveloper().getId());
        dto.setFrom_username(notif.getDeveloper().getUsername());
        dto.setTo_userImage(notif.getDeveloper().getProfileImage());

        dto.setTo_firstname(notif.getTo_firstname());
        dto.setTo_lastname(notif.getTo_lastname());
        dto.setTo_username(notif.getTo_username());
        dto.setTo_userId(notif.getTo_userId());
        dto.setNotificationText(notif.getNotificationText());
        return dto;
    }

    public List<NotificationDto> entityToLikeDto(List<Notification> publications){
        return publications.stream()
                .map(x -> entityToLikeDto(x))
                .collect(Collectors.toList());
    }

    public NotificationDto entityToPostDto(Notification notif){
        NotificationPostDto dto = new NotificationPostDto();
        dto.setAction(notif.getAction());
        dto.setFrom_firstname(notif.getDeveloper().getFirstName());
        dto.setFrom_lastname(notif.getDeveloper().getLastName());
        dto.setFrom_userId(notif.getDeveloper().getId());
        dto.setFrom_username(notif.getDeveloper().getUsername());
        dto.setTo_userImage(notif.getDeveloper().getProfileImage());

        dto.setTo_firstname(notif.getTo_firstname());
        dto.setTo_lastname(notif.getTo_lastname());
        dto.setTo_username(notif.getTo_username());
        dto.setTo_userId(notif.getTo_userId());
        dto.setNotificationText(notif.getNotificationText());

        return dto;
    }

    public List<NotificationDto> entityToPostDto(List<Notification> publications){
        return publications.stream()
                .map(x -> entityToPostDto(x))
                .collect(Collectors.toList());
    }

    public NotificationDto entityToFollowDto(Notification notif){
        NotificationFollowDto dto = new NotificationFollowDto();
        dto.setAction(notif.getAction());
        dto.setFrom_firstname(notif.getDeveloper().getFirstName());
        dto.setFrom_lastname(notif.getDeveloper().getLastName());
        dto.setFrom_userId(notif.getDeveloper().getId());
        dto.setFrom_username(notif.getDeveloper().getUsername());
        dto.setTo_userImage(notif.getDeveloper().getProfileImage());

        dto.setTo_firstname(notif.getTo_firstname());
        dto.setTo_lastname(notif.getTo_lastname());
        dto.setTo_username(notif.getTo_username());
        dto.setTo_userId(notif.getTo_userId());
        dto.setNotificationText(notif.getNotificationText());
        return dto;
    }

    public List<NotificationDto> entityToFollowDto(List<Notification> publications){
        return publications.stream()
                .map(x -> entityToFollowDto(x))
                .collect(Collectors.toList());
    }

    public NotificationDto entityToBasicDto(Notification notif){
        NotificationDtoBasic dto = new NotificationDtoBasic();
        dto.setAction(notif.getAction());
        dto.setFrom_firstname(notif.getDeveloper().getFirstName());
        dto.setFrom_lastname(notif.getDeveloper().getLastName());
        dto.setFrom_userId(notif.getDeveloper().getId());
        dto.setFrom_username(notif.getDeveloper().getUsername());
        dto.setTo_userImage(notif.getDeveloper().getProfileImage());

        dto.setTo_firstname(notif.getTo_firstname());
        dto.setTo_lastname(notif.getTo_lastname());
        dto.setTo_username(notif.getTo_username());
        dto.setTo_userId(notif.getTo_userId());
        dto.setNotificationText(notif.getNotificationText());
        return dto;
    }

    public List<NotificationDto> entityToBasicDto(List<Notification> publications){
        return publications.stream()
                .map(x -> entityToBasicDto(x))
                .collect(Collectors.toList());
    }


}
