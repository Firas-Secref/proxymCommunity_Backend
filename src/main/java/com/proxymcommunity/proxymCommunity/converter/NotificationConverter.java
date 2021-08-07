package com.proxymcommunity.proxymCommunity.converter;

import com.proxymcommunity.proxymCommunity.dto.notifications.NotificationDto;
import com.proxymcommunity.proxymCommunity.entity.Notification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NotificationConverter {

    public NotificationDto entityToDto(Notification notif){
        NotificationDto dto = new NotificationDto();
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

        return dto;
    }

    public List<NotificationDto> entityToDto(List<Notification> publications){
        return publications.stream()
                .map(x -> entityToDto(x))
                .collect(Collectors.toList());
    }
}
